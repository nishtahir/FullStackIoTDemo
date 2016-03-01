package com.nishtahir.holidayhacking.controller

import org.eclipse.jetty.websocket.api.Session
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage
import org.eclipse.jetty.websocket.api.annotations.WebSocket
import spark.Spark

@WebSocket
public class DeviceController implements IController {

    @Override
    public void init() {
        Spark.webSocket("/device", this.class)
    }

    static List<Session> sessionList = new ArrayList<>()

    @OnWebSocketConnect
    void onConnect(Session session) {
        sessionList.add(session)
    }

    @OnWebSocketClose
    void onClose(Session session, int statusCode, String reason) {
        sessionList.remove(session)
    }

    @OnWebSocketMessage
    void onMessage(Session session, String message) {
        println(message)
        sessionList.each {
            try {
                it.remote.sendString(message)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
