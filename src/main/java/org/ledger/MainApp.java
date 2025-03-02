package org.ledger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.ledger.mapper.LedgerApplicationExceptionMapper;
import org.ledger.mapper.ValidationExceptionMapper;

import java.net.URI;

public class MainApp extends ResourceConfig{

    private static final String ROOT_URL = "http://localhost:8080/api/";

    public static void main(String[] args) throws Exception {
        //start server
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("org.ledger")
                .property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true)
                .register(ValidationExceptionMapper.class)
                .register(LedgerApplicationExceptionMapper.class)
                .register(MainAppBinder.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(ROOT_URL), resourceConfig);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow, "shutdownHook"));
        Thread.currentThread().join();
    }
}