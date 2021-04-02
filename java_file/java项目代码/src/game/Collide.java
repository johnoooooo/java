package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import enginee.Animation;
import enginee.Director;
import enginee.GameObject;
import enginee.GameUtil;
import enginee.InputMsg;

public class Collide extends GameObject{
	
	//����һ��������һ������
	int life=5;
	int score;
	Playerbird playerbird=new Playerbird();
	Bare bare=new Bare();
	static int the_button=0;//������ͣ״̬�İ�ť
	public Collide() {
		init();
	}
	
	ArrayList<Bar> bars=new ArrayList<>();
	private Random r=new Random();
	
	BufferedImage over;
	BufferedImage pause;
	Animation boom;
	boolean  button=false;//�����Ƿ����ӵ��İ�ť
	
	
	@Override
	public void init() {
		//׼�����ӵ�
		for(int i=0;i<8;i++) {
			Bar bar=new Bar();
			bar.setX(r.nextInt(Conf.W)+1200);
			bar.setY(r.nextInt(Conf.H));
			bars.add(bar);
		}
		Boom b=new Boom();
		boom=b.current;
		pause=GameUtil.readImage("image/OO/pause.png");
		over=GameUtil.readImage("image/OO/Over.png");
	}
	
	int xb;//������ײ��x����
	int yb;//������ײ��y����
	int bo;//�ɻ����ϰ�����ײ�ı�ʶ
	int co;//�ӵ����ϰ�����ײ�ı�ʶ
	int boomX;//��ȡ��ײʱ��X����
	int boomY;//��ȡ��ײʱ��Y����
	int end_score=10;//ͨ�ط���
	int speed;//�ϰ����ٶ�
	int zidanspeed=7;
	int sclimit=3;//�ﵽ�÷��������
	//�����ϰ�����ٶ�
	public void the_speed(int sc) {
		sc=sc/sclimit;
		switch(sc) {
		case 0:speed=3;break;
		case 1:speed=5;break;
		case 2:speed=7;break;
		case 3:speed=9;break;
		}
	}
	public void update() {
		if(life>0) {
			xb=playerbird.x;//������ײ��������Ϊ��ҵ�����
			yb=playerbird.y;
			InputMsg inputMsg=InputMsg.createKey();
			if(inputMsg.getkeystatus(KeyEvent.VK_SPACE)){
				button=true;
				bare.setX(Playerbird.x+76);
				bare.setY(Playerbird.y+15);
			}
			if(inputMsg.getkeystatus(KeyEvent.VK_F)) {
				the_button=(++the_button)%2;
				//System.out.println(the_button);
				
			}
			bo=-1;
			co=-1;
			the_speed(score);
			for(int i=0;i<bars.size();i++) {
				Bar b=bars.get(i);
				//�趨�ӵ��켣
				if(b.getX()>-50) {
					//�ж��Ƿ�����ͣ״̬������ִ�У�����ˢ��
					if(the_button==0) {
						
						b.setX(b.getX()-speed);
						if(b.getMovey()>20) {//20��ƫ����
							b.setChangey();//�ı䷽��
							b.setMovey(0);//ƫ�������¿�ʼ�趨
						}else {
							b.setMovey(b.getMovey()+1);
						}
						//�ٶ�1�����ϡ�0����
						if(b.getChangey()==1) {
							b.setY(b.getY()-1);
						}else {
							b.setY(b.getY()+1);
						}
						//�����ϰ��﷢����ײ
						if(b.getX()>=xb&&b.getX()<=xb+76
								&&(b.getY()>=yb&&b.getY()<=yb+59)) {
							//System.out.println(b.getX()+","+b.getY()+";"+xb+","+yb);
							bo=1;
							//�������ӵ����ұ߳���
							b.setX(Conf.W+800);
							b.setY(r.nextInt(400));
							life--;
							
						}
						//�ӵ����ϰ��﷢����ײ
						if(b.getX()>=bare.getX()&&b.getX()<=bare.getX()+32
								&&(b.getY()>=bare.getY()&&b.getY()<=bare.getY()+59)) {
							//System.out.println(b.getX()+","+b.getY()+";"+bare.getX()+","+bare.getY());
							co=1;
							//�������ӵ����ұ߳���
							boomX=bare.getX();
							boomY=bare.getY();
							bare.setX(Conf.W+800);
							bare.setY(r.nextInt(400));
							b.setX(Conf.W+800);
							b.setY(r.nextInt(400));
							score++;
							
						}
					}
					
				}else {
					b.setX(r.nextInt(Conf.W)+800);
					b.setY(r.nextInt(Conf.H));
				}
				//System.out.println();
				//System.out.println();
			}
			
		}
		
	}

	@Override
	public void draw(Graphics g) {
		if(life>0) {
			if(score<end_score) {
				g.setColor(Color.red);
				g.drawString("��"+(speed-1)/2+"���", 300, 50);
				start(g);
			}
			else {
				g.setColor(Color.red);
				g.drawString("�����ﵽ"+score+"ͨ��", 400, 100);
				restart(g);
			}
		}
		else {
			//��Ϸ����
			g.drawImage(over, 300, 100, null);
			restart(g);
		}
		
	}
	//���»���
	public void restart(Graphics g) {
		g.setColor(Color.red);
		g.drawString("��G�����¿�ʼ��Ϸ��", 400, 50);
		InputMsg inputMsg=InputMsg.createKey();
		if(inputMsg.getkeystatus(KeyEvent.VK_G)){
			life=5;
			playerbird.x=413;
			playerbird.y=413;
			score=0;
		}	
	}
	//��������»���ͼƬ
	public void start(Graphics g) {
		for(int i=0;i<bars.size();i++) {
			Bar bar=bars.get(i);
			g.drawImage(bar.current.currentImage(), bar.getX(), bar.getY(), null);
			
		}
		//�ӵ��������
		if(button && the_button==0) {
			bare.setX(bare.getX()+zidanspeed);
			g.drawImage(bare.current.currentImage(), bare.getX(), bare.getY(), null);
		}
		g.setColor(Color.red);
		g.drawString("����"+life+",�÷���"+score, 600, 50);
		g.drawString("��F����ͣ,�ո�����ӵ�", 50, 50);
		//�ɻ����ϰ�����ײ������ִ���ж�
		if(bo>0) {
			g.drawImage(boom.currentImage(), xb+50, yb+20, null);
		}
		//�ӵ����ϰ�����ײ������ִ���ж�
		if(co>0) {
			g.drawImage(boom.currentImage(), boomX, boomY, null);
		}
	}
}


