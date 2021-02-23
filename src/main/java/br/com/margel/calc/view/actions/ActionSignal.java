package br.com.margel.calc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

public class ActionSignal implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig config) {
		String text = frame.getDisplayText();
		if(text==null) {
			return;
		}
		String value = text.startsWith("-")?text.substring(1):"-"+text;
		frame.setDisplayText(new BigDecimal(value).toString());
	}

}
