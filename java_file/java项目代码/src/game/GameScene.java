package game;
import enginee.Animation;
import enginee.Scene;
public class GameScene extends Scene {
	public GameScene() {
		init();
	}
	public void init() {
		BackGround back=new BackGround();
		this.addGameObject(back);
		Playerbird playerbird=new Playerbird();
		this.addGameObject(playerbird);
		Collide collide=new Collide();
		this.addGameObject(collide);
		
	}

}
