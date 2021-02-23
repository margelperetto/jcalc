package br.com.margel.calc;

import javax.swing.UIManager;
import br.com.margel.calc.view.JFCalc;

public class CalcApp {
	
	public static void main( String[] args ) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new JFCalc().setVisible(true);
	}
	
}