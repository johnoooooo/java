package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import enginee.Animation;
import enginee.GameObject;
import enginee.InputMsg;

public class Boom extends GameObject{
	//动画效果，坐标移动最好只有一个
	Animation boom;//的动画
	
	Animation current;//当前动画
	private boolean button;
	public Boom(){
		init();
	}
	@Override
	public void init() {
		//当前站立的动画
		ArrayList<String> paths=new ArrayList<>();
		String s="image/OO/image";
		for(int i=0;i<5;i++){
			paths.add(s+(865+2*i)+".png");
		}
		boom=Animation.createAni(paths, Conf.preUnitDelay);
		this.current=boom;
		//当前走动的动画
		
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(current.currentImage(), this.x, this.y, null);
		
	}
	@Override
	public void update() {
	}
}
	/**
	 * 状态切换，也是动画切换
	 * @param s
	 */
