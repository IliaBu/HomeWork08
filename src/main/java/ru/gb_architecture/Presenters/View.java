package ru.gb_architecture.Presenters;

import ru.gb_architecture.Models.Table;

import java.util.Collection;

public interface View {

    /**
     * Зарегистрировать наблюдателя для представления
     * @param observer наблюдатель
     */
    void registerObserver(ViewObserver observer);

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo);

    /**
     * Отобразить результат таблицы отмены бронирования
     * @param tableNo номер столика
     * @param reservationNo номер брони
     */
    void showCancelReservationTableResult(int tableNo, int reservationNo);

}
