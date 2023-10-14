//package com.test.samplecollection;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import androidx.viewpager2.widget.ViewPager2;
//
//public class CustomViewPagerContainer extends ViewPager2 {
//
//    private ViewPager2 childViewPager;
//    private float startX;
//    private float startY;
//    private boolean isVerticalScroll;
//
//    public CustomViewPagerContainer(Context context) {
//        super(context);
//    }
//
//    public CustomViewPagerContainer(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public void setChildViewPager(ViewPager2 viewPager) {
//        this.childViewPager = viewPager;
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                startX = event.getX();
//                startY = event.getY();
//                isVerticalScroll = false;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float endX = event.getX();
//                float endY = event.getY();
//                float deltaX = Math.abs(endX - startX);
//                float deltaY = Math.abs(endY - startY);
//                if (deltaY > deltaX) {
//                    isVerticalScroll = true;
//                }
//                break;
//        }
//
//        if (childViewPager != null) {
//            if (isVerticalScroll) {
//                // Consume touch events for vertical scrolls in the child ViewPager
//                return childViewPager.onInterceptTouchEvent(event);
//            } else {
//                // Allow touch events to be passed to the parent ViewPager2 for horizontal scrolls
//                return super.onInterceptTouchEvent(event);
//            }
//        }
//
//        return super.onInterceptTouchEvent(event);
//    }
//}
