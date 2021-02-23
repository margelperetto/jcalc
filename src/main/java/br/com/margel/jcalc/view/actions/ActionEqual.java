package br.com.margel.jcalc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

public class ActionEqual implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig btn) {
		String text = frame.getDisplayText();
		if(text.isEmpty()) {
			return;
		}
		frame.getCalc().execute(new BigDecimal(text));
	}

}
