package com.gohn.parallaxviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by gohn on 2017. 10. 16..
 */

public class ParallaxViewPager extends ViewPager {
    ParallaxPagerTransformer transformer;

    public ParallaxViewPager(Context context) {
        super(context);
        init();
    }

    public ParallaxViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        transformer = new ParallaxPagerTransformer();

        this.setPageTransformer(false, transformer);
    }

    public void addMovementToView(int resourceId, float speed) {
        transformer.addTransformSpeed(resourceId, speed);
    }
}
