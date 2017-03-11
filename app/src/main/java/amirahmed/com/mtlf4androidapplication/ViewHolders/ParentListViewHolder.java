package amirahmed.com.mtlf4androidapplication.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import amirahmed.com.mtlf4androidapplication.Activities.LoginActivity;
import amirahmed.com.mtlf4androidapplication.Activities.RegistrationActivity;
import amirahmed.com.mtlf4androidapplication.Models.ParentList;
import amirahmed.com.mtlf4androidapplication.R;


public class ParentListViewHolder extends GroupViewHolder {

    private TextView parentTitle;
    private ImageView icon;
    Context context;



    public ParentListViewHolder(View itemView) {
        super(itemView);
        parentTitle = (TextView)itemView.findViewById(R.id.list_item_parent_name);
        icon = (ImageView) itemView.findViewById(R.id.list_item_parent_icon);
        context = itemView.getContext();
        Typeface type = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/HacenTunisiaBold.ttf");
        parentTitle.setTypeface(type);

        parentTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                switch (getLayoutPosition())
                {
                    case 0:
                        intent = new Intent(context , LoginActivity.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(context , RegistrationActivity.class);
                        context.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(context , RegistrationActivity.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    public void setParentTitle(ExpandableGroup genre){
        parentTitle.setText(genre.getTitle());
        icon.setBackgroundResource(((ParentList) genre).getIconResId());
    }
}
