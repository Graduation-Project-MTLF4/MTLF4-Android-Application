package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Models.StatisticsItem;
import amirahmed.com.mtlf4androidapplication.R;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.StatsticsViewHolder> {

    public static class StatsticsViewHolder extends RecyclerView.ViewHolder {

        CardView cv20;
        TextView Title;
        TextView Date;
        TextView Likes;
        TextView Views;
        TextView Favorites;
        TextView Comments;

        Context context;

        StatsticsViewHolder(View itemView) {
            super(itemView);
            cv20 = (CardView)itemView.findViewById(R.id.cv);
            context = itemView.getContext();
            Title = (TextView)itemView.findViewById(R.id.title);
            Date = (TextView)itemView.findViewById(R.id.date);
            Likes = (TextView)itemView.findViewById(R.id.likes);
            Views = (TextView)itemView.findViewById(R.id.views);
            Favorites = (TextView)itemView.findViewById(R.id.favorites);
            Comments = (TextView)itemView.findViewById(R.id.comments);

        }
    }

    List<StatisticsItem> statsticsItems;

    public StatisticsAdapter(List<StatisticsItem> statsticsItems){

        this.statsticsItems = statsticsItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StatsticsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_statstics, viewGroup, false);
        StatsticsViewHolder pvh = new StatsticsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StatsticsViewHolder statsticsViewHolder, int i) {
        statsticsViewHolder.Title.setText(statsticsItems.get(i).title);
        statsticsViewHolder.Date.setText(statsticsItems.get(i).date);
        statsticsViewHolder.Likes.setText(statsticsItems.get(i).likes);
        statsticsViewHolder.Views.setText(statsticsItems.get(i).views);
        statsticsViewHolder.Favorites.setText(statsticsItems.get(i).favorites);
        statsticsViewHolder.Comments.setText(statsticsItems.get(i).comments);
    }

    @Override
    public int getItemCount() {
        return statsticsItems.size();
    }

}
