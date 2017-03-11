package amirahmed.com.mtlf4androidapplication.ViewHolders;


import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import amirahmed.com.mtlf4androidapplication.R;

public class ChildListViewHolder extends ChildViewHolder {

    public TextView childName;
    Context context;


    public ChildListViewHolder(View itemView) {
        super(itemView);
        childName = (TextView)itemView.findViewById(R.id.list_item_child_name);
        context = itemView.getContext();
        Typeface type = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/HacenTunisiaBold.ttf");
        childName.setTypeface(type);

    }

    public void setChildName(String name){
        childName.setText(name);
    }
}
