package eng.edu.ctrl;

import eng.edu.model.AssumptionsModel;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

<<<<<<< HEAD

=======
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class EngEduMain extends Application {

<<<<<<< HEAD
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("/eng/edu/view/WelcomePage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        //stage.setMaximized(true);
        //stage.setFullScreen(true);
        stage.setTitle("Engineering Educators");
        stage.show();
=======
    @FXML
    public ScrollPane scroll;
    @FXML
    private Button submitId;

    VBox vbox1;
    Button submitButton;
    
    AssumptionsModel adm;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // load main form in to VBox (Root)
        VBox mainPane = (VBox) FXMLLoader.load(getClass().getResource("/eng/edu/view/main.fxml"));
        SplitPane split = (SplitPane) mainPane.getChildren().get(1);
        AnchorPane anchor = (AnchorPane) split.getItems().get(0);
        vbox1 = (VBox) anchor.getChildren().get(0);
        scroll = (ScrollPane) vbox1.getChildren().get(2);

        //get all the checkboxes
        adm = new AssumptionsModel();
        adm.assignAssumptionsToCheckBoxes();
        adm.assignLablesToAssumptions();

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 20));

        //add these checkboxes to the vbox
        int i;
        for (i = 0; i < adm.checkBoxes.size(); i++) {
            final HBox hbox = new HBox();
            vbox.getChildren().add(hbox);
            hbox.getChildren().addAll(adm.labels.get(i), adm.checkBoxes.get(i));
        }
        //add vbox to scroll pane
        scroll.setContent(vbox);

        //group the images and checkboxes together
        Group grp = new Group();
        grp.getChildren().addAll(mainPane, vbox);
        primaryStage.setTitle("Engineering Educators");
        primaryStage.setScene(new Scene(grp));
        primaryStage.setMaximized(true);    // make the main form fit to the screen
        primaryStage.show();
>>>>>>> 1c31831230f666d78ce3227c0b2d4e1e075aee8e
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
