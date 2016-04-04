package com.example.nooraakhtar.listview.app;


import android.app.SearchManager;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.support.v7.widget.SearchView;

import com.example.nooraakhtar.listview.R;
import com.example.nooraakhtar.listview.adapter.StoreCheckDetailAdapter;
import com.example.nooraakhtar.listview.adapter.StoreCheckNavigationAdapter;
import com.example.nooraakhtar.listview.model.StoreCheckDetail;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {


    Toolbar toolbar;
    EditText productSearch;
    StoreCheckDetailAdapter adapter;
    private SearchView.OnQueryTextListener queryTextListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setupToolbar();
            setUpNavigationView();
            setUpStoreCheckDetailsView();
        }
        catch (Exception e) {
        Log.i("Main Activity Exception", e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.storecheck_menu, menu);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView)menu.findItem(R.id.searchItem).getActionView();

        if(searchView!=null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener(){
                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.i("onQueryTextChange", newText);
                    adapter.filterByProduct(newText);
                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.i("onQueryTextSubmit", query);

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.searchItem:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Welcome !");
        toolbar.setSubtitle("View Products");

        toolbar.setTitle("Store-check details");
        toolbar.inflateMenu(R.menu.storecheck_menu);

        //test
    }


    private void setUpStoreCheckDetailsView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.storecheckitemsView);
        adapter = new StoreCheckDetailAdapter(this, StoreCheckDetail.getData());

        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void setUpNavigationView() {
        try {
            StoreCheckNavigationFragment drawerFragment = (StoreCheckNavigationFragment) getSupportFragmentManager().findFragmentById(R.id.storeCheckNavDrawerFragment);
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerFragment.setUpDrawer(R.id.storeCheckNavDrawerFragment, drawerLayout, toolbar);
        }
        catch (Exception e){
            Log.i("Setup Drawer", e.getMessage());
        }
    }
}
