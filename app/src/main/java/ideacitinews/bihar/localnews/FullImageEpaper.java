package ideacitinews.bihar.localnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import ideacitinews.bihar.localnews.Adapter.ViewPagerAdapter;

public class FullImageEpaper extends AppCompatActivity {

    String Image1,Image2,Image3,Image4,Image5,Image6,Image7;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_epaper);

        Intent intent = getIntent();
        Image1 = intent.getStringExtra("Image1");
        Image2 = intent.getStringExtra("Image2");
        Image3 = intent.getStringExtra("Image3");
        Image4 = intent.getStringExtra("Image4");
        Image5 = intent.getStringExtra("Image5");
        Image6 = intent.getStringExtra("Image6");
        Image7 = intent.getStringExtra("Image7");


        String[] images = {Image1,Image2,Image3,Image4,Image5,Image6,Image7};
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAdapter(FullImageEpaper.this, images);
        mViewPager.setAdapter(mViewPagerAdapter);

        dotscount = mViewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}