package com.example.testbaitap.process.n.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.example.testbaitap.R;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;


public class WeeklyFragment extends Fragment {

    public WeeklyFragment() {
        // Required empty public constructor
    }


    public static WeeklyFragment newInstance() {
        WeeklyFragment fragment = new WeeklyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weekly, container, false);
        LineChart lineChart = view.findViewById(R.id.lineChart);
        ArrayList<Entry> entryArrayList = new ArrayList<>();
        entryArrayList.add(new Entry(2011, 60));
        entryArrayList.add(new Entry(2012, 50));
        entryArrayList.add(new Entry(2013, 30));
        entryArrayList.add(new Entry(2015, 40));
        entryArrayList.add(new Entry(2016, 20));
        entryArrayList.add(new Entry(2019, 60));
        entryArrayList.add(new Entry(2020, 45));
        entryArrayList.add(new Entry(2021, 35));
        entryArrayList.add(new Entry(2022, 25));

//        for (YourData data : dataObjects) {
//            entryArrayList.add(new Entry(data.getValueX(), data.getValueY()));
//        }
        LineDataSet dataSet = new LineDataSet(entryArrayList, "C??n n???ng"); // add entries to dataset
        dataSet.setColor(getResources().getColor(R.color.red));
        dataSet.setValueTextColor(getResources().getColor(R.color.dot_dark_screen)); // styling, ...
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); // refresh


        Description description = new Description();
        description.setText("M?? t???: Tr???c ?????ng bi???u th??? c??n n???ng, tr???c ngang bi???u th??? c??c n??m");
        lineChart.setDescription(description);

        lineChart.setNoDataText("Ch??a c?? d??? li???u");
        lineChart.setNoDataTextColor(getResources().getColor(R.color.red));
        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxisL = lineChart.getAxisLeft();
        YAxis yAxisR = lineChart.getAxisRight();
        xAxis.setValueFormatter(new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == (int) value) {
                    if (value == 0)
                        return "0";
                    else
                        return String.valueOf((int)(value )).split(" ")[0];
                }
                else return "";
            }
        });

//        setBackgroundColor(int color): set m??u background bao ph??? to??n b??? Chart, ngo??i ra backgroundColor c?? th??? set trong xml
//        setDescription(String desc): hi???n th??? text m?? t??? s??? xu???t hi???n ??? g??c ph???i d?????i c???a bi???u ?????
//        setDescriptionColor(int color) : set m??u cho text description
//        setDescriptionPosition(float x, float y): custom v??? tr?? cho description text b???ng pixel
//        setDescriptionTypeface(Typeface t): set TypeFace s??? d???ng cho vi???c v??? description text
//        setDescriptionTextSize(float size): set k??ch th?????c Description text b???ng pixel setNoDataText(String text) : Set text s??? xu???t hi???n khi bi???u ????? tr???ng
//        setDrawGridBackground(boolean enabled) : n???u n?? ??c enable th?? h??nh ch??? nh???t n???n ph??a sau v??ng bi???u ????? s??? ???????c v???.
//                setDrawBorders(boolean enabled): Enable/disable chart bolders (c??c ???????ng bao quanh bi???u ?????)
//        setBorderColor(int color) : Set m??u cho chart bolders
//        setBorderWidth(float width): set b??? d???y ???????ng bao quanh bi???u ????? b???ng dp
//        setMaxVisibleValueCount(int count): ?????t s??? l?????ng lable xu???t hi???n t???i ??a tr??n bi???u ?????
        return view;
    }
    public class My implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return null;
        }
    }
}