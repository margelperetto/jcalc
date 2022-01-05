package br.com.margel.jcalc.view;

import static br.com.margel.jcalc.view.actions.Operation.*;
import static br.com.margel.jcalc.view.config.BtnConfigFactory.*;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import br.com.margel.jcalc.business.Calc;
import br.com.margel.jcalc.business.CalcOp;
import br.com.margel.jcalc.business.Display;
import br.com.margel.jcalc.view.config.BtnConfig;
import br.com.margel.jcalc.view.listeners.CalKeyListener;
import br.com.margel.jcalc.view.utils.AppColors;
import br.com.margel.jcalc.view.utils.ImageUtils;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class JFCalc extends JFrame implements Display{
	private List<BtnConfig> btnConfigs = Arrays.asList(
			c("CE"),  ce("C"), bs("←"), op(DIV),
			dg("7"),  dg("8"), dg("9"), op(MULT),
			dg("4"),  dg("5"), dg("6"), op(SUB),
			dg("1"),  dg("2"), dg("3"), op(ADD),
			sg("+/-"),dg("0"), cm(","), eq("=")
	);
	private JTextField current = createTextField("",  11f, AppColors.SECONDARY_TEXT_COLOR);
	private JTextField display = createTextField("0", 22f, AppColors.HIGHLIGHTED_TEXT_COLOR);
	private JLabel signal =  new JLabel();
	private Calc calc = new Calc(this);
	
	public JFCalc() {
		signal.setFont(current.getFont());
		setLayout(new MigLayout(new LC().fill().insetsAll("4").gridGap("2","2").wrapAfter(4)));
		add(createDisplayPanel(), new CC().height("50::").grow().spanX(4).gapBottom("4"));
		for (BtnConfig cfg : btnConfigs) {
			add(createButton(cfg), new CC().grow().width("60::").height("50::"));
		}
		setTitle("JCalc");
		setIconImage(ImageUtils.fromResource("window_icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		addKeyListener(new CalKeyListener(btnConfigs));
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}

	private JPanel createDisplayPanel() {
		JPanel panel = new JPanel(new MigLayout(new LC().gridGap("0","0").fill().insetsAll("2")));
		panel.setOpaque(true);
		panel.setBackground(AppColors.BACKGROUND_COLOR);
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.add(current, new CC().minWidth("0" ).alignX("right").grow().spanX().split());
		panel.add(signal,  new CC().minWidth("12").gapRight("2").wrap());
		panel.add(display, new CC().minWidth("0" ).grow().spanX());
		return panel;
	}
	private JTextField createTextField(String text, float fs, Color fg) {
		JTextField field = new JTextField(text);
		field.setBorder(new LineBorder(AppColors.BACKGROUND_COLOR));
		field.setOpaque(false);
		field.setEditable(false);
		field.setFocusable(false);
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		field.setFont(field.getFont().deriveFont(Font.BOLD, fs));
		field.setForeground(fg);
		return field;
	}
	private JButton createButton(BtnConfig cfg) {
		JButton btn = new JButton(cfg.getText());
		btn.setFont(btn.getFont().deriveFont(Font.BOLD));
		btn.setFocusable(false);
		btn.addActionListener(evt->cfg.getAction().accept(this, cfg));
		cfg.setButtonComponent(btn);
		return btn;
	}
	
	public List<BtnConfig> getButtons() {
		return btnConfigs;
	}
	public String getDisplayText() {
		return display.getText();
	}
	public void setDisplayText(String text) {
		display.setText(text);
	}
	public void setDisplayValue(BigDecimal value) {
		setDisplayText(format(value));
	}
	public Calc getCalc() {
		return calc;
	}
	
	@Override
	public void updateDisplay(BigDecimal value, CalcOp calcOp, BigDecimal result) {
		signal.setText(String.valueOf(calcOp==null?"":calcOp));
		current.setText(format(value));
		setDisplayValue(result);
	}
	
	private String format(BigDecimal value) {
		return value==null?"":value.stripTrailingZeros().toPlainString();
	}
}