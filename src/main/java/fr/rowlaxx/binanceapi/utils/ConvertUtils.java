package fr.rowlaxx.binanceapi.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class ConvertUtils {

	public static String convertToString(Number value) {
		if (value == null)
			return null;

		if (value instanceof Double || value instanceof Float) {
			final NumberFormat nf = NumberFormat.getInstance(Locale.US);
			nf.setMaximumFractionDigits(Integer.MAX_VALUE);
			return nf.format( (double)value );
		}
		return value.toString();
	}
	
}
