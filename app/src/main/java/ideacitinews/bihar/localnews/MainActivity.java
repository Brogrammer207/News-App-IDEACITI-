package ideacitinews.bihar.localnews;


import android.os.Bundle;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;



import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.annotations.Nullable;
import com.sagarkoli.chetanbottomnavigation.chetanBottomNavigation;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import ideacitinews.bihar.localnews.Fragment.AboutUsFragment;
import ideacitinews.bihar.localnews.Fragment.ContactUsFragment;
import ideacitinews.bihar.localnews.Fragment.CountryFragment;
import ideacitinews.bihar.localnews.Fragment.CricketFragment;
import ideacitinews.bihar.localnews.Fragment.EntertainmentFragment;
import ideacitinews.bihar.localnews.Fragment.PoliticsFragment;
import ideacitinews.bihar.localnews.Fragment.PrivacyPolicyFragment;
import ideacitinews.bihar.localnews.Fragment.WorldFragment;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    chetanBottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    DrawerLayout drawer;
    TabLayout tabLayout;
    ViewPager viewPager2;
    Toolbar toolbar;
    ToggleButton toggleButton;
    NavigationView navigationView;
    TextView textView_createaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,firstFragment);
        fragmentTransaction.commit();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        this.overridePendingTransition(R.anim.lefttorightanimation, R.anim.righttoleftanimation);
        bottomNavigation = findViewById(R.id.bottomnavigationview);

        tabLayout = findViewById(R.id.tablayout);
        //   viewPager2 = (ViewPager) findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("होम"));
        tabLayout.addTab(tabLayout.newTab().setText("देश"));
        tabLayout.addTab(tabLayout.newTab().setText("दुनिया"));
        tabLayout.addTab(tabLayout.newTab().setText("क्रिकेट"));
        tabLayout.addTab(tabLayout.newTab().setText("पॉलिटिक्स"));
        tabLayout.addTab(tabLayout.newTab().setText("एंटरटेनमेंट"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;

                 switch (tab.getPosition())
                 {
                     case 0:
                         fragment = new FirstFragment();

                         break;
                     case 1:
                         fragment = new CountryFragment();

                         break;
                     case 2:
                         fragment = new WorldFragment();

                         break;
                     case 3:
                         fragment = new CricketFragment();

                         break;
                     case 4:
                         fragment = new PoliticsFragment();

                         break;
                     case 5:
                         fragment = new EntertainmentFragment();

                         break;
                  

                 }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Fragment fragment = null;

                switch (tab.getPosition())
                {
                    case 0:
                        fragment = new FirstFragment();

                        break;
                    case 1:
                        fragment = new CountryFragment();

                        break;
                    case 2:
                        fragment = new WorldFragment();

                        break;
                    case 3:
                        fragment = new CricketFragment();

                        break;
                    case 4:
                        fragment = new PoliticsFragment();

                        break;
                    case 5:
                        fragment = new EntertainmentFragment();

                        break;


                }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });

//       MyAdapter adapter = new MyAdapter(MainActivity.this,getSupportFragmentManager(),tabLayout.getTabCount());
//       viewPager2.setAdapter(adapter);
//       viewPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//           @Override
//           public void onTabSelected(TabLayout.Tab tab) {
//
//           }
//
//           @Override
//           public void onTabUnselected(TabLayout.Tab tab) {
//
//           }
//
//           @Override
//           public void onTabReselected(TabLayout.Tab tab) {
//
//           }
//       });
        bottomNavigation.add(new chetanBottomNavigation.Model(1, R.drawable.ic_homeicon));
        bottomNavigation.add(new chetanBottomNavigation.Model(2, R.drawable.ic_videoicon));
        bottomNavigation.add(new chetanBottomNavigation.Model(3, R.drawable.ic_newsepaper));

        bottomNavigation.setOnClickMenuListener(new chetanBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(chetanBottomNavigation.Model item) {

                int id = item.getId();
                if (id == 1) {
                    FirstFragment firstFragment = new FirstFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,firstFragment);
                    fragmentTransaction.commit();

                }

                if (id == 2) {
                    SecondFragment secondFragment = new SecondFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,secondFragment);
                    fragmentTransaction.commit();

                }

                if (id == 3) {
                    ThirdFragment thirdFragment = new ThirdFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,thirdFragment);
                    fragmentTransaction.commit();

                }


            }
        });

        bottomNavigation.setOnShowListener(new chetanBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(chetanBottomNavigation.Model item) {

                String name;
                switch (item.getId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Manish", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.video:
                        name = "EXPLORE";
                        break;
                    case R.id.live:
                        name = "MESSAGE";
                        break;


                    default:
                        name = "";
                }
            }
        });

        bottomNavigation.setOnReselectListener(new chetanBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(chetanBottomNavigation.Model item) {
                int id = item.getId();
                if (id == 1) {
                    FirstFragment firstFragment = new FirstFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,firstFragment);
                    fragmentTransaction.commit();

                }

                if (id == 2) {
                    SecondFragment secondFragment = new SecondFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,secondFragment);
                    fragmentTransaction.commit();

                }

                if (id == 3) {
                    ThirdFragment thirdFragment = new ThirdFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container,thirdFragment);
                    fragmentTransaction.commit();

                }
            }
        });

        bottomNavigation.setCount(2, "10");
        bottomNavigation.show(1, true);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_country, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged( NavController navController,  NavDestination navDestination, @Nullable Bundle bundle) {
                if (navDestination.getId() == R.id.nav_home){
                    toolbar.setNavigationIcon(R.drawable.ic_drawericon);
                    toolbar.setTitle("IDEACITINEWS");
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_country)
                {
                    Fragment fragment = null;
                    fragment = new CountryFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_world)
                {
                    Fragment fragment = null;
                    fragment = new WorldFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_cricket)
                {
                    Fragment fragment = null;
                    fragment = new CricketFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_politics)
                {
                    Fragment fragment = null;
                    fragment = new PoliticsFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_entertriment)
                {
                    Fragment fragment = null;
                    fragment = new EntertainmentFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_aboutus)
                {
                    Fragment fragment = null;
                    fragment = new AboutUsFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_contactus)
                {
                    Fragment fragment = null;
                    fragment = new ContactUsFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }
                if(id == R.id.nav_privcypolicy)
                {
                    Fragment fragment = null;
                    fragment = new PrivacyPolicyFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    drawer.close();
                }

                return true;
            }
        });

    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void replace(Fragment fragment, String s) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.addToBackStack(s);
        transaction.commit();
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }


}