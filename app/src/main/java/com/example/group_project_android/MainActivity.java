package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText mEmail,mPassword;
    private Button mLogin;

    ArrayList<UserDetails> userList = new ArrayList<>();


    private SharedPreferences prefs;
    private CheckBox rememberMe;
    private static final String SP_NAME = "MY_SP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = (TextInputEditText) findViewById(R.id.email);
        mPassword = (TextInputEditText) findViewById(R.id.password);
        mLogin = (Button)findViewById(R.id.login);
        rememberMe = (CheckBox)findViewById(R.id.rememberMe);
        userList = ActivitiesDB.getInstance().getUserList();

        this.prefs = this.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);


        if(this.prefs.contains("userName")){
            Intent i1 = new Intent(MainActivity.this,ActivitiesListActivity.class);
            startActivity(i1);
        }

        SharedPreferences.Editor prefEditor = this.prefs.edit();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEmail.getText().toString().equals("") || mPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    for(int i=0;i<userList.size();i++){
                        if(mEmail.getText().toString().equals(userList.get(i).getEmail())){
                            if(mPassword.getText().toString().equals(userList.get(i).getPassword())){
                                //Intent to go to the next page with user details.

                                if(rememberMe.isChecked()){

                                    prefEditor.putString("userName",userList.get(i).getName());
                                    prefEditor.putInt("userId", userList.get(i).getId());
                                    prefEditor.apply();
                                    Intent i1 = new Intent(MainActivity.this,ActivitiesListActivity.class);
                                    i1.putExtra("User_data",userList.get(i));
                                    startActivity(i1);
                                    break;

                                }
                                else{

                                    Intent i1 = new Intent(MainActivity.this,ActivitiesListActivity.class);
                                    prefEditor.putInt("userId", userList.get(i).getId());
                                    prefEditor.apply();
                                    i1.putExtra("User_data",userList.get(i));
                                    startActivity(i1);
                                    break;
                                }

                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Incorrect Password",Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        else{
                            if(i == userList.size()-1){
                                Toast.makeText(getApplicationContext(),"Incorrect Email address",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}