package com.nishtahir.holidayhacking.client

import com.fazecast.jSerialComm.*
import java.awt.EventQueue
import java.util.*
/**
 * @author Nish, @date 11/30/15 2:23 PM
 */
class Client {
    static main(args) {
        EventQueue.invokeLater( {
                run: {
                    try {
                        Application window = new Application();

                        window.appendLine('==== Available ports ====')
                        List ports = SerialPort.getCommPorts().each {
                            window.appendLine("${it.getSystemPortName()}, baud: ${it.getBaudRate()}")
                        }
                        window.appendLine('==== End Available ports ====')

                        def lines = ports*.getSystemPortName()

                        window.setClickListener {
                            actionPerformed: {

                                SerialPort p = ports.find {
                                    window.getComboBox().getSelectedItem() == it.getSystemPortName()
                                }

                                if(p.openPort()) {
                                    Thread.start({

                                        while(true){
                                            String message = "http://localhost:4567/messages".toURL().text
                                            if(!message.isEmpty()){
                                                byte[] byteArray= new byte[5]
                                                byteArray[0] = Byte.valueOf(message)
                                                p.writeBytes(byteArray, 1L)
                                            }
                                            println new Date()
                                            Thread.sleep(2000);
                                        }

                                    })
                                } else {
                                    window.appendLine('Failed to open port')
                                }
                            }
                        } as java.awt.event.ActionListener

                        window.populateCombo(lines);
                        window.frame.setVisible(true);
                    } catch (all) {
                        e.printStackTrace();
                    }
                }
            } as Runnable)
        // EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //
        //     }
        // });

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        // println "http://localhost:4567/messages".toURL().text

        //println 'Select your device\'s port'
        //SerialPort.getCommPorts().each {
        //    println '1: ' + it.getSystemPortName()
        //}

        //def userInput = br.readLine()
        //println userInput
    }
}
