package ru.gb_architecture;

import ru.gb_architecture.Models.TableModel;
import ru.gb_architecture.Presenters.BookingPresenter;
import ru.gb_architecture.Presenters.Model;
import ru.gb_architecture.Views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Станислав");

        view.changeReservationTable(1002, new Date(), 3, "Станислав");

        view.changeReservationTable(1001, new Date(), 2, "Станислав");
    }

}
