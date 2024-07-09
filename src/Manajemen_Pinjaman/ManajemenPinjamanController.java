package Manajemen_Pinjaman;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ManajemenPinjamanController {

    @FXML
    private ListView<ManajemenPinjaman> pinjamanListView;

    private ObservableList<ManajemenPinjaman> pinjamanList;

    @FXML
    private void initialize() {
        pinjamanList = FXCollections.observableArrayList(
            new ManajemenPinjaman("Ahmad", "1000000", "Pending", "2024-06-01"),
            new ManajemenPinjaman("Marky", "2000000", "Approved", "2024-06-02"),
            new ManajemenPinjaman("Bagas", "1500000", "Rejected", "2024-06-03")
        );
        pinjamanListView.setItems(pinjamanList);
        pinjamanListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        pinjamanListView.setOnMouseClicked(event -> handleListViewClick(event));
    }

    private void handleListViewClick(MouseEvent event) {
        ManajemenPinjaman selectedPinjaman = pinjamanListView.getSelectionModel().getSelectedItem();
        if (selectedPinjaman != null) {
            showDetail(selectedPinjaman);
        }
    }

    private void showDetail(ManajemenPinjaman pinjaman) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPinjamanView.fxml"));
            Parent root = loader.load();

            DetailPinjamanController controller = loader.getController();
            controller.setPinjamanData(pinjaman);

            Stage stage = new Stage();
            stage.setTitle("Detail Pinjaman");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonBack() {
        Stage stage = (Stage) pinjamanListView.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tampilan_Awal/TampilanAwal.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Home");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
