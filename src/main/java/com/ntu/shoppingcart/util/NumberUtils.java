package com.ntu.shoppingcart.util;

public class NumberUtils {
	
	
	public static boolean isNotNumeric(String value) {
		return !isNumeric(value);
	}

	public static boolean isNumeric(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
