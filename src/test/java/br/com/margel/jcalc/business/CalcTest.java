package br.com.margel.jcalc.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.margel.jcalc.business.operations.Add;
import br.com.margel.jcalc.business.operations.Div;
import br.com.margel.jcalc.business.operations.Mult;
import br.com.margel.jcalc.business.operations.Sub;

public class CalcTest {
	@Captor
	private ArgumentCaptor<BigDecimal> currentValueCaptor;
	@Captor
	private ArgumentCaptor<BigDecimal> resultCaptor;
	@Captor
	private ArgumentCaptor<CalcOp> opCaptor;

	@Mock
	private Display display;

	@InjectMocks
	private Calc calc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testOperations() {
		assertOp(new Add(), "10.5", "30.2", "40.7");
		assertOp(new Sub(), "40.005", "1.005", "39.000");
		assertOp(new Div(), "25", "2", "12.50000");
		assertOp(new Div(), "2", "0", "0");
		assertOp(new Mult(), "15", "3", "45");
	}

	private void assertOp(CalcOp op, String v1Str, String v2Str, String resStr) {
		BigDecimal result = calc.operation(new BigDecimal(v1Str), op).execute(new BigDecimal(v2Str));
		assertEquals(new BigDecimal(resStr), result);
	}

	@Test
	public void testSequentialOperations() {
		//((20+40)*2)/4=30
		BigDecimal result = calc
				.operation(new BigDecimal("20"), new Add())
				.operation(new BigDecimal("40"), new Mult())
				.operation(new BigDecimal("2"), new Div())
				.execute(new BigDecimal("4"));
		assertEquals(new BigDecimal("30.00000"), result);
	}

	@Test
	public void testIterationWithDisplay() {
		CalcOp opAdd = new Add();
		CalcOp opDiv = new Div();
		CalcOp opMult = new Mult();
		calc.operation(new BigDecimal("20"), opAdd)
		.operation(new BigDecimal("10"), opDiv)
		.operation(null, opMult)
		.execute(new BigDecimal("2"));

		Mockito.verify(display, Mockito.times(4)).updateDisplay(currentValueCaptor.capture(), opCaptor.capture(), resultCaptor.capture());

		assertEquals(opAdd, opCaptor.getAllValues().get(0));
		assertEquals(new BigDecimal("20"), currentValueCaptor.getAllValues().get(0));
		assertNull(resultCaptor.getAllValues().get(0));

		assertEquals(opDiv, opCaptor.getAllValues().get(1));
		assertEquals(new BigDecimal("30"), currentValueCaptor.getAllValues().get(1));
		assertNull(resultCaptor.getAllValues().get(1));
		
		assertEquals(opMult, opCaptor.getAllValues().get(2));
		assertEquals(new BigDecimal("30"), currentValueCaptor.getAllValues().get(2));
		assertNull(resultCaptor.getAllValues().get(2));

		assertNull(opCaptor.getValue());
		assertNull(currentValueCaptor.getValue());
		assertEquals(new BigDecimal("60"), resultCaptor.getValue());
	}
	
	@Test
	public void testResetCalc() {
		CalcOp opAdd = new Add();
		calc.operation(new BigDecimal("20"), opAdd);
		calc.resetCalc();
		Mockito.verify(display, Mockito.times(2)).updateDisplay(currentValueCaptor.capture(), opCaptor.capture(), resultCaptor.capture());
		
		assertEquals(opAdd, opCaptor.getAllValues().get(0));
		assertEquals(new BigDecimal("20"), currentValueCaptor.getAllValues().get(0));
		assertNull(resultCaptor.getAllValues().get(0));
		
		assertNull(opCaptor.getValue());
		assertNull(currentValueCaptor.getValue());
		assertEquals(new BigDecimal("0"), resultCaptor.getValue());
		assertNull(calc.execute(BigDecimal.TEN));
	}
	
	@Test
	public void assertOperationsId() {
		assertEquals("+", new Add().toString());
		assertEquals("-", new Sub().toString());
		assertEquals("/", new Div().toString());
		assertEquals("x", new Mult().toString());
	}

}