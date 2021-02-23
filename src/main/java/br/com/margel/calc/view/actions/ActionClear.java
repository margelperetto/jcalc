package br.com.margel.calc.view.actions;

import java.util.function.BiConsumer;

import br.com.margel.calc.view.JFCalc;
import br.com.margel.calc.view.config.BtnConfig;

public class ActionClear implements BiConsumer<JFCalc, BtnConfig>{

	@Override
	public void accept(JFCalc frame, BtnConfig config) {
		if(frame.getCalc().inOperation()){
			frame.setDisplayText("");
		} else {
			frame.setDisplayText("0");
		}
	}

}
