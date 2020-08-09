package ÍøÂç±à³Ì;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;


public class ÍøÂ·±à³Ìurl {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ad=InetAddress.getLocalHost();
		System.out.println(ad.getHostAddress());
		System.out.println(ad.getHostName());
		ad=InetAddress.getByName("www.baidu.com");
		System.out.println(ad.getHostAddress());
		System.out.println(ad.getHostName());	
		URL url=new URL("https://localhost:8080/index.html?name=nihao&&age=18#1");
		System.out.println(url.getProtocol()+","+url.getHost()+","+url.getPort()+","+url.getFile()+","+url.getPath()+","+url.getQuery()+","+url.getRef());
		InetSocketAddress add=new InetSocketAddress("127.0.0.1", 8080);
		System.out.println(add.getHostName());
		System.out.println(add.getAddress());
		URL url2=new URL("https://www.baidu.com/");
		InputStream is=url2.openStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg=null;
		while(null!=(msg=br.readLine())) {
			System.out.println(msg);
		}
		br.close();
		
		HttpURLConnection conn=(HttpURLConnection)url2.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("user-agent"," Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
		BufferedReader br2=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		while(null!=(msg=br2.readLine())) {
			System.out.println(msg);
		}
		br2.close();
	}

}
