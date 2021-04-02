package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import enginee.Animation;
import enginee.GameObject;

public class Bare extends GameObject{
	//动画效果，坐标移动最好只有一个
	//Animation walk;//走动的动画
	Animation current;//当前动画
	private int x;
	private int y;
	private Animation bar;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x=x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	public Bare(){
		//this.x=413;
		//this.y=413;
		init();
	}
	@Override
	public void init() {
		//当前站立的动画
		ArrayList<String> paths=new ArrayList<>();
		String s="image//OO//";
		for(int i=0;i<1;i++){
			paths.add(s+"airplane.png");
		}
		bar=Animation.createAni(paths, Conf.preUnitDelay);
		this.current=bar;
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
