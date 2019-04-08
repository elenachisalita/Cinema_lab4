package UI;

import Service.MovieService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MovieAddController {
    public TextField txtTitle;
    public TextField txtYear;
    public TextField txtPrice;
    public CheckBox chkAvalible;
    public Button btnAdd;
    public Button btnCancel;
    public Spinner spnId;

    private MovieService movieService;

    public void setService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnAddClick(ActionEvent actionEvent) {

        try {
            String id = String.valueOf(spnId.getValue());
            String title = txtTitle.getText();
            String year = txtYear.getText();
            double price = Double.parseDouble(txtPrice.getText());
            boolean isAvalible = chkAvalible.isSelected();

            movieService.addOrUpdate(id, title, year, price, isAvalible);

            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}
