package ru.gb_architecture.Models;

import ru.gb_architecture.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationData Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationData, int tableNo, String name) {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(tableNo, reservationData, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. " +
                "Повторите попытку позже.");
    }

    /**
     * Изменение таблицы бронирования
     * @param oldReservation старый номер бронирования
     * @return новый номер бронирования
     */
    @Override
    public int changeReservationTable(int oldReservation) {
        for (Table table : tables) {
            Optional<Reservation> current = table.getReservations().stream()
                    .filter(reservation -> reservation.getId() == oldReservation).findFirst();
            if (current.isPresent()) {
                table.getReservations().remove(current.get());
                return table.getNo();
            }
        }
        throw new RuntimeException("Некорректный номер бронирования");
    }


}
