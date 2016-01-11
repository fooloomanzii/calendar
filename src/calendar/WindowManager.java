package calendar;

public class WindowManager {
	public static void main(String [] args ){
		
		LoginCalendarWindow win = new LoginCalendarWindow(new Client(null, null, null, null, null, null));
		win.getFrame().setVisible(true);
	}
}