package com.example.startup.kalenderbali;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MonthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MonthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Month mParam1;
    private String mParam2;
    Year year;

    LinearLayout linearLayoutWuku;
    LinearLayout linearLayoutIngkel;
    LinearLayout linearLayoutWeek1;
    LinearLayout linearLayoutWeek2;
    LinearLayout linearLayoutWeek3;
    LinearLayout linearLayoutWeek4;
    LinearLayout linearLayoutWeek5;

    private AdView mAdView;


    private OnFragmentInteractionListener mListener;

    public MonthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthFragment newInstance(Month param1, String param2) {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflater= inflater.inflate(R.layout.fragment_month, container, false);
        mAdView = (AdView) myInflater.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        year = Kalender.getKalender();
        TextView textViewMonthYear = (TextView) myInflater.findViewById(R.id.month_year);
        TextView textViewCaka = (TextView) myInflater.findViewById(R.id.caka);
        linearLayoutWuku = (LinearLayout) myInflater.findViewById(R.id.wuku);
        linearLayoutIngkel = (LinearLayout) myInflater.findViewById(R.id.ingkel);
        linearLayoutWeek1 = (LinearLayout) myInflater.findViewById(R.id.week1);
        linearLayoutWeek2 = (LinearLayout) myInflater.findViewById(R.id.week2);
        linearLayoutWeek3 = (LinearLayout) myInflater.findViewById(R.id.week3);
        linearLayoutWeek4 = (LinearLayout) myInflater.findViewById(R.id.week4);
        linearLayoutWeek5 = (LinearLayout) myInflater.findViewById(R.id.week5);
        textViewMonthYear.setText(mParam1.getMonth_name()+" "+year.year);

        textViewCaka.setText("SAKA: "+year.year);

        fetchWuku(mParam1.wuku);
        fetchIngkel(mParam1.ingkel);
        fetchDay(mParam1.day);






        return myInflater;
    }

    public void fetchWuku(String[] wuku)
    {
        for (int i = 0; i < wuku.length; i++) {
            final int j=i;
            LayoutInflater wukuInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) wukuInflater.inflate(R.layout.wuku_layout, linearLayoutWuku, false);
            TextView textViewWuku = (TextView) convertView.findViewById(R.id.wuku);

            textViewWuku.setText(wuku[i].toUpperCase());
            linearLayoutWuku.addView(convertView);

        }
    }
    public void fetchIngkel(String[] ingkel)
    {
        for (int i = 0; i < ingkel.length; i++) {
            final int j=i;
            LayoutInflater ingkelInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) ingkelInflater.inflate(R.layout.ingkel_layout, linearLayoutIngkel, false);
            TextView textViewIngkel = (TextView) convertView.findViewById(R.id.ingkel);

            textViewIngkel.setText(ingkel[i].toUpperCase());
            linearLayoutIngkel.addView(convertView);

        }
    }
    public void fetchDay(Day[] day)
    {
        for (int i = 0; i < 7; i++) {
            LayoutInflater dayInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) dayInflater.inflate(R.layout.day_layout, linearLayoutWeek1, false);
            linearLayoutWeek1.addView(fetchDay(convertView,day,i));
        }
        for (int i = 7; i < 14; i++) {
            LayoutInflater dayInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) dayInflater.inflate(R.layout.day_layout, linearLayoutWeek2, false);
            linearLayoutWeek2.addView(fetchDay(convertView,day,i));
        }
        for (int i = 14; i < 21; i++) {
            LayoutInflater dayInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) dayInflater.inflate(R.layout.day_layout, linearLayoutWeek3, false);
            linearLayoutWeek3.addView(fetchDay(convertView,day,i));
        }
        for (int i = 21; i < 28; i++) {
            LayoutInflater dayInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) dayInflater.inflate(R.layout.day_layout, linearLayoutWeek4, false);
            linearLayoutWeek4.addView(fetchDay(convertView,day,i));
        }
        for (int i =28 ; i < 35; i++) {
            LayoutInflater dayInflater = LayoutInflater.from(getActivity());
            final RelativeLayout convertView = (RelativeLayout) dayInflater.inflate(R.layout.day_layout, linearLayoutWeek5, false);
            linearLayoutWeek5.addView(fetchDay(convertView,day,i));
        }
    }

    public View fetchDay(RelativeLayout convertView,Day[] day,int i)
    {
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView triwara = (TextView) convertView.findViewById(R.id.triwara);
        TextView pancawara = (TextView) convertView.findViewById(R.id.pancawara);
        TextView sasih = (TextView) convertView.findViewById(R.id.sasih);
        ImageView moon = (ImageView) convertView.findViewById(R.id.moon);
        ImageView circle = (ImageView) convertView.findViewById(R.id.circleday);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Uk_Bodoni Bold.ttf");
        date.setTypeface(typeface);
        if(!day[i].date.equals("0"))
        {
            date.setText(day[i].date);
            triwara.setText(day[i].triwara);
            pancawara.setText(day[i].pancawara);
            sasih.setText(day[i].sasih);
            if(day[i].moon.equals("purnama"))
            {
                moon.setImageResource(R.drawable.purnama);
            }
            else if(day[i].moon.equals("tilem"))
            {
                moon.setImageResource(R.drawable.tilem);
            }
            else
            {
                convertView.removeView(moon);
            }
            if(!day[i].circleday.equals("0"))
            {
                circle.setImageResource(R.drawable.libur);
            }
            else
            {
                convertView.removeView(circle);
            }
            if(!day[i].redday.equals("0"))
            {
                date.setTextColor(getResources().getColor(R.color.red));
            }
            else
            {
                date.setTextColor(getResources().getColor(R.color.black));
            }
        }
        else
        {
            convertView.removeAllViews();
        }
        return convertView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
