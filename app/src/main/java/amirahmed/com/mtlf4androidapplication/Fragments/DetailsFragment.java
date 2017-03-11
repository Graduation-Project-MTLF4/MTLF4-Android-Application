package amirahmed.com.mtlf4androidapplication.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amirahmed.com.mtlf4androidapplication.R;

public class DetailsFragment extends Fragment {

    public DetailsFragment()
    {
        //Empty Constrictor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tx = (TextView)getActivity().findViewById(R.id.comName);
        Typeface type = Typeface.createFromAsset(getContext().getAssets(),"fonts/HacenTunisiaBold.ttf");
        tx.setTypeface(type);

    }
}
