package com.vamc.todolist.services;

import retrofit.client.Response;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.vamc.todolist.model.Item;
import com.vamc.todolist.model.ItemList;
import com.vamc.todolist.model.User;

public class ServiceManager {
	public interface OnDataReceived {
		void onDataSuccess(Object object);
		void onDataFailure(String error);
	}

	private OnDataReceived mCallback;
	private Gson gson;
	private Context context;
	private RestClient restClient;
	private ToDoListService restService;

	public ServiceManager(Context context, OnDataReceived callback) {
        this.context = context;
        mCallback = callback;
        gson = new Gson();
        restClient = RestClient.getInstance();
        restService = restClient.setupRestClient(ToDoListService.class);
    }

	public void register(User user) {
		restService.register(user, new RestCallback<JsonPrimitive>() {
			@Override
			public void failure(RestServiceError restError) {
				mCallback.onDataFailure(restError.getMessage());
			}

			@Override
			public void success(JsonPrimitive jsonObject, Response response) {
				if (jsonObject != null) {
					mCallback.onDataSuccess(jsonObject);
				} else {
					mCallback.onDataFailure("no data");
				}
			}

		});
	}
	
	public void addItem(Item item) {
		restService.addItem(item, new RestCallback<JsonPrimitive>() {
			@Override
			public void failure(RestServiceError restError) {
				mCallback.onDataFailure(restError.getMessage());
			}

			@Override
			public void success(JsonPrimitive jsonObject, Response response) {
				if (jsonObject != null) {
					mCallback.onDataSuccess(jsonObject);
				} else {
					mCallback.onDataFailure("no data");
				}
			}

		});
	}
	
	public void login(User user) {
		restService.login(user, new RestCallback<JsonObject>() {
			@Override
			public void failure(RestServiceError restError) {
				mCallback.onDataFailure(restError.getMessage());
			}

			@Override
			public void success(JsonObject jsonObject, Response response) {
				if (jsonObject != null) {
					User user = (User) gson.fromJson(jsonObject, User.class);
					mCallback.onDataSuccess(user);
				} else {
					mCallback.onDataFailure("no data");
				}
			}

		});
	}
	
	public void getAllTODOItems(User user) {
		restService.getAllTODOItems(user, new RestCallback<JsonObject>() {
			@Override
			public void failure(RestServiceError restError) {
				mCallback.onDataFailure(restError.getMessage());
			}

			@Override
			public void success(JsonObject jsonObject, Response response) {
				if (jsonObject != null) {
					ItemList itemList = (ItemList) gson.fromJson(jsonObject, ItemList.class);
					mCallback.onDataSuccess(itemList);
				} else {
					mCallback.onDataFailure("no data");
				}
			}

		});
	}
}
