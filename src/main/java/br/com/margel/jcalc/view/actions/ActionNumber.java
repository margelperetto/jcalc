package br.com.margel.jcalc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

public class ActionNumber implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig cfg) {
		String text = frame.getDisplayText()+cfg.getText();
		if(text.contains(".") && text.endsWith("0")) {
			frame.setDisplayText(text);
		} else {
			frame.setDisplayValue(new BigDecimal(text));
		}
	}

}
