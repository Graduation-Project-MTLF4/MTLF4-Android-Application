package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Activities.FavoritesActivity;
import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    static Context context;

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {

        CardView cv20;
        TextView Name;
        TextView Details;
        ImageView sharpPic;
        LikeButton fav;


        FavoritesViewHolder(View itemView) {
            super(itemView);
            cv20 = (CardView)itemView.findViewById(R.id.cv);
            context = itemView.getContext();
            Name = (TextView)itemView.findViewById(R.id.name);
            Details = (TextView)itemView.findViewById(R.id.details);
            sharpPic = (ImageView)itemView.findViewById(R.id.pic);
            fav = (LikeButton) itemView.findViewById(R.id.star_button2);


            //fav.setLiked(true);
            fav.setVisibility(View.GONE);

        }
    }

    List<PostItem> postItems;

    public FavoritesAdapter(List<PostItem> postItems){

        this.postItems = postItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        FavoritesViewHolder pvh = new FavoritesViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder favoritesViewHolder, final int i) {
        final TinyDB tinydb = new TinyDB(context);

        favoritesViewHolder.Name.setText(postItems.get(i).name);
        favoritesViewHolder.Details.setText(postItems.get(i).details);
        favoritesViewHolder.sharpPic.setImageResource(postItems.get(i).photoId);

        favoritesViewHolder.fav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {


            }

            @Override
            public void unLiked(LikeButton likeButton) {
                FavoritesActivity.postItems2.remove(i);
                tinydb.putBoolean("value",false);

            }
        });
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
