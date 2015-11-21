package com.vamc.todolist.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

	@SerializedName("itemlist")
	@Expose
	private List<Item> itemlist = new ArrayList<Item>();

	/**
	 * 
	 * @return The item
	 */
	public List<Item> getItem() {
		return itemlist;
	}

	/**
	 * 
	 * @param itemlist
	 *            The item
	 */
	public void setItem(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

}
