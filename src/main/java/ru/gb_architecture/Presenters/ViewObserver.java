package ru.gb_architecture.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservtionDate, int tableNo, String name);

    void changeReservationTable(int tableNo);

}
