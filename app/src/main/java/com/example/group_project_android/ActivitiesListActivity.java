package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivitiesListActivity extends AppCompatActivity {

    private TextView welcomeText;
    ArrayList<ActivityDetails> activityDetails;
    ArrayList<UserAct> favdDetails;

    ListView listView;
    Button logout,favl,receipt;
    private SharedPreferences prefs;
    private static final String SP_NAME = "MY_SP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_list);

        Intent currentIntent = getIntent();
        favdDetails= ActivitiesDB.getInstance().getFavlist();
        activityDetails = ActivitiesDB.getInstance().getActivityList();
        String s;
        welcomeText = (TextView) findViewById(R.id.welcome);
        logout = (Button) findViewById(R.id.Logout);
        receipt = (Button) findViewById(R.id.receipt);
        favl=(Button) findViewById(R.id.favouriteList);

        ArrayList<String> activityName = new ArrayList<>();
        ArrayList<Float> price= new ArrayList<>();
        ArrayList<String> imageName = new ArrayList<>();
        this.prefs = this.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        UserDetails u = (UserDetails) ActivitiesDB.getInstance().getUserList().get(prefs.getInt("userId",0));
        if(u != null){
            s=u.getName();
        }
        else{
            s = prefs.getString("userName","");
        }

        welcomeText.setText("Welcome "+s+"!");
        SharedPreferences.Editor prefEditor = this.prefs.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor.clear();
                prefEditor.commit();
                Intent i = new Intent(ActivitiesListActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        for(int i=0;i<activityDetails.size();i++){
            activityName.add(activityDetails.get(i).getNameOfActivity());
            price.add(activityDetails.get(i).getPrice());
            imageName.add(activityDetails.get(i).getImageName());
        }
        MyListAdapter adapter = new MyListAdapter(this,activityName,imageName,price);
        listView =(ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i2 = new Intent(ActivitiesListActivity.this,MoreActivityDetails.class);
                i2.putExtra("activity_data", (Serializable) activityDetails.get(i));
                i2.putExtra("User_data",(Serializable)u );
                i2.putExtra("A","Add to Favourite");
                String x = Integer.toString(i);
                i2.putExtra("I", x);
                startActivity(i2);
            }
        });
        favl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favv=new Intent(ActivitiesListActivity.this,FavAct.class);
                favv.putExtra("User_data",(Serializable) u );
                startActivity(favv);
            }
        });
        receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(ActivitiesListActivity.this,PreviousBookings.class);
                j.putExtra("User_data",u);
                startActivity(j);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}