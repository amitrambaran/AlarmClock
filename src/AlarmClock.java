import java.time.Clock;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class AlarmClock {

	public AlarmClock(int hour, int minute, int second) {	//constructor that accepts the desired alarm value
		Thread t = new Thread() {
			public void run() {
				String alarmTime = hour + ":" + minute + ":" + second;
				while (true) {
					String curTime = getTime();
					try {
						System.out.println(curTime);
						if (alarmTime.equals(getTime()))	//check if the alarm is to ring or not
							System.out.println("ALARM!!!");
						Thread.sleep(1000);					//sleeps for 1 second, then updates the time

					} catch (InterruptedException e) {};
				}
			}
		};
		t.start();

	}

	public String getTime() {								//method to obtain time based on system's calendar
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String currentTime = hour + ":" + minute + ":" + second;
		return currentTime;
	}

	public static void main(String[] args) {
		System.out.println(" Welcome to 4D's Alarm Clock\nA division of Broken Hill LLC");
		AlarmClock myAlarm = new AlarmClock(0, 11, 20);		//AlarmClock object with alarm time parameters

	}
}
