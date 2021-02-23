package br.com.margel.calc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

public class ActionBackspace implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig config) {
		String text = frame.getDisplayText();
		if(text.isEmpty()) {
			return;
		}
		text = text.substring(0, text.length()-1);
		if(text.isEmpty() || text.equals("-")) {
			if(frame.getCalc().inOperation()) {
				frame.setDisplayText("");
			} else {
				frame.setDisplayText("0");
			}
		} else {
			frame.printResult(new BigDecimal(text));
		}
	}

}
