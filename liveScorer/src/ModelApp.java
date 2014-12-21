import java.util.ArrayList;

import com.example.livescorer.Klub;

import android.content.Context;


public class ModelApp {
	private ArrayList<Klub> mKlubovi;
	private static ModelApp sModelApp;
	private Context mAppContext;
	
	private ModelApp(Context appContext){
		mAppContext = appContext;
		mKlubovi = new ArrayList<Klub>();
		
		// napuni klubove
		
		
	}
	
	public static ModelApp get(Context c){
		if (sModelApp == null){
			sModelApp = new ModelApp(c.getApplicationContext());
		}
		return sModelApp;
	}
	
	public ArrayList<Klub> getKlubovi(){
		return mKlubovi;
	}
	
	public Klub getKlub(Integer id){
		for (Klub k : mKlubovi){
			if (k.getIdKlub().equals(id))
				return k;
		}
		return null;
	}

}
