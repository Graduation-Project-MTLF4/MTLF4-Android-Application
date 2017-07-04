package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Models.MainHomeItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.ViewHolders.MainHomeViewHolder;

public class MainHomeAdapter extends RecyclerView.Adapter<MainHomeViewHolder> {

    private List<MainHomeItem> itemList;
    private Context context;

    public MainHomeAdapter(Context context, List<MainHomeItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MainHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, null);
        MainHomeViewHolder rcv = new MainHomeViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MainHomeViewHolder holder, int position) {
        holder.texttitle.setText(itemList.get(position).getName());
        //holder.photo.setImageResource(itemList.get(position).getPhoto());

        Glide.with(holder.photo.getContext()).load(itemList.get(position).getPhoto()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}