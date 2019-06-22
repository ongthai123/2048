package com.example.a2048;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class OVuong extends android.support.v7.widget.AppCompatTextView {
    public OVuong(Context context) {
        super(context);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai,dai);
    }

    public void setTett(int so){
        if(so < 100){
            setTextSize(40);
        }else if (so < 1000){
            setTextSize(35);
        }else {
            setTextSize(30);
        }
        if(so>=8){
            setTextColor(Color.WHITE);
        }else{
            setTextColor(Color.BLACK);
        }

        GradientDrawable drawable = (GradientDrawable)this.getBackground();
        drawable.setColor(Datagame.getInstance().colorr(so));
        setBackground(drawable);

        if(so == 0){
            setText(" ");
        }else {
            setText(""+so);
        }
    }
}
