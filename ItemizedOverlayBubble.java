package com.test.honk.test;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

class ItemizedOverlayWithBubble<Item extends OverlayItem> extends
        ItemizedIconOverlay<Item> {
    protected InfoWindow mBubble;
    private Context context;
    protected OverlayItem mItemWithBubble;
  //  final int mTitleId, mDescriptionId, mSubDescriptionId, mImageId;

    public ItemizedOverlayWithBubble(final Context context, final List<Item> aList,
                                     final MapView mapView) {
        super(context, aList, new OnItemGestureListener<Item>() {
            @Override public boolean onItemSingleTapUp(final int index, final
            OverlayItem item) {
                return false;
            }
            @Override public boolean onItemLongPress(final int index, final
            OverlayItem item) {
                return false;
            }
        });

        String packageName = context.getClass().getPackage().getName();
        int layoutId =
                context.getResources().getIdentifier("layout/activity_main" , null, packageName);
      /*  mTitleId = context.getResources().getIdentifier("id/bubble_title", null,
                packageName);
        mDescriptionId =
                context.getResources().getIdentifier("id/bubble_description", null, packageName);
        mSubDescriptionId =
                context.getResources().getIdentifier("id/bubble_subdescription", null, packageName);
        mImageId = context.getResources().getIdentifier( "id/bubble_image", null,
                packageName);*/
        mBubble = new InfoWindow(layoutId, mapView);
        mItemWithBubble = null;
    }

    public void showBubbleOnItem(int index, MapView mapView) {
        ExtendedOverlayItem eItem = (ExtendedOverlayItem)(getItem(index));
        mItemWithBubble = eItem;
        GeoPoint position = eItem.getPoint();
        //update the content of the bubble, based on the item tapped:
        View view = mBubble.getView();
      /*  ((TextView)view.findViewById(mTitleId /*R.id.title*
/)).setText(eItem.getTitle());
        ((TextView)view.findViewById(mDescriptionId /*R.id.description*
  /)).setText(eItem.getDescription());

        //handle mSubDescription, hidding or showing the text view:
        TextView subDescText = (TextView)view.findViewById(mSubDescriptionId);
        String subDesc = eItem.getSubDescription();
        if (subDesc != null && !("".equals(subDesc))){
            subDescText.setText(subDesc);
            subDescText.setVisibility(View.VISIBLE);
        } else {
            subDescText.setVisibility(View.GONE);
        }


        );*/
       /* ImageView imageView = (ImageView)view.findViewById(
        Drawable image = eItem.getImage();
        if (image != null){
            imageView.setBackgroundDrawable(image);
            imageView.setVisibility(View.VISIBLE);
        } else
            imageView.setVisibility(View.GONE);*/

        int offsetY = -20;
        Drawable marker = eItem.getMarker(OverlayItem.ITEM_STATE_FOCUSED_MASK);
        if (marker != null)
            offsetY = -marker.getIntrinsicHeight()*3/4;
        mBubble.open(position, 0, offsetY);
        mapView.getController().animateTo(position);
    }

    @Override protected boolean onSingleTapUpHelper(final int index, final Item item,
                                                    final MapView mapView) {
        showBubbleOnItem(index, mapView);
        return true;
    }

    /** @return the item currenty showing the bubble, or null if none.  */
    public OverlayItem getBubbledItem(){
        //TODO: if user taps the bubble to close it, mItemWithBubble is not set
        return mItemWithBubble;
    }

    @Override public boolean removeItem(Item item){
        boolean result = super.removeItem(item);
        if (mItemWithBubble == item){
            mBubble.close();
            mItemWithBubble = null;
        }
        return result;
    }

    @Override public void removeAllItems(){
        super.removeAllItems();
        mBubble.close();
        mItemWithBubble = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView)
    {

        if (event.getAction() == 0) {
            GeoPoint geopoint = (GeoPoint) mapView.getProjection().fromPixels(
                    (int) event.getX(),
                    (int) event.getY());
            // latitude
            double lat = geopoint.getLatitudeE6() / 1E6;
            // longitude
            double lon = geopoint.getLongitudeE6() / 1E6;
        }
        return false;
    }
}