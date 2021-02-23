package br.com.margel.jcalc.business.operations;

import java.math.BigDecimal;

import br.com.margel.jcalc.business.CalcOp;

public class Mult implements CalcOp {

	@Override
	public BigDecimal apply(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

	@Override
	public String toString() {
		return "x";
	}
}