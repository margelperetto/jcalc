package br.com.margel.jcalc.business;

import java.math.BigDecimal;

public interface Display {
	public void printResult(BigDecimal value);
	public void printOperation(BigDecimal value, CalcOp calcOp);
}
