package io.example.openapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class EchoProcessor implements Processor {

    @Override
	public void process(Exchange exchange) throws Exception {
        System.err.println("in.body: " + exchange.getIn().getBody());
        System.err.println("in.body.class: " + exchange.getIn().getBody().getClass().getName());
	}
}