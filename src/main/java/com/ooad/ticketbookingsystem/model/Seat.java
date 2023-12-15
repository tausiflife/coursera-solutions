package com.ooad.ticketbookingsystem.model;

public class Seat {
    private final String id;
    private final int row;
    private final int seatNo;

    public Seat(String id, int row, int seatNo) {
        this.id = id;
        this.row = row;
        this.seatNo = seatNo;
    }

    public String getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNo() {
        return seatNo;
    }

}
