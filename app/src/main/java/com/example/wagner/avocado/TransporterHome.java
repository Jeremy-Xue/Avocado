package com.example.wagner.avocado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransporterHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_home);

        final Button scheduleButton = findViewById(R.id.transporterHomeViewScheduleButton);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, TransporterViewSchedule.class);
                String phonenumber = getIntent().getStringExtra("phonenumber");
                myIntent.putExtra("phonenumber", phonenumber);
                startActivity(myIntent);
            }
        });

        final Button editProfileButton = findViewById(R.id.transporterHomeProfileButton);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, TransporterEditProfile.class);
                String phonenumber = getIntent().getStringExtra("phonenumber");
                myIntent.putExtra("phonenumber", phonenumber);
                startActivity(myIntent);
            }
        });

        final Button messagesButton = findViewById(R.id.transporterHomeMessagesButton);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, TransporterMessages.class);
                String phonenumber = getIntent().getStringExtra("phonenumber");
                myIntent.putExtra("phonenumber", phonenumber);
                startActivity(myIntent);
            }
        });

       /* final Button historyButton = findViewById(R.id.transporterHomeHistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, TransporterHistory.class);
                startActivity(myIntent);
            }
        });*/

        final Button signOutButton = findViewById(R.id.transporterHomeSignOutButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, BeginSignUp.class);
                startActivity(myIntent);
            }
        });

        final Button farmerButton = findViewById(R.id.transporterHomeFarmerButton);
        farmerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterHome.this, FarmerHome.class);
                startActivity(myIntent);
            }
        });
    }
}