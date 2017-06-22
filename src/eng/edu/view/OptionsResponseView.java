/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.view;

import eng.edu.model.AssumptionsDAO;
import eng.edu.ctrl.ReasonPageController;
import eng.edu.model.AssumptionsDisplayModel;
import eng.edu.utilities.Utilities;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author deeptichavan
 */
public class OptionsResponseView {

    public void displayOptionIcon(ObservableList<AssumptionsDAO> assumptionsList, Scene scene) {

        int i;
        String img;

        highlightSelectedOptions(scene);
        disableCheckBoxes(scene);

        for (i = 0; i < assumptionsList.size(); i++) {
            String id = "#label" + i;
            Label lb = (Label) scene.lookup(id);
            lb.setVisible(true);

            if (assumptionsList.get(i).getIsCorrect() == true) {
                img = new File(Utilities.basePath + "/questions/correct.png").toURI().toString();
            } else {
                img = new File(Utilities.basePath + "/questions/cross.png").toURI().toString();
            }
            ImageView iv = new ImageView(img);
            iv.setFitHeight(15);
            iv.setFitWidth(15);
            lb.setGraphic(iv);
        }
    }


    public void highlightSelectedOptions(Scene scene) {

        AssumptionsDisplayModel adm = new AssumptionsDisplayModel();
        int i;
        for (i = 0; i < ReasonPageController.response.size(); i++) {

            boolean isCorrect = adm.assumptionsList.get(ReasonPageController.response.get(i)).getIsCorrect();
            String id = "#checkbox" + ReasonPageController.response.get(i);
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
            cb.setSelected(true);
            if (isCorrect) {   
                cb.setStyle("-fx-text-fill: green;");
            }else{
                cb.setStyle("-fx-text-fill: red;");
            }
        }

    }

    public void disableCheckBoxes(Scene scene) {

        int i;
        for (i = 0; i < ReasonPageController.aaumptionListSize; i++) {
            String id = "#checkbox" + i;
            CheckBox cb = (CheckBox) scene.lookup(id);
            cb.setDisable(true);
        }
    }

    
    public int calculateScore(int numberOfIncorrectResponses, int numberOfResponses, String scoreEvaluationType) {
        ArrayList<Integer> scoreWeightage = readScoreFile();
        int score=0;
        int positiveScore;
        int negativeScore;
        if(scoreEvaluationType.equals("assumption")){
            positiveScore = scoreWeightage.get(0);
            negativeScore = scoreWeightage.get(1);
        }
        else{
            positiveScore = scoreWeightage.get(2);
            negativeScore = scoreWeightage.get(3);
        }
        score = positiveScore*(numberOfResponses-numberOfIncorrectResponses) + (negativeScore*numberOfIncorrectResponses);
        System.out.println("score "+score);
        return score;
     
    }
    
    
    public ArrayList<Integer> readScoreFile(){
        ArrayList<Integer> scoreWeightage = new ArrayList<>();
        try{
            String fileName = "score";
            BufferedReader bufferedReader = Utilities.getFileReader(fileName);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                 String scoreAssignment[] = currentLine.split(":");
                 String scores[] = scoreAssignment[1].split(",");
                 for(int i=0; i<scores.length; i++){
                     scoreWeightage.add(Integer.parseInt(scores[i]));
                 }
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return scoreWeightage;
    }
    
    public void displayScore(Scene scene, int score){
        Label lb1 = (Label) scene.lookup("#score");
        lb1.setText("Score: "+score);
        System.out.println("updatedScore "+score);
    }

    //Pops up a dialogue box to indicate that user needs to select atleast one assumption
    public void showPopupForSelectingAtleastOneAssumption() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select atleast one option!");
        alert.showAndWait();
    }

    //Pops up a dialogue box to indicate that user needs to give reasons for all incorrect assumptions seleted previously
    public void showPopupForSelectingAllReasons() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/eng/edu/view/dialogbox.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Please select reasons for all incorrect assumptions!");
        alert.showAndWait();
    }
}