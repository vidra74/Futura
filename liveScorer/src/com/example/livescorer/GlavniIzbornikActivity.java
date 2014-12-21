package com.example.livescorer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class GlavniIzbornikActivity extends Activity {
	
	private TextView m_tvKorisnik;
	private FragmentManager manager;
	private Fragment fragment;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavni_izbornik);
        m_tvKorisnik = (TextView)findViewById(R.id.tvKorisnik);
        m_tvKorisnik.setText(getIntent().getStringExtra("LOGIN"));
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        manager = getFragmentManager();
        fragment = manager.findFragmentById(R.id.rlFragContainer);
    }
    
    private void PrikaziPoruku(String userPressed) {

        Toast.makeText(this, userPressed, Toast.LENGTH_SHORT)
            .show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    	
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {    
         return MenuChoice(item);    
    }    
    
    private void CreateMenu(Menu menu)
    {
        MenuItem mnu1 = menu.add(0, 0, 0, R.string.button_Podaci);
        {         
            mnu1.setIcon(R.drawable.ic_launcher);
            mnu1.setShowAsAction(
            	MenuItem.SHOW_AS_ACTION_IF_ROOM |
                MenuItem.SHOW_AS_ACTION_WITH_TEXT);            
        }
        MenuItem mnu2 = menu.add(0, 1, 1, R.string.button_Klub);
        {         
            mnu2.setIcon(R.drawable.ic_launcher);            
            mnu2.setShowAsAction(
            	MenuItem.SHOW_AS_ACTION_IF_ROOM |
                MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }
        MenuItem mnu3 = menu.add(0, 2, 2, R.string.button_Natjecanje);
        {         
            mnu3.setIcon(R.drawable.ic_launcher);
            mnu3.setShowAsAction(
            	MenuItem.SHOW_AS_ACTION_IF_ROOM |
                MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        }

    }
 
    private boolean MenuChoice(MenuItem item)
    {        
        switch (item.getItemId()) {
        case  android.R.id.home:
        	PrikaziPoruku("You clicked on the Application icon"); 
            return true;
        case 0:
        	PrikaziPoruku("You clicked on " + getString(R.string.button_Podaci));     	
        	PrikaziPodatke();
        	return true;
        case 1:
        	new ReadJSONFeedTask().execute("http://livescorer.dubrovnik-news.eu/klub_select.php"); 
            return true;
        case 2:
        	PrikaziPoruku("You clicked on " + getString(R.string.button_Natjecanje)); 
            return true;      
        }
        return false;
    }
    
    private void PrikaziPodatke(){
    	try{
    		if (fragment == null) {
    			fragment = new FragmentPodaci();
    			manager.beginTransaction()
                	.add(R.id.rlFragContainer, fragment)
                	.commit();
    		}	
        } catch(Exception e) {
       	 e.printStackTrace();
        } 
    }
    
	public String readJSONFeed(String URL) {
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} else {
				Log.e("JSON", "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
    private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }
        
        protected void onPostExecute(String result) {
        	try {
        		JSONArray jsonArr = new JSONArray(result);
    			Log.i("JSON", "Text: " + result);
   				
    			for (int i = 0; i < jsonArr.length(); i++) {
    				
    				JSONObject jsonObject = jsonArr.getJSONObject(i);
        			Toast.makeText(getBaseContext(), 
							jsonObject.getString("id") + " - " + jsonObject.getString("ime_kluba"), 
						Toast.LENGTH_SHORT).show();	
				}
    			

    		} catch (Exception e) {
    			e.printStackTrace();
    		}        
        }
    }
	
}
