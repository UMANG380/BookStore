package com.example.demo.router;

import com.example.demo.model.Bookstore;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * Author: Umang Agarwal
 * Description: Add Book Route
 * Created On: 04/05/2020
 */
@Component("addBookRoute")
public class AddBookRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:addBookRoute")
                .to("bean:bookService?method=addBook")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant("Book added successfully"));
    }
}
