package com.gn.demo.dto;

/**
 * @Auther: gn
 * @Date: 2020-6-8 21:19
 * @Description:
 */
public class MainDto {
    public static void main(String[] args) {
        Game game = new Game(changliang.TITLE, changliang.window_width,
                changliang.window_height, changliang.window_fps);
        game.start();
    }
}
