package br.com.margel.calc.business;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public interface CalcOp extends BiFunction<BigDecimal, BigDecimal, BigDecimal>{}