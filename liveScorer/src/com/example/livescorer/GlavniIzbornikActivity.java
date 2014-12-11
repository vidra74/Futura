package com.example.livescorer;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GlavniIzbornikActivity extends Activity {
	
	private TextView Korisnik;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavni_izbornik);
        Korisnik = (TextView)findViewById(R.id.tvKorisnik);
        
        Korisnik.setText(getIntent().getStringExtra("LOGIN"));
    }
	
}
