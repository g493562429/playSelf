package com.gn.demo.dto;


import com.gn.demo.utils.DrawUtils;

import java.io.IOException;

public class Wall {
    private static int x = 0;
    private static int y = 0;

    public Wall(int x, int y) {
        this.x=x;
        this.y=y;
    }

    //画
    public static void draw(int x,int y) throws IOException {

        DrawUtils.draw (changliang.Wall_pic,x,y);
    }
}
