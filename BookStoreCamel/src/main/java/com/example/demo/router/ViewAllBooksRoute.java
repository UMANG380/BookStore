package com.example.demo.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/*
 * Author: Umang Agarwal
 * Description: View All Book Route
 * Created On: 04/05/2020
 */
@Component("viewAllBooksRoute")
public class ViewAllBooksRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:viewAllBooksRoute")
                .process(exchange -> {
                    System.out.println(exchange.getIn().getBody());

                })
                .to("bean:bookService?method=viewAllBooks");

    }
}
