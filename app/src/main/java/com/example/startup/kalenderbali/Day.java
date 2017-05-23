package com.example.startup.kalenderbali;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Startup on 5/21/17.
 */

public class Day implements Parcelable {
    public String date;
    public  String triwara;
    public String pancawara;
    public String sasih;
    public String moon;
    public String circleday;
    public String redday;

    public Day()
    {
        date="";
        triwara="";
        pancawara="";
        sasih="";
        moon="";
        circleday="";
        redday="";
    }

    public static final Parcelable.Creator<Day> CREATOR = new Parcelable.Creator<Day>() {
        public Day createFromParcel(Parcel source) {
            Day day = new Day();
            day.date = source.readString();
            day.triwara = source.readString();
            day.pancawara = source.readString();
            day.sasih=source.readString();
            day.moon=source.readString();
            day.circleday=source.readString();
            day.redday=source.readString();

            return day;
        }
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(date);
        parcel.writeString(triwara);
        parcel.writeString(pancawara);
        parcel.writeString(sasih);
        parcel.writeString(moon);
        parcel.writeString(circleday);
        parcel.writeString(redday);
    }


}
