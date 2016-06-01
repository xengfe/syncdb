package yskj.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateStrUtl {

	public static String getFormatDate(Timestamp timestamp) {
		SimpleDateFormat hm =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=hm.format(timestamp);
		return time;
	}
}
