package com.example.himanshu.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.smartpark.model.UserDataModel;

import io.paperdb.Paper;

public class BookParkingActivity extends AppCompatActivity {
    String mode,phoneNo, vehicleNo, setDate, setTime, noOfParking;
    TextView etCustomText;
    EditText etPhoneNo, etVehicleNo, etSetDate, etSetTime, etNoOfParking;
    Button btnProceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_parking);
        etCustomText = (TextView) findViewById(R.id.tv_custom_text);
        etPhoneNo = (EditText) findViewById(R.id.et_phoneno);
        etVehicleNo = (EditText) findViewById(R.id.et_vehicleno);
        etSetDate = (EditText) findViewById(R.id.et_selectdate);
        etSetTime = (EditText) findViewById(R.id.et_selecttime);
        etNoOfParking = (EditText) findViewById(R.id.et_noofparking);
        btnProceed = (Button) findViewById(R.id.btn_proceed);
        etCustomText.setText("Book Parking");
        Paper.init(getApplicationContext());

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                phoneNo = etPhoneNo.getText().toString();
                vehicleNo = etVehicleNo.getText().toString();
                setDate = etSetDate.getText().toString();
                setTime = etSetTime.getText().toString();
                noOfParking = etNoOfParking.getText().toString();

                UserDataModel userDataModel = new UserDataModel(phoneNo,vehicleNo,setDate,setTime,noOfParking);
                Paper.book().write("userBookingInfo",userDataModel);

                startActivity(new Intent(BookParkingActivity.this,DisplayDataActivity.class));
            }
        });
    }
}
