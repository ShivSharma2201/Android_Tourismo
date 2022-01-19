package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingReceipt extends AppCompatActivity {

    TextView receiptActivityName,receiptUserName,receiptCompanyName,receiptPrice,ticHeading;
    Button homePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_receipt);

        Intent currentIntent = this.getIntent();
        ticHeading=(TextView) findViewById(R.id.heading);
        receiptActivityName = (TextView) findViewById(R.id.receiptActivityName);
        receiptUserName = (TextView) findViewById(R.id.receiptUserName);
        receiptCompanyName = (TextView) findViewById(R.id.receiptCompanyName);
        receiptPrice = (TextView) findViewById(R.id.receiptPrice);
        homePage = (Button) findViewById(R.id.homePage);
        UserDetails u = (UserDetails) currentIntent.getSerializableExtra("User_data");
        ActivityDetails a = (ActivityDetails) currentIntent.getSerializableExtra("activity_data");
        String num = (String) currentIntent.getStringExtra("ticket_number");
        if(num==null){
            num="";
        }
        receiptPrice.setText("$"+a.getPrice());
        receiptActivityName.setText(a.getNameOfActivity());
        receiptCompanyName.setText(a.getCompanyName());
        receiptUserName.setText(u.getName());
        ticHeading.setText("RECEIPT "+num);

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingReceipt.this,ActivitiesListActivity.class);
                i.putExtra("User_data",u);
                i.putExtra("activity_data",a);
                startActivity(i);
                finish();
            }
        });

    }
}