package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private OnBoardPagerAdapter mAdapter;

    ArrayList<OnBoardModel>items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make the activity to be full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //check whether the app was initially installed or not
        if(restorePrefData()){
            Intent MainActivity = new Intent(getApplicationContext(), com.example.viewpager2.MainActivity.class);
            startActivity(MainActivity);
            finish();
        }
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);



        loadData();
        mAdapter = new OnBoardPagerAdapter(this,items);
        viewPager = (ViewPager)findViewById(R.id.onBoardViewPager);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void loadData(){
        int[]ImageView = {R.drawable.primary_dark,R.drawable.color_accent,R.drawable.purple_circle};
        int[]Header = {R.string.first, R.string.second, R.string.bye};
        int[]description = {R.string.one,R.string.two,R.string.three};

        for (int i = 0;i<ImageView.length;i++){
            OnBoardModel Items = new OnBoardModel();
            Items.setHeader(Header[i]);
            Items.setDescription(description[i]);
            Items.setImageView(ImageView[i]);

            items.add(Items);

        }


    }

    private Boolean restorePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData(){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }
}
