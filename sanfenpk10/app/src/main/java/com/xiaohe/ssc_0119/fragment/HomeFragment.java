package com.xiaohe.ssc_0119.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.MyTableView;
import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/8/11.
 */
public class HomeFragment extends Fragment{
    private String[] names = new String[]{"开奖大厅","专家预测","模拟投注"};
    private View view;
    private LinearLayout linTable;
    private ViewPager vp;

    private String url;
    private Fragment[] fragments = new Fragment[3];
    private MyTableView myTableView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,null);
        initView();
        initData();
        setOnClick();
        return view;

    }

    private void setOnClick() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                    url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
                    intent.putExtra("url",url);
                    intent.putExtra("title","模拟投注");
                    startActivity(intent);
                    myTableView.setPositonCheck(getActivity(),0);
                    vp.setCurrentItem(0);
                }else {
                    myTableView.setPositonCheck(getContext(),position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        url = "http://m.159cai.com/";
//        url = "hhttp://m.500.com/info/kaijiang/ssq/?0_uc_uctj";
        fragments[0] = new TwoFragment(url);
        url = "http://m.500.com/info/article/28/";
        fragments[1] = new TwoFragment(url);
        url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
        fragments[2] = new TwoFragment(url);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(3);
    }

    private void initView() {
        linTable = (LinearLayout) view.findViewById(R.id.lin_table);
        vp = (ViewPager) view.findViewById(R.id.vp);
        myTableView = new MyTableView(getContext());
        myTableView.setTableViewContent(linTable, names, new MyTableView.OnItemClickListener() {
            @Override
            public void click(TextView tv, int position) {
                if (position == 2){
                    Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                    url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
                    intent.putExtra("url",url);
                    intent.putExtra("title","模拟投注");
                    startActivity(intent);
                    vp.setCurrentItem(0);
                    myTableView.setPositonCheck(getActivity(),0);
                }else {
                    vp.setCurrentItem(position);
                }
            }
        });
    }
}
