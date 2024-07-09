import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class MainController {

    @FXML
    private void handleLogin() {
        loadView("Registrasi_Pengguna/LoginView.fxml", "Login");
    }

    @FXML
    private void handleRegistrasi() {
        loadView("Registrasi_Pengguna/RegistrasiView.fxml", "Registrasi Pengguna");
    }

    private void loadView(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tidak dapat memuat tampilan: " + fxmlPath);
            alert.showAndWait();
        }
    }
}
