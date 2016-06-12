package com.test.honk.test;


import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Display;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity  {
    private MapView mMapView;
    private MapController mMapController;
    private GeoPoint gPt;

    protected ItemizedOverlayWithBubble<ExtendedOverlayItem> markerOverlays;
    protected ExtendedOverlayItem markerStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mMapView.setBuiltInZoomControls(true);
        mMapController = (MapController) mMapView.getController();
        mMapController.setZoom(13);


        gPt= new GeoPoint(53.562488 , 9.959889 );
       // gPt= new GeoPoint(0 , 0);
        mMapController.setCenter(gPt);


      //  gPt= new GeoPoint(153.562488 , 9.959889 );
        mMapController.animateTo(gPt);

        GeoPoint myPoint1 = new GeoPoint(53.562488, 9.959889);
        final ArrayList<ExtendedOverlayItem> waypointsItems = new ArrayList<ExtendedOverlayItem>();
        markerOverlays = new ItemizedOverlayWithBubble<ExtendedOverlayItem>(this, waypointsItems, mMapView);
        mMapView.getOverlays().add(markerOverlays);
        markerStart = putMarkerItem(null, myPoint1, "Start", R.drawable.test1, R.drawable.test1);
    }


    @Override
    protected void onDestroy() {
        try{
         //  unregisterReceiver();
        }catch(Exception e)
        {

        }


        super.onDestroy();




    }

    public ExtendedOverlayItem putMarkerItem(ExtendedOverlayItem item, GeoPoint p, String title, int markerResId, int iconResId) {
        Drawable marker = getResources().getDrawable(markerResId);
        ExtendedOverlayItem overlayItem = new ExtendedOverlayItem(title, "", p);

        overlayItem.setMarker(marker);
        overlayItem.setImage(getResources().getDrawable(iconResId));
        markerOverlays.addItem(overlayItem);
        mMapView.invalidate();

        return overlayItem;
    }

}


/* HAVE THIS AS YOUR osm_main.xml
---------------------------------------------------------- XML START
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >
    <org.osmdroid.views.MapView
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/mapview"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:clickable="true" />
</LinearLayout>
---------------------------------------------------------- XML END
Include slf4j-android-1.5.8.jar and osmdroid-android-4.1.jar in the build path
(Google search for where to get them from)
*/