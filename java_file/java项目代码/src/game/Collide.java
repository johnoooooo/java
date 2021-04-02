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
	
	//增加一个生命和一个积分
	int life=5;
	int score;
	Playerbird playerbird=new Playerbird();
	Bare bare=new Bare();
	static int the_button=0;//关于暂停状态的按钮
	public Collide() {
		init();
	}
	
	ArrayList<Bar> bars=new ArrayList<>();
	private Random r=new Random();
	
	BufferedImage over;
	BufferedImage pause;
	Animation boom;
	boolean  button=false;//关于是否发射子弹的按钮
	
	
	@Override
	public void init() {
		//准备的子弹
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
	
	int xb;//发生碰撞的x坐标
	int yb;//发生碰撞的y坐标
	int bo;//飞机与障碍物碰撞的标识
	int co;//子弹与障碍物碰撞的标识
	int boomX;//获取碰撞时的X坐标
	int boomY;//获取碰撞时的Y坐标
	int end_score=10;//通关分数
	int speed;//障碍物速度
	int zidanspeed=7;
	int sclimit=3;//达到该分数后加速
	//设置障碍物的速度
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
			xb=playerbird.x;//发生碰撞的坐标设为玩家的坐标
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
				//设定子弹轨迹
				if(b.getX()>-50) {
					//判断是否是暂停状态，是则不执行，即不刷新
					if(the_button==0) {
						
						b.setX(b.getX()-speed);
						if(b.getMovey()>20) {//20是偏移量
							b.setChangey();//改变方向
							b.setMovey(0);//偏移量重新开始设定
						}else {
							b.setMovey(b.getMovey()+1);
						}
						//假定1是往上。0往下
						if(b.getChangey()==1) {
							b.setY(b.getY()-1);
						}else {
							b.setY(b.getY()+1);
						}
						//鸟与障碍物发生碰撞
						if(b.getX()>=xb&&b.getX()<=xb+76
								&&(b.getY()>=yb&&b.getY()<=yb+59)) {
							//System.out.println(b.getX()+","+b.getY()+";"+xb+","+yb);
							bo=1;
							//重新让子弹在右边出现
							b.setX(Conf.W+800);
							b.setY(r.nextInt(400));
							life--;
							
						}
						//子弹与障碍物发生碰撞
						if(b.getX()>=bare.getX()&&b.getX()<=bare.getX()+32
								&&(b.getY()>=bare.getY()&&b.getY()<=bare.getY()+59)) {
							//System.out.println(b.getX()+","+b.getY()+";"+bare.getX()+","+bare.getY());
							co=1;
							//重新让子弹在右边出现
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
				g.drawString("第"+(speed-1)/2+"大关", 300, 50);
				start(g);
			}
			else {
				g.setColor(Color.red);
				g.drawString("分数达到"+score+"通关", 400, 100);
				restart(g);
			}
		}
		else {
			//游戏结束
			g.drawImage(over, 300, 100, null);
			restart(g);
		}
		
	}
	//重新绘制
	public void restart(Graphics g) {
		g.setColor(Color.red);
		g.drawString("按G键重新开始游戏！", 400, 50);
		InputMsg inputMsg=InputMsg.createKey();
		if(inputMsg.getkeystatus(KeyEvent.VK_G)){
			life=5;
			playerbird.x=413;
			playerbird.y=413;
			score=0;
		}	
	}
	//正常情况下绘制图片
	public void start(Graphics g) {
		for(int i=0;i<bars.size();i++) {
			Bar bar=bars.get(i);
			g.drawImage(bar.current.currentImage(), bar.getX(), bar.getY(), null);
			
		}
		//子弹发射过程
		if(button && the_button==0) {
			bare.setX(bare.getX()+zidanspeed);
			g.drawImage(bare.current.currentImage(), bare.getX(), bare.getY(), null);
		}
		g.setColor(Color.red);
		g.drawString("生命"+life+",得分是"+score, 600, 50);
		g.drawString("按F键暂停,空格键发子弹", 50, 50);
		//飞机与障碍物碰撞动画的执行判断
		if(bo>0) {
			g.drawImage(boom.currentImage(), xb+50, yb+20, null);
		}
		//子弹与障碍物碰撞动画的执行判断
		if(co>0) {
			g.drawImage(boom.currentImage(), boomX, boomY, null);
		}
	}
}


