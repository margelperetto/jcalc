package br.com.margel.calc.business;

import java.math.BigDecimal;

public interface Display {
	public void printResult(BigDecimal value);
	public void printOperation(BigDecimal value, CalcOp calcOp);
}
