package com.example.administrator.bar;

/**
 * Created by Administrator on 2017/1/6 006.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//使用textView和fragment来做导航栏
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    TabLayout tabLayout; public static int tabIndex;
    //UI Object
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    //Fragment Object
    private Fragment_btm_nvg_tv_context fg1, fg2, fg4;
    private Fragment3 fg3;
    private FragmentManager fManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(null);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setTitle("导航栏例子");
        fManager = getSupportFragmentManager();

        bindViews();//about navigationBar.

        viewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        MainActivity.tabIndex = position;
                    }
                });//实时监测viewPager中的fragment的变化，在navigationBar变化后回来仍可以在那个特定的fragment。

        //（模拟一次点击，即进去后自动选择第一项navigation,not viewPager）
       txt_channel.performClick();//the method is 自带的
    }


    /**
     * UI组件初始化与事件绑定
     */

    private void bindViews() {
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }

    /**
     * 重置所有文本的选中状态
     */

    private void setSelected() {//每次点击时使其他的texView置为未选，然后再在后续方法中指定要选的textView
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }

    /**
     * 隐藏所有Fragment
     */

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }

    @Override
    public void onClick(View v) {//每次的点击都从这里开始
        viewPager.setAdapter(null);

        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.txt_channel:
                setSelected();
                txt_channel.setSelected(true);
                if (fg1 == null) {
                    viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
                    viewPager.setCurrentItem(tabIndex);//前面监测后，设置指定的fragment

                } else {
                    fTransaction.show(fg1);//actually not used ,because fragments are always wiped every time it's clicked.
                }
                break;
            case R.id.txt_message:
                setSelected();
                txt_message.setSelected(true);
                if (fg2 == null) {
                    fg2 = new Fragment_btm_nvg_tv_context("第二个Fragment");//在人家的地盘演绎自己的特征
                    //viewPager.setAdapter(null);
                    fTransaction.add(R.id.ly_content, fg2);//终于，与别人家结合。
                } else {
                    fTransaction.show(fg2);
                    //viewPager.setAdapter(null);

                }
                break;
            case R.id.txt_better:
                setSelected();
                txt_better.setSelected(true);
                if (fg3 == null) {
                   // viewPager.setAdapter(null);
                    fg3 = new Fragment3();//自定义fragment
                    fTransaction.add(R.id.ly_content, fg3);////关键：链接了fragment类与此activity中的fragment
                } else {
                    fTransaction.show(fg3);
                    //viewPager.setAdapter(null);

                }
                break;
            case R.id.txt_setting:
                setSelected();
                txt_setting.setSelected(true);
                if (fg4 == null) {
                    //viewPager.setAdapter(null);
                    fg4 = new Fragment_btm_nvg_tv_context("第四个Fragment");//若要删除这行则下面那行也要删，否则会出错（执行下一行代码时找不到指定资源）
                    fTransaction.add(R.id.ly_content,fg4);
                } else {
                    fTransaction.show(fg4);
                    //viewPager.setAdapter(null);
                }
                break;
        }
        fTransaction.commit();
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private String fragments[]={"fragment1","fragment2","fragment3","fragment4"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext ){
            super(supportFragmentManager);
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new Fragment01();
                case 1:
                    return new Fragment02();
                case 2:
                    return new Fragment03();
                case 3:
                    return new Fragment04();
                default:
                    return null;

            }
        }


        @Override
        public int getCount(){
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];//the title is the string array's element.
        }
    }
}
