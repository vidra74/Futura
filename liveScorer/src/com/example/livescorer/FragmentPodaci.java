package com.example.livescorer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPodaci extends Fragment {
	private Podaci mPodaci;
	TextView mTitleField;
	
	public void OnCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mPodaci = new Podaci();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, 
								ViewGroup parent, 
								Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.frag_podaci,  parent, false);

        mTitleField = (TextView)v.findViewById(R.id.tvPodaci);
        mTitleField.setText(mPodaci.getStrPodaci());
        
		return v;
	}
	


	
}
