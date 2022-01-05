package br.com.margel.jcalc.business;

import java.math.BigDecimal;

public class Calc {
	private Display display;
	private BigDecimal currentValue;
	private CalcOp calcOp;
	
	public Calc(Display display) {
		this.display = display;
	}

	public Calc operation(BigDecimal value, CalcOp calcOp) {
		if(value!=null) {
			currentValue = inOperation()?applyOperation(value):value;
		}
		this.calcOp = calcOp;
		updateDisplay(null);
		return this;
	}

	public BigDecimal execute(BigDecimal value) {
		if(calcOp==null) {
			return null;
		}
		BigDecimal result = applyOperation(value);
		resetAndShowResult(result);
		return result;
	}
	
	private void resetAndShowResult(BigDecimal result) {
		currentValue = null;
		calcOp = null;
		updateDisplay(result);
	}
	
	public void resetCalc() {
		resetAndShowResult(BigDecimal.ZERO);
	}

	private BigDecimal applyOperation(BigDecimal value) {
		return calcOp.apply(currentValue, value);
	}

	private void updateDisplay(BigDecimal result) {
		display.updateDisplay(currentValue, calcOp, result);
	}

	public boolean inOperation() {
		return currentValue!=null && calcOp!=null;
	}
	
}