oc adm policy add-role-to-user edit system:serviceaccount:microcks:jenkins -n api-pastry-dev
oc adm policy add-role-to-user edit system:serviceaccount:microcks:jenkins -n api-pastry-prod

oc adm policy add-role-to-group system:image-puller system:serviceaccounts:api-pastry-prod -n api-pastry-dev

oc get dc api-pastry-fuse-impl -o json -n api-pastry-dev | jq '.spec.triggers |= []' | oc replace -f - -n api-pastry-dev

oc create deploymentconfig api-pastry-fuse-impl --image=docker-registry.default.svc:5000/api-pastry-dev/api-pastry-fuse-impl:promoteToProd -n api-pastry-prod
oc rollout cancel dc/api-pastry-fuse-impl -n api-pastry-prod
oc get dc api-pastry-fuse-impl -o json -n api-pastry-prod | jq '.spec.triggers |= []' | oc replace -f - -n api-pastry-prod

oc set env dc/api-pastry-fuse-impl SPRING_APPLICATION_JSON="{\"server\":{\"undertow\":{\"io-threads\":1, \"worker-threads\":2 }}}" PRODUCT_WS_URL=http://microcks.apps.144.76.24.92.nip.io/soap/ProductService/1.0.0 KAFKA_BROKER_URL=my-cluster-kafka-bootstrap.amq-streams.svc.cluster.local:9092 -n api-pastry-prod
oc patch dc api-pastry-fuse-impl -n api-pastry-prod -p '{"spec": { "template": {"spec": {"containers": [{"name": "default-container", "imagePullPolicy": "Always"}]}}}}'
oc expose dc api-pastry-fuse-impl --port=8080 -n api-pastry-prod
oc expose svc api-pastry-fuse-impl -n api-pastry-prod

oc tag api-pastry-dev/api-pastry-fuse-impl:latest api-pastry-dev/api-pastry-fuse-impl:promoteToProd
oc rollout latest dc/api-pastry-fuse-impl -n api-pastry-prod

oc process -f apicast-template.yaml \
  --param=APICAST_NAME=api-pastry-api \
  --param=ACCESS_TOKEN=1a56231afd41974e61428922460c493575b756f63b1bb5d306f561e4a1c12ab1 \
  --param=TENANT=lbroudou-redhat | oc create -n api-pastry-prod -f -

oc process -f cicd-pipeline-template.yaml | oc create -n microcks -f -
