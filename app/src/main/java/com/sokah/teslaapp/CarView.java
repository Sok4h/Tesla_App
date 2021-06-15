package com.sokah.teslaapp;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;



public class CarView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private TextView tvCarName,tvCarWaranty,tvCarPrice;
    private ImageView carImage;
    private Button btnBuy;

    public CarView( ConstraintLayout root) {


        super(root);
        this.root=root;
        tvCarName=root.findViewById(R.id.tvCarName);
        tvCarWaranty=root.findViewById(R.id.tvCarWaranty);
        tvCarPrice=root.findViewById(R.id.tvCarPrice);
        carImage=root.findViewById(R.id.imgCar);
        btnBuy=root.findViewById(R.id.btnBuy);
    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public TextView getTvCarName() {
        return tvCarName;
    }

    public TextView getTvCarWaranty() {
        return tvCarWaranty;
    }

    public TextView getTvCarPrice() {
        return tvCarPrice;
    }

    public ImageView getCarImage() {
        return carImage;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }
}
