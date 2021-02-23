package br.com.margel.jcalc.view.actions;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

import br.com.margel.jcalc.business.CalcOp;
import br.com.margel.jcalc.view.JFCalc;
import br.com.margel.jcalc.view.config.BtnConfig;

public class ActionOperation implements BiConsumer<JFCalc, BtnConfig>{

	private Operation operation;
	
	public ActionOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public void accept(JFCalc frame, BtnConfig btn) {
		String text = frame.getDisplayText();
		CalcOp op = operation.getCalcOp();
		if(!text.isEmpty()) {
			frame.getCalc().operation(new BigDecimal(text), op);
		} else if(frame.getCalc().inOperation()) {
			frame.getCalc().operation(null, op);
		}
	}

}
