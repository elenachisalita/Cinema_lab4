package UI;

import Domain.Movie;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.time.zone.ZoneRulesProvider.refresh;


public class Controller {

    public TableView tableViewMovies;
    public TableColumn tableColumnId;
    public TableColumn tableColumnTitle;
    public TableColumn tableColumnYear;
    @FXML
    public TableColumn tableColumnPrice;
    public TableColumn tableColumnAvalible;
    public Button btnMovieAdd;
    public Button btnMovieDelete;

    private MovieService movieService;
    private ClientService clientService;
    private ReservationService reservationService;

    private ObservableList<Movie> movies = FXCollections.observableArrayList();

    public void setServices(MovieService movieService, ClientService clientService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientService = clientService;
        this.reservationService = reservationService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            tableColumnYear.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
            movies.addAll(movieService.getAll());
            tableViewMovies.setItems(movies);
        });
    }

    public void editMovieTitle(TableColumn.CellEditEvent cellEditEvent) {
        Movie editedMovie = (Movie)cellEditEvent.getRowValue();
        try {
            String newTitle= (String)cellEditEvent.getNewValue();
            movieService.addOrUpdate(editedMovie.getId(),newTitle, editedMovie.getTitle(), editedMovie.getYear(), editedMovie.getPrice(), editedMovie.isAvalible());
            editedMovie.setTitle(newTitle);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        tableViewMovies.refresh();
    }

    public void editCakeYear(TableColumn.CellEditEvent cellEditEvent) {
        Movie editedMovie = (Movie)cellEditEvent.getRowValue();
        try {
            double newYear = (double)cellEditEvent.getNewValue();
            movieService.addOrUpdate(editedMovie.getId(), editedMovie.getTitle(), editedMovie.getYear(), newYear editedMovie.getPrice(), editedMovie.isAvalible());
            editedMovie.setYear(newYear);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        tableViewMovies.refresh();
    }

    public void btnMovieAddClick(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("movieAdd.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Movie add");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MovieAddController controller =  fxmlLoader.getController();
            controller.setService(movieService);
            stage.showAndWait();
            movies.clear();
            movies.addAll(movieService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Movie add.", e);
        }
    }

    public void btnMovieDeleteClick(ActionEvent actionEvent) {
        Movie selected = (Movie)tableViewMovies.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                movieService.remove(selected.getId());
                movies.clear();
                movies.addAll(movieService.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }
}
