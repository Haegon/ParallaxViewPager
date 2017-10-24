package com.gohn.parallaxviewpager.sample;

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

    String title;
    LayoutInflater inflater;
    int[] colors = new int[]{Color.WHITE, Color.BLACK, Color.GREEN, Color.BLUE, Color.RED};
    int[] images = new int[]{R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5};
    String[] texts = new String[]{
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "也称乱数假文或者哑元文本， 是印刷及排版领域所常用的虚拟文字",
            "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur",
            "발휘하기 든 불어 날카로우나 따뜻한 들어 시들어 없으면, 것이다. 인생에 힘차게 희망의 인간은 이것이다.",
            "տպագրության և տպագրական արդյունաբերության համար նախատեսված մոդելային տեքստ"
    };

    public SampleAdapter(LayoutInflater inflater, String title) {
        this.inflater = inflater;
        this.title = title;
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

        ImageView image = (ImageView) v.findViewById(R.id.image);
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView text = (TextView) v.findViewById(R.id.text);

        image.setImageResource(images[position % 5]);
        text.setText(texts[position % 5]);
        title.setText(this.title);
        title.setTextColor(colors[position % 5]);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}