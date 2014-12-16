package com.example.livescorer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentPodaci extends Fragment {
	Podaci mPodaci;
	TextView mTitleField;
	
	public void OnCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, 
								ViewGroup parent, 
								Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.frag_podaci,  parent, false);
		mPodaci = new Podaci();
        mTitleField = (TextView)v.findViewById(R.id.tvFragPodaci);

		mPodaci.setPodatak("onCreateView");
		mTitleField.setText(mPodaci.getPodatak());		
		return v;
	}
	


	
}
