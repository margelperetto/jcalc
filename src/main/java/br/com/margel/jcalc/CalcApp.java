package br.com.margel.jcalc;

import javax.swing.UIManager;
import br.com.margel.jcalc.view.JFCalc;

public class CalcApp {
	
	public static void main( String[] args ) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new JFCalc().setVisible(true);
	}
	
}