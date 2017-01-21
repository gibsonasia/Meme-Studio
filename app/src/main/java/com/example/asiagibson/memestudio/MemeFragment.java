package com.example.asiagibson.memestudio;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asiagibson.memestudio.RV.MemeAdapter;

/**
 * Created by asiagibson on 1/19/17.
 */

public class MemeFragment extends Fragment {

    RecyclerView rv;
    MemeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rv, container, false);

        rv =(RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new MemeAdapter();
        rv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(adapter);
        return view;
    }
}