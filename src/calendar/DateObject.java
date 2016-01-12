package calendar;
import java.util.Date;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.TimeZone;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;

public class DateObject {

	private EventDateTime eventdate;
	
	private DateTimeFormatter format_date = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	private DateTimeFormatter format_time = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

	public DateObject(Date date, Date datetime) throws NumberFormatException, ParseException {
		try {
			this.setDate(date);
			this.setDateTime(datetime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DateObject(Date date, Date datetime, TimeZone zone) throws NumberFormatException, ParseException {
		try {
			this.setDate(date);
			this.setDateTime(datetime);
			this.setTimeZone(zone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public DateObject(String date, String datetime) throws NumberFormatException, ParseException {
		try {
			this.setDate(date);
			this.setDateTime(datetime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DateObject(String date, String datetime, String zone) throws NumberFormatException, ParseException {
		try {
			this.setDate(date);
			this.setDateTime(datetime);
			this.setTimeZone(zone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public DateObject(EventDateTime date) {
		try {
			this.setEventDate(date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public EventDateTime getEventDate() {
		return eventdate;
	}

	public void setEventDate(EventDateTime date) {
		this.eventdate = date;
	}

	public void setDate(Date date) {
		this.eventdate.setDate(new DateTime(date));
	}

	public void setDate(String date) {
		this.eventdate.setDate(new DateTime(date));
	}

	public void setDate(DateTime date) {
		this.eventdate.setDate(date);
	}

	public void setDateTime(Date datetime) {
		this.eventdate.setDateTime(new DateTime(datetime));
	}

	public void setDateTime(DateTime datetime) {
		this.eventdate.setDateTime(datetime);
	}

	public void setDateTime(String datetime) {
		this.eventdate.setDateTime(new DateTime(datetime));
	}

	public void setTimeZone(TimeZone zone) {
		this.eventdate.setTimeZone(zone.toString());
	}

	public void setTimeZone(String zone) {
		this.eventdate.setTimeZone(zone);
	}
	
	public DateTime getDate() {
		return this.eventdate.getDate();
	}

	public DateTime getDateTime(Date datetime) {
		return this.eventdate.getDateTime();
	}

	public String getTimeZone(String zone) {
		return this.eventdate.getTimeZone();
	}
	
}