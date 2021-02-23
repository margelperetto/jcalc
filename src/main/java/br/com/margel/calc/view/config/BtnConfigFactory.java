package br.com.margel.calc.view.config;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import br.com.margel.calc.view.actions.ActionBackspace;
import br.com.margel.calc.view.actions.ActionClear;
import br.com.margel.calc.view.actions.ActionClearAll;
import br.com.margel.calc.view.actions.ActionComma;
import br.com.margel.calc.view.actions.ActionNumber;
import br.com.margel.calc.view.actions.ActionEqual;
import br.com.margel.calc.view.actions.ActionOperation;
import br.com.margel.calc.view.actions.ActionSignal;
import br.com.margel.calc.view.actions.Operation;
import br.com.margel.calc.view.utils.ImageUtils;

public class BtnConfigFactory {

	public static BtnConfig dg(String text) {
		return new BtnConfig(text, new ActionNumber(), text)
				.formatter(btn->{
					btn.setFont(btn.getFont().deriveFont(Font.BOLD, 18f));
					btn.setForeground(Color.BLUE);
				});
	}
	
	public static BtnConfig bs(String text) {
		return new BtnConfig(text, new ActionBackspace(), vk(KeyEvent.VK_BACK_SPACE))
				.formatter(btn->{
					btn.setIcon(ImageUtils.fromResource("backspace.png"));
					btn.setText("");
				});
	}
	
	public static BtnConfig op(Operation op) {
		return new BtnConfig(op.getText(), new ActionOperation(op), op.getKeys());
	}
	
	public static BtnConfig eq(String text) {
		return new BtnConfig(text, new ActionEqual(), "=", vk(KeyEvent.VK_ENTER));
	}
	
	public static BtnConfig cm(String text) {
		return new BtnConfig(text, new ActionComma(), ",", ".");
	}
	
	public static BtnConfig sg(String text) {
		return new BtnConfig(text, new ActionSignal(), "#", "s");
	}
	
	public static BtnConfig c(String text) {
		return new BtnConfig(text, new ActionClear(), "c", vk(KeyEvent.VK_DELETE));
	}
	
	public static BtnConfig ce(String text) {
		return new BtnConfig(text, new ActionClearAll(), vk(KeyEvent.VK_ESCAPE), "e");
	}
	
	private static String vk(int keyCode) {
		return KeyEvent.getKeyText(keyCode);
	}
}
