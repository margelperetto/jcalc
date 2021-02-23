package br.com.margel.calc.business.operations;

import java.math.BigDecimal;

import br.com.margel.calc.business.CalcOp;

public class Sub implements CalcOp {

	@Override
	public BigDecimal apply(BigDecimal value1, BigDecimal value2) {
		return value1.subtract(value2);
	}

	@Override
	public String toString() {
		return "-";
	}
}