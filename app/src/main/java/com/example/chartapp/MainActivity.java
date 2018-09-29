package com.example.chartapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {
    ScatterChart mScatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScatterChart = (ScatterChart) findViewById(R.id.mScatterChart);
        //散点图
        mScatterChart.getDescription().setEnabled(false);
        mScatterChart.setOnChartValueSelectedListener(this);

        mScatterChart.setDrawGridBackground(false);
        mScatterChart.setTouchEnabled(true);
        mScatterChart.setMaxHighlightDistance(10f);

        // 支持缩放和拖动
        mScatterChart.setDragEnabled(true);
        mScatterChart.setScaleEnabled(true);

        mScatterChart.setMaxVisibleValueCount(10);
        mScatterChart.setPinchZoom(true);


        YAxis yl = mScatterChart.getAxisLeft();
        yl.setAxisMinimum(0f);

        mScatterChart.getLegend().setEnabled(false);
        mScatterChart.getAxisRight().setEnabled(false);

        XAxis xl = mScatterChart.getXAxis();
        xl.setDrawGridLines(false);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);

        setData();

    }


    //设置数据
    private void setData() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
//        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
//        ArrayList<Entry> yVals3 = new ArrayList<Entry>();

        for (int i = 0; i < 10; i++) {
            float val = (float) (Math.random() * 10 + 3);
            yVals1.add(new Entry(i, val));
        }

//        for (int i = 0; i < 10; i++) {
//            float val = (float) (Math.random() * 10 + 3);
//            yVals2.add(new Entry(i + 0.33f, val));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            float val = (float) (Math.random() * 10 + 3);
//            yVals3.add(new Entry(i + 0.66f, val));
//        }

        //创建一个数据集,并给它一个类型
        ScatterDataSet set1 = new ScatterDataSet(yVals1, "优秀");
        set1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        set1.setScatterShapeHoleRadius(5);
        set1.setValueTextSize(0);
        set1.setScatterShapeHoleColor(Color.parseColor("#F09A3A"));
        //设置颜色
        set1.setColor(Color.parseColor("#F09A3A"));
//        ScatterDataSet set2 = new ScatterDataSet(yVals2, "及格");
//        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
//        set2.setScatterShapeHoleColor(ColorTemplate.COLORFUL_COLORS[3]);
//        set2.setScatterShapeHoleRadius(3f);
//        set2.setColor(ColorTemplate.COLORFUL_COLORS[1]);
//        ScatterDataSet set3 = new ScatterDataSet(yVals3, "不及格");
//        set3.setColor(ColorTemplate.COLORFUL_COLORS[2]);

        set1.setScatterShapeSize(8f);
//        set2.setScatterShapeSize(8f);
//        set3.setScatterShapeSize(8f);

        ArrayList<IScatterDataSet> dataSets = new ArrayList<IScatterDataSet>();
        dataSets.add(set1);
//        dataSets.add(set2);
//        dataSets.add(set3);

        //创建一个数据集的数据对象
        ScatterData data = new ScatterData(dataSets);

        mScatterChart.setData(data);
        mScatterChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
