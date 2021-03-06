package com.example.livescorer;

import com.example.livescorer.R;
import com.example.livescorer.SignInActivity;
import com.example.livescorer.GlavniIzbornikActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	   
	private EditText usernameField,passwordField;
	private TextView status,role;
	private static liveScorerObjekt lSO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	      usernameField = (EditText)findViewById(R.id.editText1);
	      passwordField = (EditText)findViewById(R.id.editText2);
	      status = (TextView)findViewById(R.id.textView6);
	      role = (TextView)findViewById(R.id.textView7);
	      
	      lSO = new liveScorerObjekt();
	      

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void login(View view){
		
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();

		SignInActivity SIA = new SignInActivity(this,status,role,lSO);
		SIA.execute(username,password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lSO.SetLogined(SignInActivity.loginFlag);
		lSO.setRoleText(SignInActivity.RoleResult);
		lSO.setUserName(SignInActivity.UserName);
		
		if (lSO.IsLogined()){ 
			Intent loginResult = new Intent(this, GlavniIzbornikActivity.class);
			
			loginResult.putExtra("LOGIN", lSO.getRoleText());
			startActivity(loginResult);
		}
		


	}
	   
}
