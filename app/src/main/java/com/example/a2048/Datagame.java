package com.example.a2048;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

public class Datagame {
    private static Datagame datagame;
    private ArrayList<Integer> arrSO = new ArrayList<>();
    private int[] mangMau;
    private int[][] mangHaiChieu = new int[4][4];
    private Random random = new Random();
    private int point = 0, max = 0;

    static {
        datagame = new Datagame();
    }
    public static Datagame getInstance(){
        return datagame;
    }
    public void intt(Context context){
        for (int i = 0; i < 4 ; i++){
            for( int j = 0 ; j < 4 ; j++){
                mangHaiChieu[i][j] = 0;
                arrSO.add(0);
            }
        }
        TypedArray ta = context.getResources().obtainTypedArray(R.array.mauNemCuaSo);
        mangMau = new int[ta.length()];
        for(int i =0 ; i < ta.length() ; i++){
            mangMau[i]=ta.getColor(i,0);
        }
        ta.recycle();
        taoSo();
        chuyenDoi();

    }

    public ArrayList<Integer> getArrSO(){
        return arrSO;
    }

    public int colorr (int so){
        if(so == 0){
            return Color.WHITE;
        }else {
            int a = (int) (Math.log(so)/Math.log(2));
            return mangMau[a-1];
        }
    }

    public int tinhMax(){
        if(point >= max){
            max = point;
        }
        return max;
    }

    public int tinhDiem(){
        point = 0;
        for(int i = 0 ; i < 4; i++){
            for (int j = 0; j < 4; j++){
                point += mangHaiChieu[i][j];
            }
        }
        return point;
    }

    public  void taoSo(){
        int so0 = 0;
        for(int i =0;i<16;i++){
            if(arrSO.get(i) == 0){
                so0++;
            }
        }
        int soOTao;
        if(so0 > 1){
            soOTao = random.nextInt(2)+1;
        }else {
            if(so0 == 1){
                soOTao = 1;
            }else {
                soOTao = 0;
            }
        }
        while (soOTao != 0){
            int i = random.nextInt(4), j=random.nextInt(4);
            if(mangHaiChieu[i][j] == 0){
                mangHaiChieu[i][j] = 2;
                soOTao--;
            }
        }
    }
    public  void chuyenDoi(){
        arrSO.clear();
        for (int i = 0; i < 4 ; i++){
            for( int j = 0 ; j < 4 ; j++){
                arrSO.add(mangHaiChieu[i][j]);
            }
        }
    }

    public void trai() {
//        soO = 0;
//        setMangLui();
//        khoaCHuyenDoi=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = mangHaiChieu[i][j];
                if (h == 0) {

                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = mangHaiChieu[i][k];
                        if (g == 0) {
                            continue;
                        } else {
                            if (g == h) {
                                mangHaiChieu[i][j] = 2 * h;
                                mangHaiChieu[i][k] = 0;
//                            khoaCHuyenDoi=true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int h=mangHaiChieu[i][j];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j+1;k<4;k++){
                        if(mangHaiChieu[i][k]==0){
                            continue;
                        }else {
                            mangHaiChieu[i][j]=mangHaiChieu[i][k];
                            mangHaiChieu[i][k]=0;
//                            khoa=true;
                            break;
                        }
                    }
                }

            }
        }

        taoSo();
        chuyenDoi();
//        content();
    }
    public void phai() {
//        soO = 0;
//        setMangLui();
//        khoaCHuyenDoi=false;
        for (int i = 3; i >=0; i--) {
            for (int j = 3; j >=0; j--) {
                int h = mangHaiChieu[i][j];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >=0; k--) {
                        int g = mangHaiChieu[i][k];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            mangHaiChieu[i][j] = 2 * h;
                            mangHaiChieu[i][k] = 0;
//                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            for(int j=3;j>=0;j--){
                int h=mangHaiChieu[i][j];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j-1;k>=0;k--){
                        if(mangHaiChieu[i][k]==0){
                            continue;
                        }else {
                            mangHaiChieu[i][j]=mangHaiChieu[i][k];
                            mangHaiChieu[i][k]=0;
//                            khoa=true;
                            break;
                        }
                    }
                }

            }
        }


        taoSo();
        chuyenDoi();
//        content();
    }
    public void len() {
//        soO = 0;
//
//        setMangLui();
//        khoaCHuyenDoi=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = mangHaiChieu[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = mangHaiChieu[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            mangHaiChieu[j][i] = 2 * h;
                            mangHaiChieu[k][i] = 0;
//                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int h=mangHaiChieu[j][i];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j+1;k<4;k++){
                        if(mangHaiChieu[k][i]==0){
                            continue;
                        }else {
                            mangHaiChieu[j][i]=mangHaiChieu[k][i];
                            mangHaiChieu[k][i]=0;
//                            khoa=true;
                            break;
                        }
                    }
                }

            }
        }


        taoSo();
        chuyenDoi();
//        content();
    }
    public void xuong() {
//        soO = 0;
//        setMangLui();
//        khoaCHuyenDoi=false;
        for (int i = 3; i >=0; i--) {
            for (int j = 3; j >=0; j--) {
                int h = mangHaiChieu[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >=0; k--) {
                        int g = mangHaiChieu[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            mangHaiChieu[j][i] = 2 * h;
                            mangHaiChieu[k][i] = 0;
//                            khoaCHuyenDoi=true;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0;i<4;i++){
            for(int j=3;j>=0;j--){
                int h=mangHaiChieu[j][i];
                if(h!=0){
                    continue;
                }else {
                    for(int k=j-1;k>=0;k--){
                        if(mangHaiChieu[k][i]==0){
                            continue;
                        }else {
                            mangHaiChieu[j][i]=mangHaiChieu[k][i];
                            mangHaiChieu[k][i]=0;
//                            khoa=true;
                            break;
                        }
                    }
                }

            }
        }

        taoSo();
        chuyenDoi();
//        content();
    }
}
