package com.vamc.todolist.view;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.vamc.todolist.model.Item;
import com.vamc.todolist.model.ItemList;
import com.vamc.todolist.model.RuntimeData;
import com.vamc.todolist.services.ServiceManager;
import com.vamc.todolist.services.ServiceManager.OnDataReceived;

public class TodoListActivity extends ListActivity implements OnDataReceived {
	private static final String TAG = TodoListActivity.class.getSimpleName();

	private ArrayList<String> mTodoList;
	private ArrayAdapter<String> mAdapter;
	private List<Item> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Init UI.
		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(TodoListActivity.this,
						TodoActivity.class);

				if (position == 0) {
					// do nothing.
				} else {
					if (list != null) {
						RuntimeData.sSelectedITem = list.get(position - 1);
						intent.putExtra("position", position);
					}
				}
				startActivity(intent);
			}
		});

		ServiceManager serviceManager = new ServiceManager(this, this);
		serviceManager.getAllTODOItems(RuntimeData.sUser);
	}

	@Override
	public void onDataSuccess(Object object) {
		mTodoList = new ArrayList<String>();
		mTodoList.add("Click to add");

		ItemList itemList = (ItemList) object;

		if (itemList != null) {
			list = itemList.getItem();

			if (list != null) {
				for (Item item : list) {
					mTodoList.add(item.getTitle());
				}
			}
		}

		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mTodoList);
		getListView().setAdapter(mAdapter);
	}

	@Override
	public void onDataFailure(String error) {
		Toast.makeText(this, "Could not add item. Please retry.",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		ServiceManager serviceManager = new ServiceManager(this, this);
		serviceManager.getAllTODOItems(RuntimeData.sUser);
	}
}
