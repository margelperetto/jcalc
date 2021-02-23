package br.com.margel.jcalc.view.actions;

import java.util.function.BiConsumer;

import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

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
