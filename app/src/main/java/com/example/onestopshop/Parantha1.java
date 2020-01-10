package com.example.onestopshop;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onestopshop.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order parantha.
 */
public class Parantha1 extends AppCompatActivity {
    int numberOfparantha = 0 ;
    int basePrice = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parantha1);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox pickleCheckBox = (CheckBox) findViewById(R.id.pickle);
        CheckBox chutneyCheckBox = (CheckBox) findViewById(R.id.chutney);
        boolean ispickle = pickleCheckBox.isChecked();
        boolean ischutney = chutneyCheckBox.isChecked();
        if (numberOfparantha == 0) {
            Toast.makeText(this, "You should order atleast one parantha", Toast.LENGTH_SHORT).show();

        } else {
            int price = calculatePrice();
            String priceMessage = createOrderSummary(price, ispickle, ischutney, name);
            displayMessage(priceMessage);
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Aloo parantha order for " + name);
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);

            }
        }
    }
    /**
     * Calculates the price of the order.

     */
    private int calculatePrice() {

        int cost = numberOfparantha * basePrice;
        return cost;
    }
    private String createOrderSummary(int price,boolean ispickle,boolean ischutney,String name){
        String priceMessage="Name: " + name + "\nAdd Pickle? " + ispickle +"\nAdd Chutney? " + ischutney +"\nQuantity: " + numberOfparantha + "\nThat would be ₹" + price + " please" + "\nThank You!";
        displayMessage(priceMessage);
        return priceMessage;
    }
    public void increment(View view) {
        if(numberOfparantha>=100){
            Toast.makeText(this,"You cannot have more than 100 parantha",Toast.LENGTH_SHORT).show();

            return;
        }
        numberOfparantha = numberOfparantha + 1 ;
        displayQuantity(numberOfparantha);
    }
    public void decrement(View view) {
        if(numberOfparantha<1){
            Toast.makeText(this,"You cannot have less than 1 parantha",Toast.LENGTH_SHORT).show();
            return;       }
        numberOfparantha = numberOfparantha - 1 ;
        displayQuantity(numberOfparantha);
    }

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