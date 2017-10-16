package com.gohn.parallaxviewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

class ParallaxPagerTransformer implements ViewPager.PageTransformer {

    private Map<Integer, Float> speedMap;

    public ParallaxPagerTransformer() {
        speedMap = new HashMap<>();
    }

    public void addTransformSpeed(int resourceId, float speed) {
        if (speedMap != null) {
            speedMap.put(resourceId, speed);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void transformPage(View view, float position) {
        if (view == null) return;

        for (Integer resourceId : speedMap.keySet()) {
            View parallaxView = view.findViewById(resourceId);

            if (parallaxView != null && Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                if (position > -1 && position < 1) {
                    float width = parallaxView.getWidth();
                    float speed = (1.0f - speedMap.get(resourceId));
                    if (speed < 0 || speed > 1) return;
                    parallaxView.setTranslationX(-(position * width * speed));
                }
            }
        }
    }
}