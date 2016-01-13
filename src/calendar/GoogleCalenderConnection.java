package calendar;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Lists;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Johannes Brautzsch
 * @reference https://github.com/google/google-api-java-client-samples/tree/
 *            master/calendar-cmdline-sample
 * @reference http://stackoverflow.com/questions/12280391/retrieving-access-
 *            token-of-oauth-2-0-implicit-grant-from-java-desktop-client-u
 */

public class GoogleCalenderConnection {

	public GoogleCalenderConnection(String userID) {
		// initialize the transport
		try {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
			Credential credential = authorize();

			// set up global Calendar instance
			client = new com.google.api.services.calendar.Calendar.Builder(httpTransport, JSON_FACTORY, credential)
					.setApplicationName(APPLICATION_NAME).build();
		} catch (GeneralSecurityException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Be sure to specify the name of your application. If the application name
	 * is {@code null} or blank, the application will log a warning. Suggested
	 * format is "MyCompany-ProductName/1.0".
	 */
	private static final String APPLICATION_NAME = "SE-Kalender/1.0";

	/** Directory to store user credentials. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".store/calendar");

	/**
	 * Global instance of the {@link DataStoreFactory}. The best practice is to
	 * make it a single globally shared instance across your application.
	 */
	private static FileDataStoreFactory dataStoreFactory;

	/** Global instance of the HTTP transport. */
	private static HttpTransport httpTransport;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	private static com.google.api.services.calendar.Calendar client;

	static final java.util.List<Calendar> addedCalendarsUsingBatch = Lists.newArrayList();

	/** Authorizes the installed application to access user's protected data. */
	private static Credential authorize() throws Exception {
		// load client secrets
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(
				GoogleCalenderConnection.class.getResourceAsStream("/resources/client_secrets.json")));
		if (clientSecrets.getDetails().getClientId().startsWith("Enter")
				|| clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
			System.out.println("Enter Client ID and Secret from https://code.google.com/apis/console/?api=calendar "
					+ "../src/main/resources/client_secrets.json");
			System.exit(1);
		}
		// set up authorization code flow
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
				clientSecrets, Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(dataStoreFactory)
						.build();
		// authorize
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}

	private static void showCalendars() throws IOException {
		GoogleCalenderView.header("Show Calendars");
		CalendarList feed = client.calendarList().list().execute();
		GoogleCalenderView.display(feed);
	}

	private static void addCalendarsUsingBatch() throws IOException {
		GoogleCalenderView.header("Add Calendars using Batch");
		BatchRequest batch = client.batch();

		// Create the callback.
		JsonBatchCallback<Calendar> callback = new JsonBatchCallback<Calendar>() {

			// @Override
			public void onSuccess(Calendar calendar, HttpHeaders responseHeaders) {
				GoogleCalenderView.display(calendar);
				addedCalendarsUsingBatch.add(calendar);
			}

			// @Override
			public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
				System.out.println("Error Message: " + e.getMessage());
			}
		};

		// Create 2 Calendar Entries to insert.
		Calendar entry1 = new Calendar().setSummary("Calendar for Testing 1");
		client.calendars().insert(entry1).queue(batch, callback);

		Calendar entry2 = new Calendar().setSummary("Calendar for Testing 2");
		client.calendars().insert(entry2).queue(batch, callback);

		batch.execute();
	}

	private static Calendar addCalendar(Calendar entry) throws IOException {
		GoogleCalenderView.header("Add Calendar");
		Calendar result = client.calendars().insert(entry).execute();
		GoogleCalenderView.display(result);
		return result;
	}

	private static Calendar updateCalendar(Calendar oldCalendar, Calendar newCalendar) throws IOException {
		GoogleCalenderView.header("Update Calendar");
		Calendar result = client.calendars().patch(oldCalendar.getId(), newCalendar).execute();
		GoogleCalenderView.display(result);
		return result;
	}

	private static void addEvent(Calendar calendar) throws IOException {
		GoogleCalenderView.header("Add Event");
		Event event = newEvent();
		Event result = client.events().insert(calendar.getId(), event).execute();
		GoogleCalenderView.display(result);
	}

	private static Event newEvent() {
		Event event = new Event();
		event.setSummary("New Event");
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 3600000);
		DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
		event.setStart(new EventDateTime().setDateTime(start));
		DateTime end = new DateTime(endDate, TimeZone.getTimeZone("UTC"));
		event.setEnd(new EventDateTime().setDateTime(end));
		return event;
	}

	private static void showEvents(Calendar calendar) throws IOException {
		GoogleCalenderView.header("Show Events");
		Events feed = client.events().list(calendar.getId()).execute();
		GoogleCalenderView.display(feed);
	}

	private static void deleteCalendarsUsingBatch() throws IOException {
		GoogleCalenderView.header("Delete Calendars Using Batch");
		BatchRequest batch = client.batch();
		for (Calendar calendar : addedCalendarsUsingBatch) {
			client.calendars().delete(calendar.getId()).queue(batch, new JsonBatchCallback<Void>() {

				// @Override
				public void onSuccess(Void content, HttpHeaders responseHeaders) {
					System.out.println("Delete is successful!");
				}

				// @Override
				public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
					System.out.println("Error Message: " + e.getMessage());
				}
			});
		}

		batch.execute();
	}

	private static void deleteCalendar(Calendar calendar) throws IOException {
		GoogleCalenderView.header("Delete Calendar");
		client.calendars().delete(calendar.getId()).execute();
	}
}
