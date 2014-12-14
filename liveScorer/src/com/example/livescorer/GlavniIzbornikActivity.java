package com.example.livescorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GlavniIzbornikActivity extends Activity {
	
	private TextView m_tvKorisnik;
	private Button m_buttonNatjecanje; 
	private Button m_buttonKlub;
	private Button m_buttonPodaci;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavni_izbornik);
        m_tvKorisnik = (TextView)findViewById(R.id.tvKorisnik);
        m_tvKorisnik.setText(getIntent().getStringExtra("LOGIN"));
        
        m_buttonNatjecanje = (Button)findViewById(R.id.btnNatjecanje);		
        m_buttonNatjecanje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	checkKeyPress("m_buttonNatjecanje");
            }
        });
        
        m_buttonKlub = (Button)findViewById(R.id.btnKlub);		
        m_buttonKlub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	checkKeyPress("m_buttonKlub");
            }
        });
        
        m_buttonPodaci = (Button)findViewById(R.id.btnPodaci);		
        m_buttonPodaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Toast.makeText(GlavniIzbornikActivity.this, "m_buttonPodaci", Toast.LENGTH_SHORT)
                .show();
            }
        });
    }
    
    private void checkKeyPress(String userPressed) {

        Toast.makeText(this, userPressed, Toast.LENGTH_SHORT)
            .show();
    }
	
}
