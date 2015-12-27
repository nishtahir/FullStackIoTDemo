package com.nishtahir.holidayhacking.client

import com.fazecast.jSerialComm.SerialPort
import groovy.json.JsonSlurper

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Basic Echo Client Socket
 */

@WebSocket
class WebsocketClientEndpoint {

    final CountDownLatch closeLatch

    Session session
    Client client

    WebsocketClientEndpoint(Client c) {
        this.client = client
        this.closeLatch = new CountDownLatch(1)
    }

    boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit)
    }

    @OnWebSocketClose
    void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown();
    }

    @OnWebSocketConnect
    void onConnect(Session session) {
        System.out.printf("Got connect: %s%n", session.getLocalAddress());
    }

    @OnWebSocketMessage
    void onMessage(String msg) {
        def object = new JsonSlurper().parseText(msg);
        assert object instanceof Map

        client.updateDevice((String) object.type, (boolean) object.state)
    }

}