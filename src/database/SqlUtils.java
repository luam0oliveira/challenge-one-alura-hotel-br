package database;

import java.sql.Date;

public class SqlUtils {
	public static Date from(java.util.Date from) {
		return new Date(from.getTime());
	}
}
