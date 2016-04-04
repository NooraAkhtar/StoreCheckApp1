package com.example.nooraakhtar.listview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nooraakhtar.listview.R;
import com.example.nooraakhtar.listview.model.StoreCheckNavigationDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by Noora.Akhtar on 02/04/2016.
 */
public class StoreCheckNavigationAdapter extends RecyclerView.Adapter<StoreCheckNavigationAdapter.ItemsViewHolder> {
    private List<StoreCheckNavigationDrawerItem> drawerItems = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public StoreCheckNavigationAdapter(Context context, List<StoreCheckNavigationDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.drawerItems = data;
    }

    public StoreCheckNavigationAdapter.ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.storecheck_navigation_item, parent, false);
        ItemsViewHolder holder = new ItemsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder holder, int position){
        StoreCheckNavigationDrawerItem current = drawerItems.get(position);

        holder.title.setText(current.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
       // ImageView imgIcon;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            //imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        }
    }
}
