package ������;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class ������udp {

	
	public static void main(String[] args) throws Exception {
		System.out.println("����������");
		DatagramSocket client=new DatagramSocket(8888);
		String data="���Ǵ����͵�����֮һ";
		byte[] datas=data.getBytes();
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("127.0.0.1",6666));
		client.send(packet);
		client.close();
		
		
	}

}
