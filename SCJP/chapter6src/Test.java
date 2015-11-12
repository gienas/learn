import java.io.BufferedReader;
import java.util.Calendar;
import java.util.TimeZone;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = new String("asd");
		// TODO Auto-generated method stub
//		Date d = new Date();

//		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMAN);
//		DateFormat dt  = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.US);
//		dt.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//		System.out.println(dt.format(d));
//		
		Calendar lvUSCal = Calendar.getInstance();
		lvUSCal.set(Calendar.HOUR_OF_DAY, 0);
		lvUSCal.set(Calendar.MINUTE, 0);
		lvUSCal.set(Calendar.SECOND, 0);
		lvUSCal.set(Calendar.MILLISECOND, 0);
		System.out.println("Dzieñ miesi¹ca PL = " +  lvUSCal.get(Calendar.DAY_OF_MONTH));
		long lvUSMil = lvUSCal.getTimeInMillis();
		System.out.println(lvUSCal.get(Calendar.HOUR_OF_DAY));

		
		Calendar lvCal = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		lvCal.setTimeInMillis(lvUSMil);
		System.out.println("Dzieñ miesi¹ca US = " +  lvCal.get(Calendar.DAY_OF_MONTH));
		System.out.println(lvCal.get(Calendar.HOUR_OF_DAY));
		
		
		BufferedReader lvR = null;
		//Console lvConsole
	}


}
