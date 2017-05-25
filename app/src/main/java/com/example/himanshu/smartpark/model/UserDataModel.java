package com.example.himanshu.smartpark.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by himanshu on 14/5/17.
 */

public class UserDataModel implements Parcelable{

    String name, email, password, phoneNo, vehicleNo, setDate, setTime, noOfParking;

    public UserDataModel(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDataModel(final String phoneNo, final String vehicleNo, final String setDate, final String setTime, final String noOfParking) {
        this.phoneNo = phoneNo;
        this.vehicleNo = vehicleNo;
        this.setDate = setDate;
        this.setTime = setTime;
        this.noOfParking = noOfParking;
    }

    public UserDataModel() {

    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(final String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getSetDate() {
        return setDate;
    }

    public void setSetDate(final String setDate) {
        this.setDate = setDate;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(final String setTime) {
        this.setTime = setTime;
    }

    public String getNoOfParking() {
        return noOfParking;
    }

    public void setNoOfParking(final String noOfParking) {
        this.noOfParking = noOfParking;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    protected UserDataModel(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
        phoneNo = in.readString();
        vehicleNo = in.readString();
        setDate = in.readString();
        setTime = in.readString();
        noOfParking = in.readString();
    }

    public static final Creator<UserDataModel> CREATOR = new Creator<UserDataModel>() {
        @Override
        public UserDataModel createFromParcel(Parcel in) {
            return new UserDataModel(in);
        }

        @Override
        public UserDataModel[] newArray(int size) {
            return new UserDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(noOfParking);
        dest.writeString(phoneNo);
        dest.writeString(vehicleNo);
        dest.writeString(setDate);
        dest.writeString(setTime);
    }
}
