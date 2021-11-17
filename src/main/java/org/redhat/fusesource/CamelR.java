package org.redhat.fusesource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.redhat.OutputSOATest;

public class CamelR extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("cxf:bean:CXFTest")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        OutputSOATest out = new OutputSOATest();
                        out.setResult("Hello World");
                        exchange.getOut().setBody(out);
                    }
                })
                .log("Endpoint Triggered");
    }
}
