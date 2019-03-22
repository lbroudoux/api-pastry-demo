package io.example.openapi;

import java.util.ArrayList;
import java.util.List;

import com.github.lbroudoux.pastries.Pastry;
import com.github.lbroudoux.products.ws.Product;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

public class GetProductsResponseToPastryListTransformer implements Processor {

    @Override
	public void process(Exchange exchange) throws Exception {
        List<Pastry> pastries = new ArrayList<>();

        try {
            MessageContentsList mcl = (MessageContentsList) exchange.getIn().getBody();
            List<Product> products = (List<Product>) mcl.get(0);

            for (Product product : products) {
                if (!product.getQuantity().startsWith("0")) {
                    Pastry pastry = new Pastry();
                    pastry.setName(product.getName());
                    pastry.setDescription(product.getLongDesc());
                    pastry.setSize(product.getSize());
                    pastry.setPrice(Double.parseDouble(product.getPrice()));
                    pastry.setStatus("available");
                    pastries.add(pastry);
                }
            }
            
            exchange.getOut().setBody(pastries);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
    }
}