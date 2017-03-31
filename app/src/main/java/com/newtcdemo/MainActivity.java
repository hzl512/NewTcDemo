package com.newtcdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.newtcdemo.eventbus.model.MessageEvent;
import com.newtcdemo.fragments.TestFragment0;
import com.newtcdemo.fragments.TestFragment1;
import com.newtcdemo.fragments.TestFragment2;
import com.newtcdemo.fragments.TestFragment3;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * index 主页
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private List<Fragment> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//内容页
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//标题与菜单
        setSupportActionBar(toolbar);//添加支持

        mList.add(new TestFragment0());
        mList.add(new TestFragment1());
        mList.add(new TestFragment2());
        mList.add(new TestFragment3());

        setTitle(R.string.index_text0);
        selectItem(0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);//浮点式操作按钮
//        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);//左侧抽屉式菜单
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//左侧抽屉菜单子项
        navigationView.setNavigationItemSelectedListener(this);


    }

    //初始化布局
    private void initView() {
//        startService(new Intent(this, MyIntentService.class));
    }

    //左侧抽屉式菜单响应操作
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(this, R.string.index_text0, Toast.LENGTH_SHORT).show();
            setTitle(R.string.index_text0);
            selectItem(0);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, R.string.index_text1, Toast.LENGTH_SHORT).show();
            setTitle(R.string.index_text1);
            selectItem(1);
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, R.string.index_text2, Toast.LENGTH_SHORT).show();
            setTitle(R.string.index_text2);
            selectItem(2);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, R.string.index_text3, Toast.LENGTH_SHORT).show();
            setTitle(R.string.index_text3);
            selectItem(3);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        // 根据位置更新内容页
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame, mList.get(position));
        ft.commit();
        // update selected item title, then close the drawer
//        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Subscribe()
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

}
