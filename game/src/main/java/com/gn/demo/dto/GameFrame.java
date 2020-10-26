package com.gn.demo.dto;

import javax.swing.*;

/**
 * @Author: gn
 * @Date: 2020-10-24
 * @Description: 游戏窗体
 */
public class GameFrame extends JFrame {

    public GameFrame(){
        //窗体标题
        setTitle("飞机大战");
        //窗体尺寸
        setSize(512,867);
        //界面居中显示
        setLocationRelativeTo(null);
        //设置不允许玩家改变界面大小
        setResizable(false);
        //设置默认的关闭选项
        //关闭窗体的时候推出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //创建游戏窗体
        GameFrame gameFrame = new GameFrame();
        //创建游戏面板
        GamePanel gamePanel = new GamePanel();
        //显示窗体
        gameFrame.setVisible(true);
        //在窗体中加入面板
        gameFrame.add(gamePanel);
    }
}
