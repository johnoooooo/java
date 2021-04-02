package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import enginee.Animation;
import enginee.GameObject;
import enginee.InputMsg;

public class Boom extends GameObject{
	//����Ч���������ƶ����ֻ��һ��
	Animation boom;//�Ķ���
	
	Animation current;//��ǰ����
	private boolean button;
	public Boom(){
		init();
	}
	@Override
	public void init() {
		//��ǰվ���Ķ���
		ArrayList<String> paths=new ArrayList<>();
		String s="image/OO/image";
		for(int i=0;i<5;i++){
			paths.add(s+(865+2*i)+".png");
		}
		boom=Animation.createAni(paths, Conf.preUnitDelay);
		this.current=boom;
		//��ǰ�߶��Ķ���
		
		
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
	 * ״̬�л���Ҳ�Ƕ����л�
	 * @param s
	 */
