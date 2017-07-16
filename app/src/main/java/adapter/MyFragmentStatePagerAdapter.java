package adapter;

/**
 * Created by shuiz on 2017/7/11.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.VPFragment1;
import fragment.VPFragment2;
import fragment.VPFragment3;
import fragment.VPFragmentmore;



public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitle;

    public MyFragmentStatePagerAdapter(FragmentManager fm, String[] tabTitle) {
        super(fm);
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VPFragment1();
            case 1:
                return new VPFragment2();
            case 2:
                return new VPFragment3();
            case 3:
                return new VPFragmentmore();
            case 4:
                return new VPFragmentmore();
            case 5:
                return new VPFragmentmore();
            case 6:
                return new VPFragmentmore();
            case 7:
                return new VPFragmentmore();
            case 8:
                return new VPFragmentmore();
            case 9:
                return new VPFragmentmore();



        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
}