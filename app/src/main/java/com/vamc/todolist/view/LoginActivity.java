package com.vamc.todolist.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vamc.todolist.R;
import com.vamc.todolist.model.RuntimeData;
import com.vamc.todolist.model.User;
import com.vamc.todolist.services.ServiceManager;
import com.vamc.todolist.services.ServiceManager.OnDataReceived;

public class LoginActivity extends Activity implements OnDataReceived {
	private static final String TAG = LoginActivity.class.getSimpleName();
	
	private EditText mEdtUsername;
	private EditText mEdtPassword;
	private Button mBtnLogin;
	private Button mBtnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);

		mEdtUsername = (EditText) findViewById(R.id.edtUsername);
		mEdtPassword = (EditText) findViewById(R.id.edtPassword);
		mBtnLogin = (Button) findViewById(R.id.btnLogin);
		mBtnRegister = (Button) findViewById(R.id.btnRegister);

		mBtnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				User user = new User();
				user.setApplicantId(1);
				user.setApplicantName(mEdtUsername.getText().toString());
				user.setPassword(mEdtPassword.getText().toString());
				user.setEmailMail("hello@hello.com");
				user.setValidUser("true");
				
				ServiceManager serviceManager = new ServiceManager(LoginActivity.this, LoginActivity.this);
				serviceManager.login(user);
			}
		});

		mBtnRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onDataSuccess(Object object) {
		User user = (User) object;
		
		RuntimeData.sUser = user;
		
		if (user.getValidUser().equalsIgnoreCase("TRUE")) {
			Toast.makeText(this, "Login Successful.", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(LoginActivity.this, TodoListActivity.class);
			startActivity(intent);
			
			finish();
		} else {
			Toast.makeText(this, "User does not exist. Please register.", Toast.LENGTH_SHORT).show();
			
			mEdtUsername.setText("");
			mEdtPassword.setText("");
		}
	}

	@Override
	public void onDataFailure(String error) {
		Toast.makeText(this, "User does not exist. Please register.", Toast.LENGTH_SHORT).show();
	}
}
