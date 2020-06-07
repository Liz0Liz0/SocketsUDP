package SocketUDP;

import java.net.*;
import java.util.*;
import java.io.*;

public class Servidor {
	public static int countString(String mensaje) {
		StringTokenizer message = new StringTokenizer(mensaje);
		System.out.println("Texto: "+mensaje);
		
		return message.countTokens();
	}
	
	public static void main(String[] args) throws IOException {
		int port = 4444;
		byte msg[] = new byte[1024];
		
		try {
			DatagramSocket socket = new DatagramSocket(port);
			System.out.println("Iniciando servidor... ");
			while(true) {
				
				DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
				
				socket.receive(recibido);
				System.out.println("Peticion recibida");
				
				String mensaje =  new String(recibido.getData());
				String respuesta = "Numero de palabras: "+countString(mensaje);
				msg = mensaje.getBytes();
				System.out.println(respuesta);
				DatagramPacket paquete = new DatagramPacket(msg,msg.length,recibido.getAddress(), recibido.getPort());
				
				socket.send(paquete);
				
				//System.out.println("*Cliente conectado* ");
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
