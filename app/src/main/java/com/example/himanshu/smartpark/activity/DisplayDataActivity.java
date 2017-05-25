package com.example.himanshu.smartpark.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.himanshu.smartpark.R;
import com.example.himanshu.smartpark.model.UserDataModel;

import java.util.Random;

import io.paperdb.Paper;

public class DisplayDataActivity extends AppCompatActivity {

    TextView tvCustomText, tvName,tvPhone,tvEmail,tvdate,tvtime,tvbookingid,tvprice,tvvehicleno,tvnoofparking;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        tvCustomText = (TextView) findViewById(R.id.tv_custom_text);
        tvName = (TextView) findViewById(R.id.tvname);
        tvPhone = (TextView) findViewById(R.id.tvphoneno);
        tvprice = (TextView) findViewById(R.id.tvprice);
        tvEmail = (TextView) findViewById(R.id.tvemail);
        tvdate = (TextView) findViewById(R.id.tvdate);
        tvtime = (TextView) findViewById(R.id.tvtime);
        tvbookingid = (TextView) findViewById(R.id.tvbookingid);
        tvnoofparking = (TextView) findViewById(R.id.tvnoofparking);
        tvvehicleno = (TextView) findViewById(R.id.tvvehicleno);
        Paper.init(getApplicationContext());

        UserDataModel customerInfo = new UserDataModel();
        UserDataModel bookingDetails = new UserDataModel();

        tvCustomText.setText("Booking Details");

        customerInfo = Paper.book().read("customerInfo");
        bookingDetails = Paper.book().read("userBookingInfo");

        price = (20 * Integer.parseInt(bookingDetails.getNoOfParking()));

        tvName.setText(customerInfo.getName());
        tvEmail.setText(customerInfo.getEmail());
        tvPhone.setText(bookingDetails.getPhoneNo());
        tvdate.setText(bookingDetails.getSetDate());
        tvtime.setText(bookingDetails.getSetTime());
        tvvehicleno.setText(bookingDetails.getVehicleNo());
        tvnoofparking.setText(bookingDetails.getNoOfParking());
        tvprice.setText(String.valueOf(price));

        Random random = new Random();
        int id = random.nextInt(100-1)+1;

        tvbookingid.setText(String.valueOf(id));
    }
}
