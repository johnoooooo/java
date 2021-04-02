package enginee;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class GameUtil {
	private GameUtil() {
		
	}
	public static BufferedImage readImage(String path) {
		BufferedImage bi=null;
		try {
			bi=ImageIO.read(new File(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return bi;
		
		
	}

}
