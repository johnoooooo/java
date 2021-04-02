package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import enginee.Animation;
import enginee.GameObject;
import enginee.InputMsg;

public class Bar extends GameObject{
	//����Ч���������ƶ����ֻ��һ��
	//Animation walk;//�߶��Ķ���
	Animation current;//��ǰ����
	private int x;
	private int y;
	private Animation bar;
	private int movey;
	private Random r=new Random();
	private int changey=r.nextInt(2);
	boolean button1;
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
	public int getMovey() {
		return movey;
	}
	public void setMovey(int movey) {
		this.movey=movey;
	}
	public int getChangey() {
		return changey;
	}
	public void setChangey() {
		this.changey=r.nextInt(2);
	}
	public Bar(){
		x=600;
		y=413;
		init();
	}
	@Override
	public void init() {
		//�ϰ��ﶯ��
		ArrayList<String> paths=new ArrayList<>();
		String s="image//OO//";
		for(int i=0;i<1;i++){
			paths.add(s+"bullet_award.png");
		}
		bar=Animation.createAni(paths, Conf.preUnitDelay);
		this.current=bar;
		//��ǰ�߶��Ķ���
		
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(current.currentImage(), this.x, this.y, null);
		
	}
	@Override
	public void update() {
//		if(this.x<-20)
//			this.x=1300;
//		this.x--;
	}
}