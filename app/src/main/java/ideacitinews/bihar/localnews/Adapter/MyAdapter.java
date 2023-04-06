package ideacitinews.bihar.localnews.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ideacitinews.bihar.localnews.FirstFragment;
import ideacitinews.bihar.localnews.SecondFragment;
import ideacitinews.bihar.localnews.ThirdFragment;

public class MyAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstFragment footballFragment = new FirstFragment();
                return footballFragment;
            case 1:
                SecondFragment cricketFragment = new SecondFragment();
                return cricketFragment;
            case 2:
                ThirdFragment nbaFragment = new ThirdFragment();
                return nbaFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
