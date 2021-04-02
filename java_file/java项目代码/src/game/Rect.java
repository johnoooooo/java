package game;
import java.awt.Graphics;
import enginee.GameObject;
import java.awt.Color;
public class Rect extends GameObject {
	boolean button=true;
	public Rect() {
    	this.init();
    }
    public void init() {
        this.x=300;
        this.y=300;
	}
      @Override 
    public void update() {
    	if(y==800) {
    		y=0;
    	}
    	else {
    		y++;
    	}
    }
    public void draw(Graphics g) {
        
    	g.setColor(Color.black);
        g.fillRect(x,y,100,100);
   }
}

