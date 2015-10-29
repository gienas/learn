package io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainLocale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] zoneIds = TimeZone.getAvailableIDs();
		for (String lvZone : zoneIds) {
			System.out.println(lvZone);
		}

		Date lvDate = new Date();
		DateFormat lvFormat = new SimpleDateFormat() {
		};

		// System.out.println(lvFormat.format(lvDate));
		// System.out.println(new SimpleDateFormat("kk:mm", Locale.US)
		// .format();

		// Calendar lvCal =
		// Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		// System.out.println( lvCal.get( Calendar.HOUR_OF_DAY ));
		// System.out.println( lvCal.getTime().toString());
		//		
		// DateFormat lvFor = DateFormat.getDateTimeInstance(DateFormat.SHORT,
		// DateFormat.LONG, Locale.US);
		// System.out.println(lvFor.format(new Date()));
		// System.out.println( );

		// Calendar lvCal =
		// Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		// System.out.println(lvCal.getTimeInMillis());
		// System.out.println( Calendar.getInstance().getTimeInMillis());


		 long lvBeforeConvert = (long) Integer.MAX_VALUE  + 3; 
		 System.out.println(lvBeforeConvert + " Before convert");
		 int lvHigh = (int) ((long)lvBeforeConvert >> 32);
		 int lvLow = (int) (lvBeforeConvert);
		 long lvAfterConvert = ((long)lvHigh << 32) | (((long)lvLow << 32) >>> 32);
		 System.out.println(lvAfterConvert + " After convert");
		 System.out.println("High = " + lvHigh + " Low = " + lvLow);
	}

}
