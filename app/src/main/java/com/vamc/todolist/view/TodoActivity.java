package com.vamc.todolist.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vamc.todolist.R;
import com.vamc.todolist.model.Item;
import com.vamc.todolist.model.RuntimeData;
import com.vamc.todolist.services.ServiceManager;
import com.vamc.todolist.services.ServiceManager.OnDataReceived;

public class TodoActivity extends Activity implements OnDataReceived {
	private static final String TAG = TodoActivity.class.getSimpleName();

	private EditText mEdtTitle;
	private EditText mEdtDesc;
	private Button mBtnAdd;
	private Integer mUserId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_todo);

		mEdtTitle = (EditText) findViewById(R.id.edtTitle);
		mEdtDesc = (EditText) findViewById(R.id.edtDesc);
		mBtnAdd = (Button) findViewById(R.id.btnAdd);
		
		int position = getIntent().getIntExtra("position", -1);
		
		if(position != -1) {
			mEdtTitle.setText(RuntimeData.sSelectedITem.getTitle());
			mEdtDesc.setText(RuntimeData.sSelectedITem.getDescription());
			
			mBtnAdd.setVisibility(View.GONE);
		}

		mBtnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Item item = new Item();
				item.setDate(1);
				item.setItemId(1);
				item.setDescription(mEdtDesc.getText().toString());
				item.setTitle(mEdtTitle.getText().toString());
				item.setApplicantId(RuntimeData.sUser.getApplicantId());

				ServiceManager serviceManager = new ServiceManager(
						TodoActivity.this, TodoActivity.this);
				serviceManager.addItem(item);
			}
		});
	}

	@Override
	public void onDataSuccess(Object object) {
		Toast.makeText(this, "Added item successfully.", Toast.LENGTH_SHORT)
				.show();
		
		finish();
	}

	@Override
	public void onDataFailure(String error) {
		Toast.makeText(this, "Could not add item. Please retry.",
				Toast.LENGTH_SHORT).show();
	}
}
