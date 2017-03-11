package amirahmed.com.mtlf4androidapplication.Fragments;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Activities.ShopPageTwo;

public class ShopRegistrationFragment extends Fragment {

    Button b;

    public ShopRegistrationFragment()
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
        return inflater.inflate(R.layout.registration_shop_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b = (Button) getActivity().findViewById(R.id.follow_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext() , ShopPageTwo.class);
                getContext().startActivity(intent);

            }
        });
    }
}
