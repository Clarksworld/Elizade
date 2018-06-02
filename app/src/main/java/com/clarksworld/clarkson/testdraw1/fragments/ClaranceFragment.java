package com.clarksworld.clarkson.testdraw1.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clarksworld.clarkson.testdraw1.R;


/**
 * Created by CLARKSWORLD on 24/04/2018.
 */

public class ClaranceFragment extends Fragment {

    public ClaranceFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  =  inflater.inflate(R.layout.fragment_clarance,container,false);
        return view;
    }
}
