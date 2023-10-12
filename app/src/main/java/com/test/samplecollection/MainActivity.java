package com.test.samplecollection;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.Model;
import com.test.samplecollection.HomeFragment;
import com.test.samplecollection.MyPagerAdapter;
import com.test.samplecollection.R;
import com.test.samplecollection.SearchFragment;
import com.test.samplecollection.UserFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        bottomNavigation = findViewById(R.id.Navbar);

        setupViewPager();
        setupBottomNavigation();
    }

    private void setupViewPager() {
        // Create your fragments for each tab
        Fragment[] fragments = new Fragment[]{
                new HomeFragment(),
                new SearchFragment(),
                new UserFragment()
        };

        // Set up ViewPager2 with a custom adapter
        viewPager.setAdapter(new MyPagerAdapter(this));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // Update the selected tab in MeowBottomNavigation
                bottomNavigation.show(position, true);
            }
        });
    }

    private void setupBottomNavigation() {
        bottomNavigation.add(new Model(0, R.drawable.ic_search_nav));
        bottomNavigation.add(new Model(1, R.drawable.ic_home_nav));
        bottomNavigation.add(new Model(2, R.drawable.ic_user_nav));

        // Set the initial tab
        viewPager.setCurrentItem(1, false);

        bottomNavigation.setOnClickMenuListener(model -> {
            // Handle tab selection
            viewPager.setCurrentItem(model.getId() , false);
            return null;
        });
    }
}
