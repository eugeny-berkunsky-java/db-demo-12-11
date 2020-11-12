package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.SpecService;
import tables.Spec;
import tables.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controller {
    @FXML private TextField specField;
    @FXML private ListView<Spec> specList;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, Double> ratingColumn;
    @FXML private TextField nameField;
    @FXML private TextField ratingField;

    private SpecService specService;

    @FXML
    public void initialize() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = factory.createEntityManager();
        specService = new SpecService(em);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        specList.setItems(FXCollections.observableList(specService.findAll()));
        specList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue!=null)
                        studentTable.setItems(FXCollections.observableArrayList(newValue.getStudents()));
                }
        );
    }
}
