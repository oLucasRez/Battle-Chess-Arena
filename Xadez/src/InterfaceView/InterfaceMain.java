package InterfaceView;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceMain extends Application {

    //private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        Parent rootLayout = null;
        try {
            rootLayout = FXMLLoader.load(getClass().getResource("PhaseEditor.fxml"));
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Battle Chess Arena Login!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
