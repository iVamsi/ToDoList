package com.vamc.todolist.services;

import retrofit.http.Body;
import retrofit.http.POST;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.vamc.todolist.model.Item;
import com.vamc.todolist.model.User;

public interface ToDoListService {

	// http://mobileapidemo.azurewebsites.net/Api/Register
	// http://mobileapidemo.azurewebsites.net/Api/Login
	// http://mobileapidemo.azurewebsites.net/api/AddTodoItem/Post
	// http://mobileapidemo.azurewebsites.net/api/GetAllTODOItems/Post

	@POST("/Api/Register")
	public void register(@Body User user, RestCallback<JsonPrimitive> callback);

	@POST("/Api/Login")
	public void login(@Body User user, RestCallback<JsonObject> callback);

	@POST("/Api/AddTodoItem/Post")
	public void addItem(@Body Item item, RestCallback<JsonPrimitive> callback);

	@POST("/Api/GetAllTODOItems/Post")
	public void getAllTODOItems(@Body User user,
			RestCallback<JsonObject> callback);

}
