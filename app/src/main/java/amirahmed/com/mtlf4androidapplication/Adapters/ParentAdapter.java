package amirahmed.com.mtlf4androidapplication.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import amirahmed.com.mtlf4androidapplication.Models.ChildList;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.ViewHolders.ChildListViewHolder;
import amirahmed.com.mtlf4androidapplication.ViewHolders.ParentListViewHolder;

public class ParentAdapter extends ExpandableRecyclerViewAdapter<ParentListViewHolder, ChildListViewHolder> {


    public ParentAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentListViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_parent, parent, false);
        return new ParentListViewHolder(view);
    }

    @Override
    public ChildListViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_child, parent, false);
        return new ChildListViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildListViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        ChildList childList = (ChildList) group.getItems().get(childIndex);

        holder.setChildName(childList.getName());
        holder.childName.setCompoundDrawablesWithIntrinsicBounds(null, childList.getIcon(),null,null);
    }

    @Override
    public void onBindGroupViewHolder(ParentListViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setParentTitle(group);
        if(flatPosition ==3)
        {
            holder.itemView.setBackgroundResource(R.color.item_of_navigation);
        }

        if (flatPosition==4)
        {
            holder.itemView.setBackgroundResource(R.color.item_of_navigation);
        }

    }
}
