package com.gn.demo.dto;

import java.io.IOException;

import com.gn.demo.utils.Window;
import org.lwjgl.input.Keyboard;

public class Game extends Window {
    public Game(String title, int width, int height, int fps) {
        super (title, width, height, fps);
    }

    private Tank tank;
    private Wall wall;

    //创建游戏界面时候调用，只调用一次
    @Override
    protected void onCreate() {
        int width=changliang.window_width / changliang.Element_width / 2 * changliang.Element_width;

        int height=changliang.window_height - changliang.Element_heigth;

        tank=new Tank (width, height);

    }

    //鼠标监听
    @Override
    protected void onMouseEvent(int key, int x, int y) {
        System.out.println (key + "--" + x + "-" + (changliang.window_height - y));
    }

    //键盘监听
    @Override
    protected void onKeyEvent(int key) {
        if (key == Keyboard.KEY_W || key == Keyboard.KEY_UP) {
            tank.move (FangXiang.up);

        } else if (key == Keyboard.KEY_S || key == Keyboard.KEY_DOWN) {
            tank.move (FangXiang.down);

        } else if (key == Keyboard.KEY_A || key == Keyboard.KEY_LEFT) {
            tank.move (FangXiang.left);

        } else if (key == Keyboard.KEY_D || key == Keyboard.KEY_RIGHT) {
            tank.move (FangXiang.right);

        }
    }

    //屏幕刷新频率
    @Override
    protected void onDisplayUpdate() throws IOException {
//            DrawUtils.draw ("res/img/01.jpg",256,156);
        tank.draw ();
        for (int i=1; i < changliang.window_width/changliang.Element_width-1; i++) {

            wall.draw (i*changliang.Element_width,0);

        }
        for (int i=0; i < changliang.window_height / changliang.Element_heigth; i++) {
            wall.draw (changliang.Element_width,i*changliang.Element_heigth);
        }
    }

}

