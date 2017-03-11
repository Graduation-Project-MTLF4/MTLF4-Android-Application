package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Models.PostItem;
import amirahmed.com.mtlf4androidapplication.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {


    public static class PostViewHolder extends RecyclerView.ViewHolder {

        CardView cv20;
        TextView Name;
        TextView Details;
        ImageView sharpPic;
        Context context;

        PostViewHolder(View itemView) {
            super(itemView);
            cv20 = (CardView)itemView.findViewById(R.id.cv);
            context = itemView.getContext();
            Name = (TextView)itemView.findViewById(R.id.name);
            Details = (TextView)itemView.findViewById(R.id.details);
            sharpPic = (ImageView)itemView.findViewById(R.id.pic);

        }
    }

    List<PostItem> postItems;

    public PostAdapter(List<PostItem> postItems){

        this.postItems = postItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder sharpViewHolder, int i) {
        sharpViewHolder.Name.setText(postItems.get(i).name);
        sharpViewHolder.Details.setText(postItems.get(i).details);
        sharpViewHolder.sharpPic.setImageResource(postItems.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
