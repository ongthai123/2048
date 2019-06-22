package com.example.a2048;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gdvGamePlay;
    private OSoAdapter oVuongAdapter;
    private View.OnTouchListener listener;
    private float X,Y;
    private TextView txtvPoint, txtvMax;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        khoiTao();
        setData();

        Button btnReplay = (Button) findViewById(R.id.btnReplay);
        txtvPoint = findViewById(R.id.txtvPoint);
        txtvMax = findViewById(R.id.txtvMax);

        final TextView txtvMax = findViewById(R.id.txtvMax);



        btnReplay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Datagame.getInstance().getArrSO().clear();
                anhXa();
                khoiTao();
                setData();
                final TextView point = txtvPoint;
                point.setText("0");
                return false;
            }
        });
    }

    private void anhXa(){
        gdvGamePlay=(GridView)findViewById(R.id.gdvGamePlay);
    }
    private void khoiTao(){
        Datagame.getInstance().intt(MainActivity.this);
        oVuongAdapter = new OSoAdapter(MainActivity.this,0, Datagame.getInstance().getArrSO());

        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Datagame.getInstance().setKhoaback(true);
                switch ((event.getAction())) {
                    case MotionEvent.ACTION_DOWN:
                        X = event.getX();
                        Y = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (Math.abs(event.getX() - X) > Math.abs(event.getY() - Y)) {
                            if (event.getX() > X) {
                                Datagame.getInstance().phai();
                                oVuongAdapter.notifyDataSetChanged();
                                txtvPoint.setText(""+Datagame.getInstance().tinhDiem());
                                txtvMax.setText(""+Datagame.getInstance().tinhMax());
                            } else {
                                Datagame.getInstance().trai();
                                oVuongAdapter.notifyDataSetChanged();
                                txtvPoint.setText(""+Datagame.getInstance().tinhDiem());
                                txtvMax.setText(""+Datagame.getInstance().tinhMax());
                            }
                        } else {

                            if (event.getY() > Y) {

                                Datagame.getInstance().xuong();
                                oVuongAdapter.notifyDataSetChanged();
                                txtvPoint.setText(""+Datagame.getInstance().tinhDiem());
                                txtvMax.setText(""+Datagame.getInstance().tinhMax());
                            } else {
                                Datagame.getInstance().len();
                                oVuongAdapter.notifyDataSetChanged();
                                txtvPoint.setText(""+Datagame.getInstance().tinhDiem());
                                txtvMax.setText(""+Datagame.getInstance().tinhMax());
                            }
                        }
                        break;
                }
//                txvMAX.setText(""+Data.getInstance().getPoint());


                return true;
            }
        };
    }
    private void setData(){
        gdvGamePlay.setAdapter(oVuongAdapter);
        gdvGamePlay.setOnTouchListener(listener);
    }
}
