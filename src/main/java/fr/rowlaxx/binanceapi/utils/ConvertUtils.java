package fr.rowlaxx.binanceapi.utils;

import java.text.NumberFormat;

public class ConvertUtils {

	public static String convertToString(Number value) {
		if (value == null)
			return null;

		if (value instanceof Double || value instanceof Float) {
			final NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(Integer.MAX_VALUE);
			return nf.format( (double)value ).replaceAll(",", ".");
		}
		return value.toString();
	}
	
}
