package fr.rowlaxx.binanceapi.utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IOUtils {
	
	public static String readAllAsString(InputStream is) throws IOException {
		try {
			final StringBuilder sb = new StringBuilder(50);
			final byte[] buffer = new byte[8_192];
			int readed;
			while( (readed = is.read(buffer, 0, buffer.length)) > 0 )
				for (int i = 0 ; i < readed ; i++)
					sb.append( (char)buffer[i] );
			return sb.toString();
		}finally {
			if (is != null)
				is.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readAllAsJson(InputStream is) throws IOException {
		final String readed = readAllAsString(is);
		if (readed.isEmpty())
			return null;
		if (readed.startsWith("[") && readed.endsWith("]"))
			return (T) new JSONArray(readed);
		if (readed.startsWith("{") && readed.endsWith("}"))
			return (T) new JSONObject(readed);
		throw new JSONException("The body response was not a JSON object. Response : \n" + readed);
	}

}
