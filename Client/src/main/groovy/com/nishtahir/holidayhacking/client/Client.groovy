package com.nishtahir.holidayhacking.client

import com.fazecast.jSerialComm.*
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest
import org.eclipse.jetty.websocket.client.WebSocketClient

import java.awt.EventQueue
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author Nish , @date 11/30/15 2:23 PM
 */
class Client {

    WebsocketClientEndpoint clientEndpoint
    WebSocketClient client

    SerialPort led1;

    Client(){
        Properties properties = new Properties()
        File propertiesFile = new File('Client/config.properties')
        propertiesFile.withInputStream {
            properties.load(it)
        }

        if(properties.getProperty('led1') != null){
            led1 = openSerialConnection(properties.getProperty('led1'))
        }

        println(properties.getProperty('url'))


        client = new WebSocketClient()
        clientEndpoint = new WebsocketClientEndpoint(this)

        try {
            client.start();
            URI echoUri = new URI(properties.getProperty("url"))
            ClientUpgradeRequest request = new ClientUpgradeRequest()
            client.connect(clientEndpoint, echoUri, request)
            System.out.printf("Connecting to : %s%n", echoUri)
            clientEndpoint.awaitClose(Integer.valueOf(properties.getProperty('timeout', '10000')), TimeUnit.MINUTES)
        } catch (Throwable t) {
            t.printStackTrace()
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
    }

    def openSerialConnection(String s) {
        SerialPort port = SerialPort.getCommPort(s);
        port?.openPort();
        port?.addDataListener(new SerialPortPacketListener() {
            @Override
            int getPacketSize() {
                return 0
            }

            @Override
            int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE
            }

            @Override
            void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                    return;
                byte[] newData = new byte[port.bytesAvailable()];
                int numRead = port.readBytes(newData, newData.length);
                System.out.println("Read " + numRead + " bytes.");
            }
        })

        return port
    }

    static main(args) {
        new Client()
    }

    void updateDevice(String type, boolean state) {
        switch (type){
            case 'led1':
                byte[] byteArray= new byte[5]
                byteArray[0] = state ? 1 : 0
                led1.writeBytes(byteArray, 1L)
                break;
        }
    }
}
