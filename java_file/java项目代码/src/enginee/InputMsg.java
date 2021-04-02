package enginee;

import java.awt.event.KeyEvent;
import java.util.*;

public class InputMsg {
	Map<Integer,Boolean> keystatus=new HashMap<>();
	public static InputMsg inputMsg;
	private InputMsg() {
		init();
	}
	public static InputMsg createKey() {
		if(inputMsg==null) {
			inputMsg=new InputMsg();
		}
		return inputMsg;
	}
	private void init() {
		for(int i=0;i<108;i++) {
			keystatus.put(i,false);
		}
	}
	public boolean getkeystatus(Integer key) {
		return keystatus.get(key);
				
	}
	public void setkeystatus(KeyEvent e, Boolean status) {
		keystatus.put(e.getKeyCode(), status);
				
	}
	

}
