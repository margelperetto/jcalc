package br.com.margel.calc.view.actions;

import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

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
