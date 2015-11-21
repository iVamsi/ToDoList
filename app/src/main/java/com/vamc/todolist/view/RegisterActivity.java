package com.vamc.todolist.view;

import com.vamc.todolist.R;
import com.vamc.todolist.model.User;
import com.vamc.todolist.services.ServiceManager;
import com.vamc.todolist.services.ServiceManager.OnDataReceived;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnDataReceived {
	
	private static final String TAG = RegisterActivity.class.getSimpleName();
	
	private EditText mEdtUsername;
	private EditText mEdtPassword;
	private EditText mEdtEmail;
	private Button mBtnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		mEdtUsername = (EditText) findViewById(R.id.edtUsernameSignUp);
		mEdtPassword = (EditText) findViewById(R.id.edtPasswordSignUp);
		mEdtEmail = (EditText) findViewById(R.id.edtEmail);

		mBtnRegister = (Button) findViewById(R.id.btnRegisterSignUp);

		mBtnRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				User user = new User();
				user.setApplicantId(1);
				user.setApplicantName(mEdtUsername.getText().toString());
				user.setPassword(mEdtPassword.getText().toString());
				user.setEmailMail(mEdtEmail.getText().toString());
				user.setValidUser("true");
				
				ServiceManager serviceManager = new ServiceManager(RegisterActivity.this, RegisterActivity.this);
				serviceManager.register(user);
			}
		});
	}

	@Override
	public void onDataSuccess(Object object) {
		Toast.makeText(this, "Registration Success.", Toast.LENGTH_SHORT).show();

        finish();
	}

	@Override
	public void onDataFailure(String error) {
		Toast.makeText(this, "Registration failed. Please retry.", Toast.LENGTH_SHORT).show();
	}
}
