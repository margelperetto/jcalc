package br.com.margel.jcalc.view.utils;

import javax.swing.ImageIcon;

public class ImageUtils {

	public static ImageIcon fromResource(String image) {
		return new ImageIcon(ImageUtils.class.getClassLoader().getResource(image));
	}
	
}
