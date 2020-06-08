package com.example.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class OnBoardPagerAdapter extends PagerAdapter {
    private Context mContext;
    ArrayList<OnBoardModel>screenItems = new ArrayList<>();

    public OnBoardPagerAdapter(Context mContext, ArrayList<OnBoardModel> screenItems) {
        this.mContext = mContext;
        this.screenItems = screenItems;
    }

    @Override
    public int getCount() {
        return screenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_items,container,false);

        //initializing the screen items
        OnBoardModel items = screenItems.get(position);

        //view image
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
        imageView.setImageResource(items.getImageView());

        TextView header = (TextView)v.findViewById(R.id.heading);
        header.setText(items.getHeader());

        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(items.getDescription());

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
