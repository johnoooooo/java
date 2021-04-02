package enginee;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
public class Director {
	public JFrame frame;
	public Scene scene;
	public long timeInterval;
	public static InputMsg inputMsg;
	public Director(String title) {
		frame=new JFrame();
		frame.setTitle(title);
		inputMsg=InputMsg.createKey();
		
		
	}
	public void setTimeInterval(long t) {
		this.timeInterval=t;
	}
	public void setSize(int width, int weight) {
		frame.setSize(width, weight);
		initWindow();
	}
	public void initInputMsg() {
		this.scene.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				inputMsg.setkeystatus(e,true);
			}
			public void keyReleased(KeyEvent e) {
				inputMsg.setkeystatus(e,false);
			}
		});
		this.scene.requestFocus();
	}
	private void initWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void runScene(Scene scene) {
		this.scene=scene;
		frame.add(scene);
		initInputMsg();
		final Scene finalScene=this.scene;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run(){
				finalScene.updateLogic();
				finalScene.repaint();
					
			}
		},0,timeInterval);

	}

}
