import java.io.Console;
import java.text.DateFormat;
import java.text.NumberFormat;

public class MyConsole {
	public static void main(String[] args) {
		Console c = System.console();
		String u = c.readLine("%s", "username: ");
		System.out.println("hello " + u);
		String pw;
		
		for(char lvChar: c.readPassword("%s", "password: "))
		{
			System.out.print(lvChar);
		}	
		
		
		// if(c != null && (pw = c.readPassword("%s", "password: ")) != null)
		// // check for valid password
		// }
	}
}