package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import enginee.GameObject;
import enginee.InputMsg;
public class Moon extends GameObject {
	boolean button=true;
	public Moon() {
		init();
	}
	@Override
	public void init() {
		this.x=200;
		this.y=200;
	}
	@Override
	public void update() {
		InputMsg inputMsg=InputMsg.createKey();
		//ÉèÖÃÔ²µÄÒÆ¶¯·¶Î§
		if(inputMsg.getkeystatus(KeyEvent.VK_A)&&this.x>0){
			this.x-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_D)&&this.x<800){
			this.x+=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_W)&&this.y>0){
			this.y-=5;
		}
		if(inputMsg.getkeystatus(KeyEvent.VK_S)&&this.y<800){
			this.y+=5;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(x,y,100,100);//»­ÍÖÔ²
	}
	
}

