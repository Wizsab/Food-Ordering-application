package com.example.android.fastfoods;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FriedRice extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fried_rice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    public void increment (View view ) {
        if (quantity == 10){
            Toast.makeText(this, "You cannot have more than 10 plates", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity );

    }

    public void decrement (View view ) {
        if (quantity == 1){
            Toast.makeText(this, "You cannot have less than 1 plate", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity );

    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder (View view ) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        EditText phoneNo = (EditText)findViewById(R.id.phone);
        String phone = phoneNo.getText().toString();

        EditText address = (EditText)findViewById(R.id.address);
        String address1 = address.getText().toString();

        CheckBox beef = findViewById(R.id.beef);
        boolean hasbeef = beef.isChecked();

        CheckBox gMeat = findViewById(R.id.gMeat);
        boolean hasgMeat = gMeat.isChecked();

        CheckBox fish = findViewById(R.id.fish);
        boolean hasfish = fish.isChecked();

        CheckBox pork = findViewById(R.id.pork);
        boolean haspork = pork.isChecked();

        int price = calculatePrice(hasbeef,hasgMeat,hasfish,haspork);
        String priceMessage = createOrderSummary(price, hasbeef, hasgMeat, hasfish, haspork, name, phone,address1);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Food order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    private int calculatePrice(boolean addbeef,boolean addgMeat,boolean addfish,boolean addpork){
        int basePrice = 1000;
        if (addbeef){
            basePrice = basePrice + 200;
        }
        if (addgMeat){
            basePrice = basePrice + 350;
        }
        if (addfish){
            basePrice = basePrice + 300;
        }
        if (addpork){
            basePrice = basePrice + 250;
        }
        return quantity * basePrice;
    }

    private void display ( int number ) {
        TextView quantityTextView =(TextView)findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText( "" + number);
    }

    private String createOrderSummary(int price, boolean addbeef,boolean addgMeat,boolean addfish,boolean addpork,String name, String phone, String address1){
        String priceMessage = "Name: " + name;
        priceMessage += "\nPhone Number: " + phone;
        priceMessage += "\nAddress: " + address1;
        priceMessage += "\nFood: Fried Rice";
        priceMessage += "\nAdd Beef? " + addbeef;
        priceMessage += "\nAdd Goat Meat? " + addgMeat;
        priceMessage += "\nAdd Fish? " + addfish;
        priceMessage += "\nAdd Pork? " + addpork;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal with Delivery: \u20a6" + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }
}
