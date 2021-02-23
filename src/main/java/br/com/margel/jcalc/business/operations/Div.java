package br.com.margel.jcalc.business.operations;

import java.math.BigDecimal;

import br.com.margel.jcalc.business.CalcOp;

public class Div implements CalcOp {

	@Override
	public BigDecimal apply(BigDecimal value1, BigDecimal value2) {
		if(value2.equals(BigDecimal.ZERO)) {
			return BigDecimal.ZERO;
		}
		return value1.divide(value2, 5, BigDecimal.ROUND_HALF_EVEN);
	}

	@Override
	public String toString() {
		return "/";
	}
}