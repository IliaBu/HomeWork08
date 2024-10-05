package ru.gb_architecture.Presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTables(){
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }


    @Override
    public void onReservationTable(Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservtionDate, tableNo, name);
            showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            showReservationTableResult(-1);
        }
    }

    @Override
    public void changeReservationTable(int reservationNo) {
        try {
            int tableNo = model.changeReservationTable(reservationNo);
            view.showCancelReservationTableResult(tableNo, reservationNo);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Невозможно переназначить столик");
        }
    }

}
