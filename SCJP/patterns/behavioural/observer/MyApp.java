package behavioural.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import static java.lang.System.out;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        out.println("Enter Text >");
        EventSource eventSource = new EventSource();

//        eventSource.addObserver((Observable obj, Object arg) -> { 
//        	out.println("\nReceived response: " + arg);
//        });

        eventSource.addObserver(new Observer(){
			@Override
			public void update(Observable o, Object arg) {
				// TODO Auto-generated method stub
				out.println("\nReceived response: " + arg);
			}
        	
        });
        
        
        new Thread(eventSource).start();
	}

}

class EventSource extends Observable implements Runnable {
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            setChanged();
            notifyObservers(response);
        }
    }
}