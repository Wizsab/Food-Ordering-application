package com.example.android.fastfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String info = "\n\t\tThis application is built by SAB group which is a software company which builds Android" +
                " Application for companies and individual." +
                "\n\t\tIf you want a design for your company, you can contact us at sadigbo@gmail.com";

        TextView display = (TextView)findViewById(R.id.info);
        display.setText(info);
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
}
