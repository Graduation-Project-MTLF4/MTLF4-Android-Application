package amirahmed.com.mtlf4androidapplication.ViewHolders;



import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import amirahmed.com.mtlf4androidapplication.R;

public class MainHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView texttitle;
    public ImageView photo;

    public MainHomeViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        texttitle = (TextView)itemView.findViewById(R.id.texttitle);
        photo = (ImageView)itemView.findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}