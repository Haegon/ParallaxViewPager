package com.gohn.parallaxviewpager.sample;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_feedback:
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"gohn0929@gmail.com"});
                iEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(iEmail, "Select Email Application"));
                break;
            case R.id.action_instagram:
                Uri uri = Uri.parse("http://instagram.com/_u/gohn__");
                Intent iInstagram = new Intent(Intent.ACTION_VIEW, uri);

                iInstagram.setPackage("com.instagram.android");
                try {
                    startActivity(iInstagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/gohn__")));
                }
                break;
            case R.id.action_share:
                Intent iShare = new Intent(android.content.Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getPackageName());
                startActivity(Intent.createChooser(iShare, "Select Application for Sharing"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
