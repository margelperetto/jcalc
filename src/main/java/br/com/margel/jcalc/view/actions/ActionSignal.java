package br.com.margel.jcalc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

public class ActionSignal implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig config) {
		String text = frame.getDisplayText();
		if(text.isEmpty()) {
			return;
		}
		String value = text.startsWith("-")?text.substring(1):"-"+text;
		frame.setDisplayText(new BigDecimal(value).toString());
	}

}
