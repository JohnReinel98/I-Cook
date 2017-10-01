package com.icook.dev.i_cook.PaksiwRecipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icook.dev.i_cook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class PaksiwFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TabLayout pinakbetTabLayout;
    private ViewPager pinakbetViewPager;

    //private List<ListBurger> listBurgers;

    public PaksiwFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pinakbet_fragment,container,false);

        pinakbetViewPager = (ViewPager) rootView.findViewById(R.id.pinakbetviewpager);
        setupViewPager(pinakbetViewPager);

        pinakbetTabLayout = (TabLayout) rootView.findViewById(R.id.pinakbettabs);
        pinakbetTabLayout.setupWithViewPager(pinakbetViewPager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        PaksiwFragment.ViewPagerAdapter adapter = new PaksiwFragment.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new PaksiwIngredients(), "Ingredients");
        adapter.addFragment(new PaksiwProcedures(), "Procedures");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Pinakbet");
    }
}
