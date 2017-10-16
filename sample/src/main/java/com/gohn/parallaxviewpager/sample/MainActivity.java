package com.gohn.parallaxviewpager.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gohn.parallaxviewpager.ParallaxViewPager;

/**
 * Created by gohn on 2017. 10. 16..
 */

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParallaxViewPager pager1 = (ParallaxViewPager) findViewById(R.id.pager1);
        ParallaxViewPager pager2 = (ParallaxViewPager) findViewById(R.id.pager2);
        ParallaxViewPager pager3 = (ParallaxViewPager) findViewById(R.id.pager3);

        pager1.addMovementToView(R.id.title, 0.0f);
        pager1.addMovementToView(R.id.text, 0.1f);

        pager2.addMovementToView(R.id.title, 0.0f);
        pager2.addMovementToView(R.id.image, 0.1f);

        pager3.addMovementToView(R.id.title, 0.0f);
        pager3.addMovementToView(R.id.text, 0.1f);
        pager3.addMovementToView(R.id.image, 0.1f);

        pager1.setAdapter(new SampleAdapter(getLayoutInflater(), "Only Text"));
        pager2.setAdapter(new SampleAdapter(getLayoutInflater(), "Only Image"));
        pager3.setAdapter(new SampleAdapter(getLayoutInflater(), "Text and Image"));
    }
}
