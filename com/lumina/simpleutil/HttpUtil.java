package com.lumina.simpleutil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Xemjas
 *
 */
public class HttpUtil {
	public static String sendPostRequest(String url, String message, String contentType) throws IOException {
		DataOutputStream out = null;
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		try {
			URL urlObject = new URL(url);
			con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(2000);
			con.setReadTimeout(3000);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", contentType);
						
			out = new DataOutputStream(con.getOutputStream());
			out.writeBytes(message);
			out.flush();
			out.close();
			
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			return response.toString();
		} catch(Throwable t) {
			return ExceptionUtil.stacktrace(t);
		} finally {
			if(in != null) {
				in.close();
			}
		}

	}
}
