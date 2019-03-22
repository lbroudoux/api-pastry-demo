package io.example.openapi;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.github.lbroudoux.products.ws.GetProducts;

public class GetProductsComposer implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
        GetProducts getProducts = new GetProducts();

        getProducts.setCategory("pastry");

		exchange.getIn().setBody(getProducts.getCategory());
	}
}