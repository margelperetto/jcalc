package br.com.margel.calc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

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
