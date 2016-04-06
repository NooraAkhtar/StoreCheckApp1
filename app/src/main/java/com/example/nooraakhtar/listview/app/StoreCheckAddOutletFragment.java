package com.example.nooraakhtar.listview.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nooraakhtar.listview.R;

/**
 * Created by Noora.Akhtar on 06/04/2016.
 */
public class StoreCheckAddOutletFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.storecheck_addoutlet, container, false);
        return view;
    }
}
