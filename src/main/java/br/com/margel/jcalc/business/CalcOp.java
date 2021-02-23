package br.com.margel.jcalc.business;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public interface CalcOp extends BiFunction<BigDecimal, BigDecimal, BigDecimal>{}