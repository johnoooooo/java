package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;


import enginee.GameObject;
import enginee.GameUtil;

public class BackGround extends GameObject{

		public BackGround() {
			init();
		}
		
		public BufferedImage bi=null;
	@Override

	public void init() {
		String sw="image//OO//back.jpg";
		bi=GameUtil.readImage(sw);
		
	}

	@Override
	public void update() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(bi, 0, 0, null);
	}

	
}
