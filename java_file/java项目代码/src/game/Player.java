package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import enginee.Animation;
import enginee.GameObject;
import enginee.InputMsg;

public class Player extends GameObject{
	//动画效果，坐标移动最好只有一个
	private Animation idle;//站立的动画
	private Animation walk;//走动的动画
	private Animation current;//当前动画
	private int x;
	private int y;
	private boolean button;
	public Player(){
		x=413;
		y=413;
		init();
	}
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
	@Override
	public void init() {
		//当前站立的动画
		ArrayList<String> idles=new ArrayList<>();
		String s="image/soulofwar/image148";
		for(int i=0;i<4;i++){
			idles.add(s+2*i+".png");
		}
		idle=Animation.createAni(idles, 6);
		//当前走动的动画
		ArrayList<String> walks=new ArrayList<>();
		String sw="image/soulofwar/image149";
		for(int i=0;i<4;i++){
			walks.add(sw+(2*i+1)+".png");
		}
		walk=Animation.createAni(walks,6);
		//this.current=idle;//让当前动画为站立的动画
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(current.currentImage(), this.x, this.y, null);
		
	}
	@Override
	public void update() {
		InputMsg inputMsg=InputMsg.createKey();
		//判断当前按键是否是A
		button=false;
		if(inputMsg.getkeystatus(KeyEvent.VK_A)&&x>0){
			button=true;
			this.x-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_D)&&x<1002){
			button=true;
			this.x+=5;
		}
		
		if(inputMsg.getkeystatus(KeyEvent.VK_W)&&y>0){
			button=true;
			this.y-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_S)&&y<400){
			button=true;
			this.y+=5;
		}
		changestatus();
	}
	/**
	 * 状态切换，也是动画切换
	 * @param s
	 */
	public void changestatus() {
		if(button) {
			this.current=walk;
		}
		else {
			this.current=idle;
		}
	}
	
}
