package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Activities.FavoritesActivity;
import amirahmed.com.mtlf4androidapplication.Activities.PostDetailsActivity;
import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    static Context context;

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        CardView cv20;
        TextView Name;
        TextView Details;
        ImageView sharpPic;
        TextView viewsnumber;
        LikeButton like;
        LikeButton fav;


        PostViewHolder(View itemView) {
            super(itemView);
            cv20 = itemView.findViewById(R.id.cv);
            context = itemView.getContext();
            Name = itemView.findViewById(R.id.name);
            Details = itemView.findViewById(R.id.details);
            viewsnumber = itemView.findViewById(R.id.viewsnumber);
            sharpPic = itemView.findViewById(R.id.pic);
            like = itemView.findViewById(R.id.star_button);
            fav = itemView.findViewById(R.id.star_button2);

            final SharedPreferences mypref = PreferenceManager.getDefaultSharedPreferences(context);
            final String userID = (mypref.getString("KeyID","1"));

            if (userID.equals("1"))
            {
                fav.setVisibility(View.VISIBLE);
            } else if(userID.equals("2"))
            {
                fav.setVisibility(View.GONE);
            }

            cv20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context , PostDetailsActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }

    List<PostItem> postItems;

    public PostAdapter(List<PostItem> postItems){

        this.postItems = postItems;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder postViewHolder, final int i) {
        postViewHolder.Name.setText(postItems.get(i).name);
        postViewHolder.Details.setText(postItems.get(i).details);
        postViewHolder.viewsnumber.setText(postItems.get(i).viewsnumber);
        //postViewHolder.sharpPic.setImageBitmap(Bitmap.createScaledBitmap(postItems.get(i).photoId, 120, 120, false));
        Glide.with(postViewHolder.sharpPic.getContext()).load(postItems.get(i).photoId).into(postViewHolder.sharpPic);



        postViewHolder.fav.setLiked(postItems.get(i).fav);
        postViewHolder.like.setLiked(postItems.get(i).like);

        final TinyDB tinydb = new TinyDB(context);

        postViewHolder.like.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

                tinydb.putBoolean("valuelike",true);


                postItems.get(i).setLike(tinydb.getBoolean("valuelike"));

            }

            @Override
            public void unLiked(LikeButton likeButton) {

                tinydb.putBoolean("valuelike",false);

                postItems.get(i).setLike(tinydb.getBoolean("valuelike"));

            }
        });

        postViewHolder.fav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

                tinydb.putBoolean("valuefav",true);


                postItems.get(i).setFav(tinydb.getBoolean("valuefav"));
                FavoritesActivity.postItems2.add(new PostItem(postItems.get(i).name,postItems.get(i).details,postItems.get(i).photoId,postItems.get(i).viewsnumber,postItems.get(i).fav,postItems.get(i).like));

            }

            @Override
            public void unLiked(LikeButton likeButton) {

                tinydb.putBoolean("valuefav",false);

                postItems.get(i).setFav(tinydb.getBoolean("valuefav"));
                FavoritesActivity.postItems2.remove(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
