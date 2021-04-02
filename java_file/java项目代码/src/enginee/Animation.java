package enginee;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class Animation {
	private ArrayList<BufferedImage> images=new ArrayList<>();
	private ArrayList<String> paths=new ArrayList<>();
	private int preUnitDelay;
	private Animation() {
	}
	public static Animation createAni(ArrayList<String> paths,int preUnitDelay) {
		Animation ani=new Animation();
		ani.init(paths,preUnitDelay);
		return ani;
	}
	private void init(ArrayList<String> paths,int preUnitDelay) {
		this.paths=paths;
		this.preUnitDelay=preUnitDelay;
		for(int i=0;i<paths.size();i++) {
			images.add(GameUtil.readImage(paths.get(i)));
		}
		
	}
	private int currentindex=0;
	public BufferedImage currentImage() {
		BufferedImage image=images.get(currentindex);
		this.step();
		return image;
	}
	int i=0;
	public void step() {
		currentindex=++i/preUnitDelay%images.size();
	}
}
