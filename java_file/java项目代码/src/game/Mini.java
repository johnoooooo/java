package game;

import enginee.*;
public class Mini {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Director dt=new Director("нр╣дсно╥");
		dt.setSize(Conf.W,Conf.H);
		dt.setTimeInterval(Conf.TIMEINTERVAL);
		Scene my=new GameScene();
		dt.runScene(my);
	}
	

}

