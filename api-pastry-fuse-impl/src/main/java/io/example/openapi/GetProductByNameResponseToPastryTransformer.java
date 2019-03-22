package io.example.openapi;

import com.github.lbroudoux.pastries.Pastry;
import com.github.lbroudoux.products.ws.Product;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

public class GetProductByNameResponseToPastryTransformer implements Processor {

    @Override
	public void process(Exchange exchange) throws Exception {
        try {
            MessageContentsList mcl = (MessageContentsList) exchange.getIn().getBody();
            Product product = (Product) mcl.get(0);
            
            Pastry pastry = new Pastry();
            pastry.setName(product.getName());
            pastry.setDescription(product.getLongDesc());
            pastry.setSize(product.getSize());
            pastry.setPrice(Double.parseDouble(product.getPrice()));
            pastry.setStatus("available");
            
            exchange.getOut().setBody(pastry);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
    }
}