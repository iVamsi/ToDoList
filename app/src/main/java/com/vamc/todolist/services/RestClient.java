package com.vamc.todolist.services;

import retrofit.RestAdapter;

public class RestClient {

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String JSON_TYPE = "application/json";
	public static final String BASE_URL = "http://mobileapidemo.azurewebsites.net";

	private Class<?> mRestClient;
	private static RestClient singleton;

	private RestClient() {

	}

	public static RestClient getInstance() {
		if (singleton == null) {
			singleton = new RestClient();
		}
		return singleton;
	}

	/*
	 * Returns the instance of Restclient
	 */
	public Class<?> getRestClient() {
		return mRestClient;
	}

	public void resetRestClient() {
		mRestClient = null;
	}

	public <T> void validateServiceClass(Class<T> service) {
		if (!service.isInterface()) {
			throw new IllegalArgumentException(
					"Only interface endpoint definitions are supported.");
		}
		// Prevent API interfaces from extending other interfaces. This not only
		// avoids a bug in
		// Android (http://b.android.com/58753) but it forces composition of API
		// declarations which is
		// the recommended pattern.
		if (service.getInterfaces().length > 0) {
			throw new IllegalArgumentException(
					"Interface definitions must not extend other interfaces.");
		}
	}

	/*
	 * To create the Rest Client which communicates with server and consume the
	 * REST service
	 * 
	 * @param : Service
	 */
	public <T> T setupRestClient(Class<T> serviceClass) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(BASE_URL)
				.build();

		return restAdapter.create(serviceClass);
	}
}
