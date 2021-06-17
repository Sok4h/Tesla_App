package com.sokah.teslaapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sokah.teslaapp.R;
import com.sokah.teslaapp.adapters.CarAdapter;


public class HomeFragment extends Fragment {





    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerview;
    LinearLayoutManager layoutManager;
    CarAdapter carAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        layoutManager= new LinearLayoutManager(getContext());
        carAdapter = new CarAdapter();
        recyclerview= root.findViewById(R.id.carsViewList);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(carAdapter);
        return root;
    }
}