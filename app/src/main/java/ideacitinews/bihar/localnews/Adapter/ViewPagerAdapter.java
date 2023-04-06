package ideacitinews.bihar.localnews.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ablanco.zoomy.TapListener;
import com.ablanco.zoomy.Zoomy;
import com.bumptech.glide.Glide;

import java.util.Objects;

import ideacitinews.bihar.localnews.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] images;
    LayoutInflater mLayoutInflater;


    public ViewPagerAdapter(Context context, String[] images) {
        this.context = context;
        this.images = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
        Glide.with(context)
                .load(images[position])
                .into(imageView);
        Objects.requireNonNull(container).addView(itemView);

        Zoomy.Builder builder = new Zoomy.Builder((Activity) context).target(imageView)
                .animateZooming(true)
                .enableImmersiveMode(true)
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builder.register();

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}