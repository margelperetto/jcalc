package br.com.margel.jcalc.business;

import java.math.BigDecimal;

public interface Display {
	public void updateDisplay(BigDecimal value, CalcOp calcOp, BigDecimal result);
}
