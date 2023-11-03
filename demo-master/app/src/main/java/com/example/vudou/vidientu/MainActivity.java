package com.example.vudou.vidientu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Process;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TabLayout tabs;
    LinearLayout test;
    LinearLayout mainContent;
    DrawerLayout drawerLayout;
    ViewPager viewPager;
    ArrayList<Fragment> listFragment;
    MyPagerAdapter adapter;
    ImageView menu, alarm;
    TextView title;
    FinishReceiver receiver;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContructor();
        createViewPaper();
        createTabLayout();
        createDrawerView();
        setEvent();
//        receiver = new FinishReceiver(new FinishReceiver.OnScreenListener() {
//            @Override
//            public void onScreenOn() {
//            }
//        });
//        registerReceiver(receiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    public void setContructor() {
        mainContent = (LinearLayout) findViewById(R.id.main_content);
        title = (TextView) findViewById(R.id.head_text);
        menu = (ImageView) findViewById(R.id.head_menu) ;
        viewPager = (ViewPager) findViewById(R.id.viewPager_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        tabs = (TabLayout) findViewById(R.id.tabs);
        alarm = (ImageView) findViewById(R.id.head_alarm);


    }


    public void createTabLayout() {
        tabs.setupWithViewPager(viewPager);
        TabLayout.Tab tab1 = tabs.getTabAt(0);
        tab1.setCustomView(customTab(R.drawable.ic_home));

        TabLayout.Tab tab2 = tabs.getTabAt(1);
        tab2.setCustomView(customTab(R.drawable.ic_wallet));

        TabLayout.Tab tab3 = tabs.getTabAt(2);
        tab3.setCustomView(customTab(R.drawable.ic_forma));

    }

    public void createDrawerView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.buy_m_card , R.string.excharge ) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainContent.setTranslationX(slideOffset * drawerView.getWidth());
                drawerLayout.bringChildToFront(drawerView);
                drawerLayout.requestLayout();
                menu.setImageResource(R.drawable.ic_back);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                menu.setImageResource(R.drawable.ic_menu);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }



    public void createViewPaper() {
        listFragment = new ArrayList<>();
        listFragment.add(new HomeFragment());
        listFragment.add(new PayFragment());
        listFragment.add(new TranferFragment());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(adapter);
    }

    public void setEvent() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        menu.setImageResource(R.drawable.ic_menu);
                        title.setText(getResources().getString(R.string.home));
                        menu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                drawerLayout.openDrawer(Gravity.LEFT);
                            }
                        });
                        break;
                    case 1:
                        title.setText(getResources().getString(R.string.payment));
                        menu.setImageResource(R.drawable.ic_back);
                        menu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewPager.setCurrentItem(0);
                            }
                        });
                        break;
                    case 2:
                        title.setText(getResources().getString(R.string.tranfer));
                        menu.setImageResource(R.drawable.ic_back);
                        menu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewPager.setCurrentItem(1);
                            }
                        });
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(getResources().getString(R.string.mess_change_lang));
                builder.setPositiveButton(getResources().getString(R.string.eng), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("en");
//                        alarm.setImageResource(R.drawable.ic_eng);
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.vie), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("vi");
//                        alarm.setImageResource(R.drawable.ic_flag);
                    }
                });
                builder.show();

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private View customTab(int picRes) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.tab_view, null);

        ImageView img = (ImageView) v.findViewById(R.id.img_tab_view);

        img.setImageResource(picRes);

        return v;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
            return true;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    Process.killProcess(Process.myPid());

                }
            });
            builder.setMessage(getResources().getString(R.string.exit_app));
            builder.setIcon(R.drawable.exit);
            builder.show();
            return true;
//            return super.onKeyDown(keyCode, event);
        }
    }

    public void setLanguage(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }



}
