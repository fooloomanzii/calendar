package calendar;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.util.Preconditions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author Johannes Brautzsch
 * @reference Yaniv Inbar
 * @reference com.google.api.client.auth.oauth2.AuthorizationCodeInstalledApplication
 * @reference https://github.com/google/google-api-java-client-samples/tree/master/calendar-cmdline-sample
 * @reference http://stackoverflow.com/questions/12280391/retrieving-access-token-of-oauth-2-0-implicit-grant-from-java-desktop-client-u
 * Copyright (c) 2012 Google Inc.
 */

/**
 * 
 * This Class is a modified Version of
 * com.google.api.client.auth.oauth2.AuthorizationCodeInstalledApplication
 * Reason, from not extending, is for using the JavaFx-Browser for
 * handling-reasons like closing automaticly and security reasons
 *
 */
public class GoogleAuthorizationInOwnBrowser {
	/** Authorization code flow. */
	private final AuthorizationCodeFlow flow;

	/** Verification code receiver. */
	private final VerificationCodeReceiver receiver;

	/** Logger */
	private static final Logger LOGGER = Logger.getLogger(AuthorizationCodeInstalledApp.class.getName());

	/**
	 * @param flow
	 *            authorization code flow
	 * @param receiver
	 *            verification code receiver
	 */
	public GoogleAuthorizationInOwnBrowser(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
		this.flow = Preconditions.checkNotNull(flow);
		this.receiver = Preconditions.checkNotNull(receiver);
	}

	/**
	 * Authorizes the installed application to access user's protected data.
	 *
	 * @param userId
	 *            user ID or {@code null} if not using a persisted credential
	 *            store
	 * @return credential
	 */
	public Credential authorize(String userId) throws IOException {
		try {
			// load credentials
			Credential credential = flow.loadCredential(userId);
			if (credential != null && (credential.getRefreshToken() != null || credential.getExpiresInSeconds() > 60)) {
				return credential;
			}
			// open in browser
			String redirectUri = receiver.getRedirectUri();
			AuthorizationCodeRequestUrl authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUri);
			onAuthorization(authorizationUrl);
			// receive authorization code and exchange it for an access token
			String code = receiver.waitForCode();
			TokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
			// store credential and return it
			return flow.createAndStoreCredential(response, userId);
		} finally {
			receiver.stop();
		}
	}

	/**
	 * Handles user authorization by redirecting to the OAuth 2.0 authorization
	 * server.
	 *
	 * @param authorizationUrl
	 *            authorization URL
	 * @throws IOException
	 *             I/O exception
	 */
	protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) throws IOException {
		browse(authorizationUrl.build());
	}

	public static void browse(String url) {
		Preconditions.checkNotNull(url);
		// Ask user to open in their browser using copy-paste
		// System.out.println("Please open the following address in your
		// browser:");
		// System.out.println(" " + url);

		// Attempt to open it in the browser
		try {
			BrowserApp app = new BrowserApp();
			// this sets a static url for the BrowserApp
			// TODO: watch if this causes Problems with other users
			app.setURL(url);
			Application.launch(BrowserApp.class, (java.lang.String[]) null);
		}

		catch (InternalError e) {
			LOGGER.log(Level.WARNING, "Unable to open browser", e);
		}
	}

	/**
	 * Opens Javafx-Browser
	 */
	public static class BrowserApp extends Application {
		private static String url;
		private Scene scene;

		public void setURL(String url) {
			this.url = url;
		}

		public void start(Stage stage) {
			BorderPane borderPane = new BorderPane();
			WebView browser = new WebView();
			WebEngine webEngine = browser.getEngine();

			webEngine.load(url);
			borderPane.setCenter(browser);
			webEngine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
				public void handle(WebEvent<String> event) {
					// System.out.println(event);
				}
			});

			stage.setTitle("Google Kalender Login");
			scene = new Scene(borderPane, 550, 650);
			stage.setScene(scene);
			stage.show();
		}
	}

	/** Returns the authorization code flow. */
	public final AuthorizationCodeFlow getFlow() {
		return flow;
	}

	/** Returns the verification code receiver. */
	public final VerificationCodeReceiver getReceiver() {
		return receiver;
	}
}
