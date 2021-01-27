package com.mahmudulmaruf.cgpaassistant;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentlist = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    TabAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        return (Fragment) mFragmentlist.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentlist.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentlist.size();
    }
}
