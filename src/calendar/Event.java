package calendar;

public class Event {

	private String title;
	private String dateFrom; 
	private String dateTo;
	private String timeFrom; 
	private String timeTo;
	private String location; 
	private String description; 
	private String repeat;
	private String repeatTo; 
	private String visibility;
	
	public Event(String title, String dateFrom, String dateTo, String timeFrom, 
    		String timeTo, String location, String description, String repeat, String repeatTo, 
    		String visibility){
			this.title = title;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
			this.timeFrom = timeFrom;
			this.timeTo = timeTo;
			this.location = location;
			this.description = description;
			this.repeat = repeat;
			this.repeatTo = repeatTo;
			this.visibility = visibility;
	}
	
	public String getTitle() {
		return title;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public String getRepeat() {
		return repeat;
	}

	public String getRepeatTo() {
		return repeatTo;
	}

	public String getVisibility() {
		return visibility;
	}
	
}