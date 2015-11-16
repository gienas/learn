package pl.ene.web.websocket;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.LoggerFactory;

import pl.ene.common.rest.RestCommonServerLoggingFilter;

@ServerEndpoint("/clock")
public class WebSocketClock {

	
	private org.slf4j.Logger LOG = LoggerFactory.getLogger(WebSocketClock.class);
	
	static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

	private static Set<Session> allSessions;

	private String prefix = "";
	
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@OnOpen
	public void showTime(final Session session) {
		LOG.info("@OnOpen call {}",Thread.currentThread().getId()) ;
		allSessions = session.getOpenSessions();

		// start the scheduler on the very first connection
		// to call sendTimeToAll every second
		if (allSessions.size() == 1) {

			timer.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					sendTimeToAll(session);
				}
			}, 0, 1, TimeUnit.SECONDS);

		}
	}

	
	@OnMessage
	public void processMessage(String message, Session session)
	{
		LOG.info("Set new value {}  Thread {}", message ,Thread.currentThread().getId());
		prefix = message;
	}
	
	private void sendTimeToAll(Session session) {
		allSessions = session.getOpenSessions();
		for (Session sess : allSessions) {
			try {
				sess.getBasicRemote().sendText(prefix + LocalTime.now().format(timeFormatter) + "("+Thread.currentThread().getId()+")");
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
}