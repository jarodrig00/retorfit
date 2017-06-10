package com.jard.testretrofit;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jard.testretrofit.adapter.FotoAdapter;
import com.jard.testretrofit.adapter.PageAdapter;
import com.jard.testretrofit.fragment.RecyclerViewFotos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tlMain;
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlMain = (TabLayout) findViewById(R.id.tlMain);
        vpMain = (ViewPager) findViewById(R.id.vpMain);
        setUpViewPager();
        //agregarFragmets();
    }

    public void setUpViewPager(){
        vpMain.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragmets()));
        tlMain.setupWithViewPager(vpMain);
        //Podemos poner un icon
    }

    private ArrayList<Fragment> agregarFragmets(){
        ArrayList <Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFotos());

        return fragments;
    }
}
