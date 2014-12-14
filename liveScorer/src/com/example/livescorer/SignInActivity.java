package com.example.livescorer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

public class SignInActivity  extends AsyncTask<String,Void,String>{

   private TextView statusField,roleField;

   public static Boolean loginFlag;
   public static String RoleResult;
   public static String UserName;

   
   public SignInActivity(Context context,TextView statusField,
   TextView roleField, liveScorerObjekt lSO) {
      this.statusField = statusField;
      this.roleField = roleField;

   }

   protected void onPreExecute(){

   }
   @Override
   protected String doInBackground(String... arg0) {
         try{
            String username = (String)arg0[0];
            String password = (String)arg0[1];
            String link="http://livescorer.dubrovnik-news.eu/korisnik.php";
            String data  = URLEncoder.encode("username", "UTF-8") 
            + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") 
            + "=" + URLEncoder.encode(password, "UTF-8");
            URL url = new URL(link);
            URLConnection conn = url.openConnection(); 
            conn.setDoOutput(true); 
            OutputStreamWriter wr = new OutputStreamWriter
            (conn.getOutputStream()); 
            wr.write( data ); 
            wr.flush(); 
            BufferedReader reader = new BufferedReader
            (new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null)
            {
               sb.append(line);

               loginFlag = (true);

               break;
            }
            return sb.toString();
         }catch(Exception e){
        	 e.printStackTrace();

        	 loginFlag = (false);

        	 return new String("Exception: " + e.getMessage());
         }
      }
   @Override
   protected void onPostExecute(String result){

	  
	  RoleResult = (result); 
	  if (loginFlag){
		  this.statusField.setText("Login Successful");
		  this.roleField.setText(result); 
		  UserName = (result.substring(0, result.indexOf(':')));
	  }
	  
   }
}
