package 网络编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class 网络编程udp {

	
	public static void main(String[] args) throws Exception {
		System.out.println("发送数据中");
		DatagramSocket client=new DatagramSocket(8888);
		String data="这是待发送的数据之一";
		byte[] datas=data.getBytes();
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("127.0.0.1",6666));
		client.send(packet);
		client.close();
		
		
	}

}
