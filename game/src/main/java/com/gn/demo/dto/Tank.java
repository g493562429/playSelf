package com.gn.demo.dto;


import com.gn.demo.utils.DrawUtils;

import java.io.IOException;

public class Tank {
    //x、y坐标
    private int x;
    private int y;

    public Tank(int x, int y) {
        this.x=x;
        this.y=y;
    }

    //方向
    private FangXiang fangXiang=FangXiang.up;

    //速度
    private int speed=32;

    //画
    public void draw() {
        switch (fangXiang) {
            case up:
                try {
                    DrawUtils.draw (changliang.TankFangXiang_UP, x, y);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                break;
            case down:
                try {
                    DrawUtils.draw (changliang.TankFangXiang_Down, x, y);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                break;
            case left:
                try {
                    DrawUtils.draw (changliang.TankFangXiang_left, x, y);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                break;
            case right:
                try {
                    DrawUtils.draw (changliang.TankFangXiang_right, x, y);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
                break;

        }
    }

    //移动
    public void move(FangXiang fangXiang) {
        if (this.fangXiang != fangXiang) {
            this.fangXiang=fangXiang;
            return;
        } else {

            switch (fangXiang) {
                case up:
                    if (y <= 0) {
                        y=0;
                    } else {
                        y-=speed;

                    }
                    break;
                case down:
                    if (y >= changliang.window_height - changliang.Element_heigth) {
                        y=changliang.window_height - changliang.Element_heigth;
                    } else {

                        y+=speed;
                    }
                    break;
                case left:
                    if (x <= 0) {
                        x=0;
                    } else {
                        x-=speed;
                    }
                    break;
                case right:
                    if (x >= changliang.window_width - changliang.Element_width) {
                        x=changliang.window_width - changliang.Element_width;
                    } else {
                        x+=speed;
                    }
                    break;
            }
        }

    }

}
