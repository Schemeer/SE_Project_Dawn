package com.example.DAWN;

import android.graphics.*;

import java.lang.*;


import java.util.Vector;


public class Map {
    public static int unit = 50;
    public static int size = 100;

    public Vector<Role_simple> livingrole;
    public Vector<Prop> proplist;
    public int[][] m;


    Map() {
        String st="1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000111111111111111111111111111111111111111100000000000000000000000001111100000000000000000001\n" +
                "1000000000111111111111111111111111111111111111111100000000000000000000000001111100000000000000000001\n" +
                "1000000000111111111111111111111111111111111111111100000000000000000000000001111100000000000000000001\n" +
                "1000000000111111111111111111111111111111111111111100000000000000000000000001111100000000000000000001\n" +
                "1000000000111111111111111111111111111111111111111100000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000001111111111111111111111111111111111111111000000000000000000000000000001\n" +
                "1000000000000001111100000000001111111111111111111111111111111111111111000000000000000000000000000001\n" +
                "1000000000000001111100000000001111111111111111111111111111111111111111000000000000000000000000000001\n" +
                "1000000000000001111100000000001111111111111111111111111111111111111111000000000000000000000000000001\n" +
                "1000000000000001111100000000001111111111111111111111111111111111111111000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000111111111111111111111111111111111111111111111111110000000000000000000000001\n" +
                "1000000000000000000000000111111111111111111111111111111111111111111111111110000000000000000000000001\n" +
                "1000000000000000000000000111111111111111111111111111111111111111111111111110000000000000000000000001\n" +
                "1000000000000000000000000111111111111111111111111111111111111111111111111110000000000000000000000001\n" +
                "1000000000000000000000000111111111111111111111111111111111111111111111111110000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001\n" +
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n";
        m=new int[100][100];
        int row=0; int col=0;
        for (int i=0;i<st.length();i++) {
            char[] chr=st.toCharArray();
            switch (chr[i]){
                case '1':m[col][row]=1; row++; break;
                case '0':m[col][row]=0; row++; break;
                case  '\n' : row=0;col++;
            }
        }

        livingrole = new Vector<Role_simple>();
        proplist = new Vector<Prop>();

    }



    public Boolean update(){
        //根据传回内容更新各角色数值以及道具情况
        return true;
    }



}
