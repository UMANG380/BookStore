package com.example.demo.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/*
 * Author: Umang Agarwal
 * Description: Delete Book By Isbn Route
 * Created On: 04/05/2020
 */
@Component("deleteBookByIsbnRoute")
public class DeleteBookByIsbnRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:deleteBookByIsbnRoute")
                .process(exchange -> {
                    System.out.println(exchange.getIn().getBody());

                })
                .to("bean:bookService?method=deleteBookByIsbn(${header.isbn})");

    }
}
