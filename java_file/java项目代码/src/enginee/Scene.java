package enginee;

import javax.swing.JPanel;
import java.util.*;
import java.awt.Graphics;

public class Scene extends JPanel{
	public List<GameObject> games=new ArrayList<>();
	public void addGameObject(GameObject gameObject) {
		games.add(gameObject);
	}
	public void paint(Graphics g) {
		super.paint(g);
		for (int i=0;i<games.size();i++) {
			games.get(i).draw(g);
		}
	}
	public void updateLogic() {
		for (int i=0;i<games.size();i++) {
			games.get(i).update();
		}
	}

}
