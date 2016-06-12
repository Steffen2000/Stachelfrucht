package com.test.honk.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class InfoWindow {

    protected View mView;
    protected boolean mIsVisible = false;
    protected MapView mMapView;

    public InfoWindow(int layoutResId, MapView mapView) {
        mMapView = mapView;
        mIsVisible = false;
        ViewGroup parent=(ViewGroup)mapView.getParent();
        Context ctx = mapView.getContext();
        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*
        if (layoutResId == 0)
            layoutResId = R.layout.bonuspack_bubble;
        */
        mView = inflater.inflate(layoutResId, parent, false);
        mView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                close();
            }
        });


    }

    public View getView() {
        return(mView);
    }

    public void open(GeoPoint position, int offsetX, int offsetY) {
        MapView.LayoutParams lp=new MapView.LayoutParams(
                MapView.LayoutParams.WRAP_CONTENT,
                MapView.LayoutParams.WRAP_CONTENT,
                position, MapView.LayoutParams.BOTTOM_CENTER,
                offsetX, offsetY);
        close();
        mMapView.addView(mView, lp);
        mIsVisible = true;
    }

    public void close() {
        if (mIsVisible) {
            mIsVisible = false;
            ((ViewGroup)mView.getParent()).removeView(mView);
        }
    }

    public void setPosition(GeoPoint p, int offsetX, int offsetY){
        if (mIsVisible){
            open(p, offsetX, offsetY);
        }
    }



}