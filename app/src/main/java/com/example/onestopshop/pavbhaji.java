package com.example.onestopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class pavbhaji extends AppCompatActivity {
    int numberOfPavbhaji=0;
    int basePrice = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavbhaji);
        Intent intent=getIntent();
    }
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox extraPavCheckBox = (CheckBox) findViewById(R.id.pav);
        boolean isExtraPav = extraPavCheckBox.isChecked();
        if (numberOfPavbhaji == 0) {
            Toast.makeText(this, "You should order atleast one pavbhaji", Toast.LENGTH_SHORT).show();}
        else{
        int price = calculatePrice(isExtraPav);
        String priceMessage = createOrderSummary(price,isExtraPav , name);
        displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pav Bhaji order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);}


        }
    }
    /**
     * Calculates the price of the order.

     */
    private int calculatePrice(boolean addExtraPav) {

        if(addExtraPav){
            basePrice= basePrice+10;
        }
        int cost = numberOfPavbhaji * basePrice;
        return cost;
    }
    private String createOrderSummary(int price,boolean isExtraPav,String name){
        String priceMessage="Name: " + name + "\nAdd Extra Pav? " + isExtraPav  +"\nQuantity: " + numberOfPavbhaji + "\nThat would be ₹" + price + " please" + "\nThank You!";
        displayMessage(priceMessage);
        return priceMessage;
    }
    public void increment(View view) {
        if(numberOfPavbhaji>=100){
            Toast.makeText(this,"You cannot have more than 100 pavbhaji",Toast.LENGTH_SHORT).show();

            return;
        }
        numberOfPavbhaji = numberOfPavbhaji + 1 ;
        displayQuantity(numberOfPavbhaji);
    }
    public void decrement(View view) {
        if(numberOfPavbhaji<1){
            Toast.makeText(this,"You cannot have less than 1 pavbhaji",Toast.LENGTH_SHORT).show();
            return;       }
        numberOfPavbhaji = numberOfPavbhaji - 1 ;
        displayQuantity(numberOfPavbhaji);}

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        TextView priceTextView= (TextView)findViewById(R.id.price_text_view1);
        priceTextView.setText("₹"+number*basePrice);
    }

    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
