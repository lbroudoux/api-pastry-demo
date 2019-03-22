package io.example.openapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.github.lbroudoux.products.ws.GetProductByName;

public class GetProductByNameComposer implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
        GetProductByName getProductByName = new GetProductByName();

        getProductByName.setName(exchange.getIn().getHeader("name", String.class));

		exchange.getIn().setBody(getProductByName.getName());
	}
}