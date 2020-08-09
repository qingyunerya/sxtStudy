package 网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class 网络编程udp2 {

	
	public static void main(String[] args) throws Exception {
		System.out.println("接受数据中");
		DatagramSocket server=new DatagramSocket(6666);
		byte[] container=new byte[1024*60];
		DatagramPacket packet2=new DatagramPacket(container, container.length);
		server.receive(packet2);
		byte[] data2=packet2.getData();
		int len=packet2.getLength();
		System.out.println(new String(data2,0,len));
		server.close();
	}

}
