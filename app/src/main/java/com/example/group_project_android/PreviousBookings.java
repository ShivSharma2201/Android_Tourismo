package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class PreviousBookings extends AppCompatActivity {
    ArrayList<UserAct> bokingList;
    ListView listViewb;
    ArrayList<ActivityDetails> activityDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_bookings);
        ArrayList<String> activityName = new ArrayList<>();
        ArrayList<Float> price= new ArrayList<>();
        ArrayList<String> imageName = new ArrayList<>();

        Intent currentIntent = this.getIntent();
        UserDetails ucf = (UserDetails) currentIntent.getSerializableExtra("User_data");
        bokingList= ActivitiesDB.getInstance().getBooklist();
        activityDetails = ActivitiesDB.getInstance().getActivityList();

        for(int i=0;i<bokingList.size();i++){
            if(bokingList.get(i).us.getId()==ucf.getId()){
                activityName.add(bokingList.get(i).act.getNameOfActivity());
                price.add(bokingList.get(i).act.getPrice());
                imageName.add(bokingList.get(i).act.getImageName());}
        }
        MyListAdapter adapter = new MyListAdapter(this,activityName,imageName,price);
        listViewb =(ListView) findViewById(R.id.previousList);
        listViewb.setAdapter(adapter);
        listViewb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent i2 = new Intent(PreviousBookings.this,BookingReceipt.class);
                i2.putExtra("activity_data", (Serializable) activityDetails.get(i));
                i2.putExtra("User_data",(Serializable)ucf );
                String x= Integer.toString(++i);
                i2.putExtra("ticket_number","# "+x );

                startActivity(i2);

            }
        });
        listViewb.invalidateViews();
    }
}