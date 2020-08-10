package ÓÎÏ·ÏîÄ¿;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtils{

	private GameUtils() {
		// TODO Auto-generated constructor stub
	}
	public static Image getImage(String path) {
		BufferedImage bi=null;
		try {
			URL url=GameUtils.class.getClassLoader().getResource(path);
			System.out.println(url.toString());
			bi=ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bi;
	}
}
