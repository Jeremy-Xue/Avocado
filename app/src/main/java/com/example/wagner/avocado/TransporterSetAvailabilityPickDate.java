package com.example.wagner.avocado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class TransporterSetAvailabilityPickDate extends AppCompatActivity {

    DatePicker picker;
    private CheckBox AMCheckBox;
    private CheckBox PMCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_set_availability_pick_date);

        AMCheckBox = findViewById(R.id.amCheckBox);
        PMCheckBox = findViewById(R.id.pmCheckBox);

        final Button addMoreButton = findViewById(R.id.transporterSetAvailabilityAddMoreButton);
        addMoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!AMCheckBox.isChecked() && !PMCheckBox.isChecked()) {
                    showToast("Please enter a time when you will be available.");
                }
                else {
                    Intent myIntent = new Intent(TransporterSetAvailabilityPickDate.this, TransporterSetAvailabilityPickDate.class);
                    String phonenumber = getIntent().getStringExtra("phonenumber");
                    myIntent.putExtra("phonenumber", phonenumber);
                    Bundle bundle = getIntent().getParcelableExtra("bundle");
                    LatLng coords = bundle.getParcelable("coordinates");
                    Bundle args = new Bundle();
                    args.putParcelable("coordinates", coords);
                    myIntent.putExtra("bundle", args);
                    startActivity(myIntent);
                }
            }
        });

        final Button finishButton = findViewById(R.id.transporterSetAvailabilityFinishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast("Thank you! Farmers in the area will be notified.");
                Intent myIntent = new Intent(TransporterSetAvailabilityPickDate.this, TransporterViewSchedule.class);
                String phonenumber = getIntent().getStringExtra("phonenumber");
                myIntent.putExtra("phonenumber", phonenumber);
                Bundle bundle = getIntent().getParcelableExtra("bundle");
                LatLng coords = bundle.getParcelable("coordinates");
                Bundle args = new Bundle();
                args.putParcelable("coordinates", coords);
                myIntent.putExtra("bundle", args);
                startActivity(myIntent);
            }
        });

        final Button backButton = findViewById(R.id.transporterSetAvailabilityBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(TransporterSetAvailabilityPickDate.this, TransporterSetAvailabilityLocation.class);
                String phonenumber = getIntent().getStringExtra("phonenumber");
                myIntent.putExtra("phonenumber", phonenumber);

                Bundle bundle = getIntent().getParcelableExtra("bundle");
                LatLng coords = bundle.getParcelable("coordinates");
                Bundle args = new Bundle();
                args.putParcelable("coordinates", coords);
                myIntent.putExtra("bundle", args);
                startActivity(myIntent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_LONG).show();
    }
}
