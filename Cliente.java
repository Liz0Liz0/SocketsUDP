package SocketUDP;

import java.net.*;
import java.util.Scanner;

public class Cliente {
	final static int port = 4444;
	public static void main(String[] args) throws Exception {
		int puerto=4444;
		Scanner in=new Scanner(System.in);
		InetAddress servidorDest = InetAddress.getByName("localhost");
		
		DatagramSocket socket;
		
		
			try {
				
				socket = new DatagramSocket();
				
				System.out.println("Conexion establecida...");
				
				String frase=in.nextLine();
				byte buffer[] = new byte[1024];
				buffer = frase.getBytes();
				DatagramPacket paqEnvio = new DatagramPacket(buffer,buffer.length,servidorDest,puerto);
				socket.send(paqEnvio);
							
				
				byte buffer1[] = new byte[1024];
				DatagramPacket paqueteRecep = new DatagramPacket(buffer1,buffer1.length);
				socket.receive(paqueteRecep);
				
				String mensajeRecibido = new String(paqueteRecep.getData());  
				
				
				System.out.println("Mensaje recibido: "+mensajeRecibido);
				
				socket.close();
				System.out.println("Conexion Finalizada...");
				
			} catch (Exception e) {
				
			}
	}
}
