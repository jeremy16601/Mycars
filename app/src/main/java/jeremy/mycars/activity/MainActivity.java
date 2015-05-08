package jeremy.mycars.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.GetCallback;
import com.beanu.arad.utils.Log;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jeremy.mycars.R;
import jeremy.mycars.base.App;
import jeremy.mycars.base.MyActivity;
import jeremy.mycars.fragment.LeftMenuFragment;
import jeremy.mycars.util.DoubleClickExitHelper;


public class MainActivity extends MyActivity {

    //按两次返回键退出
    private DoubleClickExitHelper doubleClickExitHelper;
    //抽屉布局类
    private DrawerLayout drawerLayout;
    //主内容容器
    private ViewPager viewPager;
    //栏目标签
    private PagerSlidingTabStrip tabs;
    //页面适配器
//    private ViewPagerAdapter pagerAdapter;
    //左侧菜单
    private LeftMenuFragment leftMenu;
    @InjectView(R.id.toolbar_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        title.setText("首页");

        initActionBarAndDrawer();
//        initLayout();
        //测试添加
//        AVObject ms = new AVObject("cars");
//        ms.put("name", "jeremy");
//        ms.put("conten", "how much ?");
//        ms.put("time", 10);
//        ms.saveInBackground();
    }

    private void initActionBarAndDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View view) {
//                if (!TextUtils.isEmpty(App.getContext().access_token)){
//                    leftMenu.setUserInfo();
//                }
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }
        };
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }

    //获取布局内容
//    private void initLayout() {
//        String[] columnTabs = getResources().getStringArray(R.array.column_tab);
//        ArrayList<TopicListFragment> fragments = new ArrayList<>();
//        for (int i = 0; i < columnTabs.length; i++) {
//            Bundle bundle = new Bundle();
//            bundle.putString(Params.TAB, columnTabs[i]);
//            TopicListFragment fragment = (TopicListFragment) SimpleFactory.createFragment(TopicListFragment.class.getSimpleName(), bundle);
//            fragments.add(i, fragment);
//        }
//        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, getResources().getStringArray(R.array.column_title));
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setOffscreenPageLimit(pagerAdapter.getCount() - 1);
//        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
//        tabs.setViewPager(viewPager);
//        tabs.setTextSize(CommonUtils.sp2px(14));
//        tabs.setTabBackground(android.R.color.transparent);
//        tabs.setOnPageChangeListener(this);
//
//        //左侧菜单
//        leftMenu = new LeftMenuFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.left_menu, leftMenu).commit();
//    }

    //切换抽屉菜单
    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean setupToolBarLeftButton(ImageView leftButton) {
        return false;
    }

//    @OnClick(R.id.btn_show)
//    void setBshow() {
//        AVQuery<AVObject> query = new AVQuery<AVObject>("cars");
//        query.getInBackground("5541f6e2e4b0e2a915843262", new GetCallback<AVObject>() {
//            public void done(AVObject g, AVException e) {
//                if (e == null) {
//                    showContent.setText("数据：" + g.get("name"));
//                    Log.e("获取分数 比分是：" + g.getInt("time"));
//                } else {
//                    Log.e("获取分数 错误: " + e.getMessage());
//                }
//            }
//        });
//    }


}
