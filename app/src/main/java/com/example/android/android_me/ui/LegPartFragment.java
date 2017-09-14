package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Administrator on 2017/9/9.
 */

public class LegPartFragment extends Fragment {
    public LegPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container,false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        imageView.setImageResource(AndroidImageAssets.getLegs().get(0));

        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
