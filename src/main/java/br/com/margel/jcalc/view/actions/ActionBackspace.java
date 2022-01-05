package br.com.margel.jcalc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

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
			frame.setDisplayValue(new BigDecimal(text));
		}
	}

}
