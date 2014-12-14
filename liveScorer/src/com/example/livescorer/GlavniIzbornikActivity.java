package com.example.livescorer;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        fragment = manager.findFragmentById(R.id.rlFragment);
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

            Intent i = new Intent(this, GlavniIzbornikActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

            return true;
        case 0:
        	PrikaziPoruku("You clicked on " + getString(R.string.button_Podaci)); 
            PrikaziPodatke();
        	return true;
        case 1:
        	PrikaziPoruku("You clicked on " + getString(R.string.button_Klub)); 
            return true;
        case 2:
        	PrikaziPoruku("You clicked on " + getString(R.string.button_Natjecanje)); 
            return true;      
        }
        return false;
    }
    
    private void PrikaziPodatke(){
        if (fragment == null) {
            fragment = new FragmentPodaci();
            manager.beginTransaction()
                .add(R.id.rlFragment, fragment)
                .commit();
        } 
    }
	
}
