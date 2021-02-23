package br.com.margel.jcalc.view.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import br.com.margel.jcalc.view.config.BtnConfig;

public class CalKeyListener extends KeyAdapter{

	private List<BtnConfig> buttons;
	
	public CalKeyListener(List<BtnConfig> buttons) {
		this.buttons = buttons;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		String keyChar = Character.toString(e.getKeyChar()).replace("","").trim().toLowerCase();
		String keyText = KeyEvent.getKeyText(e.getKeyCode());
		for (BtnConfig cfg : buttons) {
			if(cfg.readKey(keyChar.isEmpty()?keyText:keyChar)) {
				break;
			}
		}
	}
}
