package ru.gb_architecture.Models;

import java.util.Date;

public class Reservation {

    public Reservation(int table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }

    private static int counter = 1000;
    private final int id;
    private final int table;

    {
        id = ++counter;
    }

    private final Date date;

    private final String name;


    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
