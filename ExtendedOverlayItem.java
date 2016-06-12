package com.test.honk.test;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.OverlayItem;
import android.graphics.drawable.Drawable;

public class ExtendedOverlayItem extends OverlayItem {

    private String mTitle, mDescription; // now, they are modifiable
    private String mSubDescription; //a third field that can be displayed in the infowindow, on a third line
    private Drawable mImage; //that will be shown in the infowindow.
    //private GeoPoint mGeoPoint //unfortunately, this is not so simple...

    public ExtendedOverlayItem(String aTitle, String aDescription, GeoPoint aGeoPoint) {
        super(aTitle, aDescription, aGeoPoint);
        mTitle = aTitle;
        mDescription = aDescription;
        mSubDescription = null;
        mImage = null;
    }

    public void setTitle(String aTitle){
        mTitle = aTitle;
    }

    public void setDescription(String aDescription){
        mDescription = aDescription;
    }

    public void setSubDescription(String aSubDescription){
        mSubDescription = aSubDescription;
    }

    public void setImage(Drawable anImage){
        mImage = anImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getSubDescription() {
        return mSubDescription;
    }

    public Drawable getImage() {
        return mImage;
    }

    public GeoPoint getPoint(){
        return mGeoPoint;
    }

}