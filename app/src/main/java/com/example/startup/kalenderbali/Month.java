package com.example.startup.kalenderbali;

import android.content.ClipData;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Startup on 5/21/17.
 */

public class Month implements Parcelable {
    public String month_name;
    public String[] wuku;
    public String[] ingkel;
    public Day[] day;

    public Month()
    {
        month_name="";
        wuku= new String[5];
        ingkel= new String[5];
        day = new Day[35];
    }

    public String getMonth_name()
    {
        return month_name.toUpperCase();
    }


    public static final Creator<Month> CREATOR = new Creator<Month>() {
        public Month createFromParcel(Parcel source) {
            Month month = new Month();
            month.month_name = source.readString();
            month.wuku = source.createStringArray();
            month.ingkel = source.createStringArray();
            month.day=source.createTypedArray(Day.CREATOR);

            return month;
        }
        public Month[] newArray(int size) {
            return new Month[size];
        }
    };

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(month_name);
        parcel.writeStringArray(wuku);
        parcel.writeStringArray(ingkel);
        parcel.writeTypedArray(day,0);
    }



}
