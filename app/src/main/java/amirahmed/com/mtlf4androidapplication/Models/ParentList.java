package amirahmed.com.mtlf4androidapplication.Models;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ParentList extends ExpandableGroup {

    private int iconResId;

    public ParentList(String title, List<ChildList> items, int iconResId) {
        super(title, items);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentList)) return false;

        ParentList parentList = (ParentList) o;

        return getIconResId() == parentList.getIconResId();

    }

    @Override
    public int hashCode() {
        return getIconResId();
    }

}
