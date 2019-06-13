package com.lumina.simpleutil;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Xemjas
 *
 */
public class ExceptionUtil {
	public static String stacktrace(Throwable e) {
		if(e != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw, true);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			return sw.toString();
		} else {
			return "EXCEPTION IS NULL";
		}
	}

}
