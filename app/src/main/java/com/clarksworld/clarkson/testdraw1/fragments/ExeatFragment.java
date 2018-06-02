package com.clarksworld.clarkson.testdraw1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.clarksworld.clarkson.testdraw1.R;


/**
 * Created by CLARKSWORLD on 24/04/2018.
 */

public class ExeatFragment extends Fragment {

    ImageView exeatImage, exeatInfoImage;
    FloatingActionButton floatingActionButton;

    public ExeatFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_exeat,container,false);
       exeatImage = view.findViewById(R.id.exeat_image);
       exeatInfoImage = view.findViewById(R.id.exeat_info_image);
       floatingActionButton = view.findViewById(R.id.fab_btn);
        return view;
    }
}
