package enginee;

import java.awt.Graphics;

public  abstract class GameObject {
	public int x;
	public int y;
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);

}
