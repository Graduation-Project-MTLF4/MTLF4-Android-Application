package amirahmed.com.mtlf4androidapplication.Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Models.ShopItem;
import amirahmed.com.mtlf4androidapplication.Activities.ProfileActivity;
import amirahmed.com.mtlf4androidapplication.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class ShopsListAdapter extends RecyclerView.Adapter<ShopsListAdapter.ShopsViewHolder> {

    List<ShopItem> shop;

    public ShopsListAdapter(List<ShopItem> shop) {
        this.shop = shop;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ShopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent, false);
        ShopsViewHolder svh = new ShopsViewHolder(v);
        return svh;
    }


    @Override
    public void onBindViewHolder(ShopsViewHolder holder, int position) {
        holder.name.setText(shop.get(position).getName());
        holder.number.setText(shop.get(position).getNumber());
        holder.cr.setImageResource(shop.get(position).getPic());
    }

    @Override
    public int getItemCount() {

        return shop.size();
    }

    public static class ShopsViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView number;
        CircleImageView cr;
        Context context;

        public ShopsViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cv2);
            name = (TextView) itemView.findViewById(R.id.shopName);
            number = (TextView) itemView.findViewById(R.id.takeem);
            cr = (CircleImageView)itemView.findViewById(R.id.profile_image);
            Typeface type = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/HacenTunisiaBold.ttf");
            name.setTypeface(type);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context , ProfileActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }
}