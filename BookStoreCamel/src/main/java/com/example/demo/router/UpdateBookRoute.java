package com.example.demo.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/*
 * Author: Umang Agarwal
 * Description: Update Book Route
 * Created On: 04/05/2020
 */
@Component("updateBookRoute")
public class UpdateBookRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:updateBookRoute")
                .to("bean:bookService?method=updateBook")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant("Book updated successfully"));
    }
}
