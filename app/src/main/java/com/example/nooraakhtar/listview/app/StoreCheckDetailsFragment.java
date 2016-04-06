package com.example.nooraakhtar.listview.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nooraakhtar.listview.R;
import com.example.nooraakhtar.listview.adapter.StoreCheckDetailAdapter;
import com.example.nooraakhtar.listview.model.StoreCheckDetail;

/**
 * Created by Noora.Akhtar on 05/04/2016.
 */
public class StoreCheckDetailsFragment extends Fragment {
    public StoreCheckDetailAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.storecheck_details, container, false);
        setUpStoreCheckDetails(view);
        return view;
    }

    public void setUpStoreCheckDetails(View view){
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.storecheckDetailsView);
        Context context = this.getActivity();

        adapter = new StoreCheckDetailAdapter(context, StoreCheckDetail.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }



}
