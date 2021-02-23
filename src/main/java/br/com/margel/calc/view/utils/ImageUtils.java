package br.com.margel.calc.view.utils;

import javax.swing.ImageIcon;

public class ImageUtils {

	public static ImageIcon fromResource(String image) {
		return new ImageIcon(ImageUtils.class.getClassLoader().getResource(image));
	}
	
}
