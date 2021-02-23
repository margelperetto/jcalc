package br.com.margel.jcalc.view.actions;

import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

public class ActionComma implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig config) {
		String text = frame.getDisplayText();
		if(text.isEmpty()) {
			frame.setDisplayText("0.");
		} else if(!text.contains(".")) {
			frame.setDisplayText(text+".");
		}
	}

}
