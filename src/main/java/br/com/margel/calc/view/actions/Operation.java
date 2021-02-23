package br.com.margel.calc.view.actions;

import br.com.margel.calc.business.CalcOp;
import br.com.margel.calc.business.operations.Add;
import br.com.margel.calc.business.operations.Div;
import br.com.margel.calc.business.operations.Mult;
import br.com.margel.calc.business.operations.Sub;

public enum Operation {
	DIV (new Div(), "/"),
	MULT(new Mult(),"x", "*"),
	SUB (new Sub(), "-"),
	ADD (new Add(), "+");
	
	private CalcOp calcOp;
	private String[] keys;

	private Operation(CalcOp calcOp, String... keys) {
		this.calcOp = calcOp;
		this.keys = keys;
	}
	
	public CalcOp getCalcOp() {
		return calcOp;
	}

	public String getText() {
		return keys[0];
	}
	
	public String[] getKeys() {
		return keys;
	}
}
