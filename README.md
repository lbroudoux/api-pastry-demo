# api-pastry-demo

API Pastry Demo using Agile Integration Solutions

[![Contribute](https://che.openshift.io/factory/resources/factory-contribute.svg)]
(http://che-eclipse-che.apps.cluster-paris-e9b4.paris-e9b4.example.opentlc.com/f?url=https://github.com/lbroudoux/api-pastry-demo)


```
oc new-project api-pastry-dev --display-name="API Pastry (DEV)"
oc new-project api-pastry-prod  --display-name="API Pastry (PROD)"
```

```
oc create secret generic 3scale-admin-portal-api-pastry-prod --from-literal=access_token=<3scale-token> --from-literal=hostname=<3sclae-admin-host> --from-literal=sso_issuer_endpoint= -n microcks
```

```
mvn clean fabric8:deploy
```

```xml
<route id="route-d072819f-2f2e-4aef-ac3b-69e7cd66b6c3">
    <from id="from-dc5c2eef-9877-48c6-9ada-05ac81f23a65" uri="direct:LikePastry"/>
    <!-- Start of user code -->
    <log id="log1-likePastry" message="LikePastry request processing"/>
    <log id="log2-likePastry" message="Payload: ${body}"/>
    <!-- <to id="kafka-publishLike" uri="kafka:pastries.likes?brokers=my-cluster-kafka-bootstrap-amq-streams.apps.laurent311.openhybridcloud.io:443&amp;groupId=api-pastry-fuse-impl&amp;sslKeystoreLocation=/Users/lbroudou/Development/local/tests/api-pastry-fuse-impl/openshift-router.jks&amp;sslKeystorePassword=changeit&amp;sslKeyPassword=changeit"/> -->
    <marshal>
        <json library="Jackson"/>
    </marshal>
    <process id="process-publishLike" ref="echoProcessor"></process>
    <to id="kafka-publishLike" uri="kafka:pastries.likes?brokers={{kafka-broker-url}}&amp;groupId=api-pastry-fuse-impl"/>
    <log id="log3-likePastry" message="Kafka publication done!"/>
    <setBody>
        <constant>Published</constant> 
    </setBody>
    <!-- End of user code -->
    <!-- <to id="to-e235352a-8941-47f3-b657-9ffbe116d56f" uri="direct:501"/> -->
</route>
```
