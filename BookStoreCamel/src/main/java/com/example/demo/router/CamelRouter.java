package com.example.demo.router;

import com.example.demo.model.Bookstore;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static org.apache.camel.model.rest.RestParamType.*;

/*
 * Author: Umang Agarwal
 * Description: Bookstore Camel Router
 * Created On: 30/04/2020
 */
@Component
public class CamelRouter extends RouteBuilder {

    @Autowired
    private Environment env;

    @Value("${camel.component.servlet.mapping.context-path}")
    private String contextPath;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .enableCORS(true)
                .port(env.getProperty("server.port", "8080"))
                .contextPath(contextPath.substring(0, contextPath.length() - 2))
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Bookstore API")
                .apiProperty("api.version", "1.0.0");

        rest("/bookstore").description("Bookstore REST service")
                .consumes("application/json")
                .produces("application/json")

                .get("/retrieveAll").description("List all Books").outType(Bookstore[].class)
                .responseMessage().code(200).message("All books successfully returned").endResponseMessage()
                .to("direct:viewAllBooksRoute")

                .get("book/{isbn}").description("Find book by Isbn")
                .outType(Bookstore.class)
                .param().name("isbn").type(path).description("Isbn of the book").dataType("integer").endParam()
                .responseMessage().code(200).message("Book successfully returned").endResponseMessage()
                .to("direct:viewBookByIsbnRoute")

                .delete("book/{isbn}").description("delete book by Isbn")
                .outType(Bookstore.class)
                .param().name("id").type(path).description("Isbn of book").dataType("integer").endParam()
                .responseMessage().code(200).message("Book successfully deleted").endResponseMessage()
                .to("direct:deleteBookByIsbnRoute")

                .post("addBook").description("Add a Book").type(Bookstore.class)
                .param().name("body").type(body).description("Book details").endParam()
                .responseMessage().code(200).message("Book added successfully").endResponseMessage()
                .to("direct:addBookRoute")

                .put("book").description("Update a book").type(Bookstore.class)
                .param().name("body").type(body).description("The book to update").endParam()
                .responseMessage().code(200).message("Book successfully updated").endResponseMessage()
                .to("direct:updateBookRoute");
    }

}
