package ru.gb_architecture.Views;

import ru.gb_architecture.Models.Table;
import ru.gb_architecture.Presenters.View;
import ru.gb_architecture.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private final Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showCancelReservationTableResult(int tableNo, int status) {
        if (status > 0)
            System.out.printf("Столик #%d доступен для брони.\n", tableNo);
        else
            System.out.println("Введены некорректные данные.");
    }

    /**
     * Действия клиента (пользователь нажал на кнопку бронирования), бронирование
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку изменения резерва)
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            try {
                observer.changeReservationTable(oldReservation);
                reservationTable(reservationDate, tableNo, name);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
