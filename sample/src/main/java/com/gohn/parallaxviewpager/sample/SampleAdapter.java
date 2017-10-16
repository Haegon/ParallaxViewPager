package com.gohn.parallaxviewpager.sample;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gohn on 2017. 10. 16..
 */

public class SampleAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    int[] colors = new int[]{Color.WHITE, Color.BLACK, Color.GREEN, Color.BLUE, Color.RED};
    int[] images = new int[]{R.drawable.ty01, R.drawable.ty02, R.drawable.ty03, R.drawable.ty04, R.drawable.ty05};
    String[] texts = new String[]{
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "也称乱数假文或者哑元文本， 是印刷及排版领域所常用的虚拟文字",
            "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur",
            " это текст-рыба, часто используемый в печати и вэб-дизайне",
            "տպագրության և տպագրական արդյունաբերության համար նախատեսված մոդելային տեքստ"
    };

    public SampleAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v = inflater.inflate(R.layout.layout_sample, null);

        ImageView image = v.findViewById(R.id.image);
        TextView title = v.findViewById(R.id.title);
        TextView text = v.findViewById(R.id.text);

        image.setImageResource(images[position % 5]);
        text.setText(texts[position % 5]);
        title.setTextColor(colors[position % 5]);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}