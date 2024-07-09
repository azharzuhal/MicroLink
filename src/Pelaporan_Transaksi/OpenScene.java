package Pelaporan_Transaksi;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenScene {

    public void openScene(String fxmlFile, Stage window) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.show();
    }
}
