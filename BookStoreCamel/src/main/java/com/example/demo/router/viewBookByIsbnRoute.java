package com.example.demo.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/*
 * Author: Umang Agarwal
 * Description: View Book By Isbn Route
 * Created On: 04/05/2020
 */
@Component("viewBookByIsbnRoute")
public class viewBookByIsbnRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:viewBookByIsbnRoute")
                .process(exchange -> {
                    System.out.println(exchange.getIn().getBody());

                })
                .to("bean:bookService?method=viewBookByIsbn(${header.isbn})");


    }
}
