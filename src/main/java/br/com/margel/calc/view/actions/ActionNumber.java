package br.com.margel.calc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

public class ActionNumber implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig cfg) {
		String text = frame.getDisplayText()+cfg.getText();
		if(text.contains(".") && text.endsWith("0")) {
			frame.setDisplayText(text);
		} else {
			frame.printResult(new BigDecimal(text));
		}
	}

}
