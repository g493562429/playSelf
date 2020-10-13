package com.gn.demo.dto;

/**
 * @Author gn
 */
public class SellTicket {

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();
        for (int i = 1; i < 100; i++) {
			Thread thread = new Thread(tw, "TicketWindow-" + i);
            thread.start();
        }
    }

}
