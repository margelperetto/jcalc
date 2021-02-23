package br.com.margel.jcalc.view.actions;

import br.com.margel.jcalc.business.CalcOp;
import br.com.margel.jcalc.business.operations.Add;
import br.com.margel.jcalc.business.operations.Div;
import br.com.margel.jcalc.business.operations.Mult;
import br.com.margel.jcalc.business.operations.Sub;

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
