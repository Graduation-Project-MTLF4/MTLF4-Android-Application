package amirahmed.com.mtlf4androidapplication.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import amirahmed.com.mtlf4androidapplication.Activities.FavoritesActivity;
import amirahmed.com.mtlf4androidapplication.Activities.LoginActivity;
import amirahmed.com.mtlf4androidapplication.Activities.MyProfileActivity;
import amirahmed.com.mtlf4androidapplication.Activities.StatsticsActivity;
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

        final SharedPreferences mypref = PreferenceManager.getDefaultSharedPreferences(context);
        final String userID = (mypref.getString("KeyID","1"));

        parentTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                switch (getLayoutPosition())
                {
                    case 0:
                        if(userID.equals("1"))
                        {
                            intent = new Intent(context , FavoritesActivity.class);
                            context.startActivity(intent);
                            break;
                        } else if(userID.equals("2"))
                        {
                            intent = new Intent(context , StatsticsActivity.class);
                            context.startActivity(intent);
                            break;
                        }

                    case 1:
                        intent = new Intent(context , MyProfileActivity.class);
                        context.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(context , LoginActivity.class);
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
