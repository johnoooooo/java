package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import enginee.Animation;
import enginee.GameObject;
import enginee.InputMsg;

public class Playerbird extends GameObject{
	//����Ч���������ƶ����ֻ��һ��
	private Animation idle;//վ���Ķ���
	//Animation walk;//�߶��Ķ���
	private Animation cur;//��ǰ����
	static int x=413;
	static int y=413;
	private boolean button;
	public Playerbird(){
		this.x=413;
		this.y=413;
		init();
	}
	@Override
	public void init() {
		//�ɻ�����
		ArrayList<String> paths=new ArrayList<>();
		String s="image/OO/hero";
		for(int i=0;i<2;i++){
			paths.add(s+i+".png");
		}
		idle=Animation.createAni(paths, Conf.preUnitDelayP);
		this.cur=idle;
		
		
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(cur.currentImage(), this.x, this.y, null);
		
	}
	@Override
	public void update() {
		InputMsg inputMsg=InputMsg.createKey();
		//�жϵ�ǰ�����Ƿ���A
		//button=false;
		if(inputMsg.getkeystatus(KeyEvent.VK_A)&&x>0){
			//button=true;
			this.x-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_D)&&x<1002){
			//button=true;
			this.x+=5;
		}
		
		if(inputMsg.getkeystatus(KeyEvent.VK_W)&&y>0){
			//button=true;
			this.y-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_S)&&y<450){
			//button=true;
			this.y+=5;
		}
		//changestatus();
	}
}
	/**
	 * ״̬�л���Ҳ�Ƕ����л�
	 * @param s
	 */