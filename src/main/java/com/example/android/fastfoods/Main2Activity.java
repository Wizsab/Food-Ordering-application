 package com.example.android.fastfoods;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

 public class Main2Activity extends AppCompatActivity  implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Continental"));
        tabLayout.addTab(tabLayout.newTab().setText("Local"));
        tabLayout.addTab(tabLayout.newTab().setText("Desert"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
     @Override
     public boolean onCreateOptionsMenu(Menu menu){
         getMenuInflater().inflate(R.menu.menu_items,menu);
         return true;
     }
     @Override
     public boolean onOptionsItemSelected(MenuItem item){
         switch (item.getItemId()){
             case R.id.item1:
                 Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                 startActivityForResult(intent, 0);
                 break;
             case R.id.item2:
                 Intent intent1 = new Intent(getBaseContext(), Abouttheapp.class);
                 startActivityForResult(intent1, 0);
                 break;
             case R.id.item3:
                 Intent intent2 = new Intent(getBaseContext(), Aboutus.class);
                 startActivityForResult(intent2, 0);
                 break;
             default:
                 return super.onOptionsItemSelected(item);
         }
         return true;
     }
    public void setOrder(View v){
        switch (v.getId()) {
            case R.id.wrice:
                Intent intent = new Intent(getBaseContext(), WhiteRice.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.jrice:
                Intent intent1 = new Intent(getBaseContext(), JollofRice.class);
                startActivityForResult(intent1, 0);
                break;
            case R.id.frice:
                Intent intent2 = new Intent(getBaseContext(), FriedRice.class);
                startActivityForResult(intent2, 0);
                break;
            case R.id.beans:
                Intent intent3 = new Intent(getBaseContext(), Beans.class);
                startActivityForResult(intent3, 0);
                break;
            case R.id.moinmoin:
                Intent intent4 = new Intent(getBaseContext(), Moinmoin.class);
                startActivityForResult(intent4, 0);
                break;
            case R.id.porr:
                Intent intent5 = new Intent(getBaseContext(), Porridge.class);
                startActivityForResult(intent5, 0);
                break;
            case R.id.pYam:
                Intent intent6 = new Intent(getBaseContext(), PoundedYam.class);
                startActivityForResult(intent6, 0);
                break;
            case R.id.amaEfo:
                Intent intent7 = new Intent(getBaseContext(), AmalaEfo.class);
                startActivityForResult(intent7, 0);
                break;
            case R.id.ebaEfo:
                Intent intent8 = new Intent(getBaseContext(), EbaEfo.class);
                startActivityForResult(intent8, 0);
                break;
            case R.id.ebaEgu:
                Intent intent9 = new Intent(getBaseContext(), EbaEgusi.class);
                startActivityForResult(intent9, 0);
                break;
            case R.id.amaewe:
                Intent intent10 = new Intent(getBaseContext(), AmalaEwedu.class);
                startActivityForResult(intent10, 0);
                break;
            case R.id.amagbe:
                Intent intent11 = new Intent(getBaseContext(), AmalaGbegiri.class);
                startActivityForResult(intent11, 0);
                break;
            case R.id.wheefo:
                Intent intent12 = new Intent(getBaseContext(), Wheat.class);
                startActivityForResult(intent12, 0);
                break;
            case R.id.meatPie:
                Intent intent13 = new Intent(getBaseContext(), MeatPie.class);
                startActivityForResult(intent13, 0);
                break;
            case R.id.scotch:
                Intent intent14 = new Intent(getBaseContext(), Scotch.class);
                startActivityForResult(intent14, 0);
                break;
            case R.id.plan:
                Intent intent15 = new Intent(getBaseContext(), Plantain.class);
                startActivityForResult(intent15, 0);
                break;
            case R.id.beans1:
                Intent intent16 = new Intent(getBaseContext(), Beans1.class);
                startActivityForResult(intent16, 0);
                break;
            case R.id.moinmoin1:
                Intent intent17 = new Intent(getBaseContext(), Moinmoin1.class);
                startActivityForResult(intent17, 0);
                break;
        }
    }
}
