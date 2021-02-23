package br.com.margel.jcalc.view.config;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.swing.JButton;

import br.com.margel.jcalc.view.JFCalc;

public class BtnConfig {
	private String text;
	private JButton component;
	private List<String> keys;
	private BiConsumer<JFCalc, BtnConfig> action;
	private Consumer<JButton> formatter = btn->{};
	
	protected BtnConfig(String text, BiConsumer<JFCalc, BtnConfig> action, String... keys) {
		this.text = text;
		this.action = action;
		this.keys = Arrays.asList(keys);
	}
	
	public String getText() {
		return text;
	}
	
	public BiConsumer<JFCalc, BtnConfig> getAction() {
		return action;
	}
	
	public BtnConfig formatter(Consumer<JButton> formatter) {
		this.formatter = formatter;
		return this;
	}
	
	public void setButtonComponent(JButton buttonComponent) {
		this.component = buttonComponent;
		formatter.accept(buttonComponent);
	}

	public boolean readKey(String key) {
		if(keys.contains(key)) {
			component.doClick();
			return true;
		}
		return false;
	}

}
