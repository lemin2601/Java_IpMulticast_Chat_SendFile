/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*  ww  w .j av  a 2 s .c  o  m*/
public class Receives {

    public static void main(String[] args) throws Exception {
        int mcPort = 12345;
        String mcIPStr = "224.0.0.251";
        MulticastSocket mcSocket = null;
        InetAddress mcIPAddress = null;
        mcIPAddress = InetAddress.getByName(mcIPStr);
        mcSocket = new MulticastSocket(mcPort);
        System.out.println("Multicast Receiver running at:"
                + mcSocket.getLocalSocketAddress());
        mcSocket.joinGroup(mcIPAddress);
        while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            System.out.println("Waiting for a  multicast message...");
            mcSocket.receive(packet);
            String msg = new String(packet.getData(), packet.getOffset(),
                    packet.getLength());
            System.out.println("[Multicast  Receiver] Received:" + msg);

        }

//        mcSocket.leaveGroup(mcIPAddress);
//        mcSocket.close();
    }

}