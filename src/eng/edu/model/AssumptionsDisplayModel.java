/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.model;

import eng.edu.ctrl.AssumptionsDAO;
import eng.edu.ctrl.QuestionController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deeptichavan
 * 
 * This class reads the assumptions text file and stores them in a list,
 * which is then displayed from the AssumptionsTableView class
 */
public class AssumptionsDisplayModel {

    public String assumptionsTxt;
    public ObservableList<AssumptionsDAO> assumptionsList = FXCollections.observableArrayList();

    public AssumptionsDisplayModel() {

       
        QuestionController qc = new QuestionController();
        int n1 = QuestionController.n;
        System.out.println("n1: "+n1);
        assumptionsTxt = qc.getPath("assumptions", n1, ".txt");
        String[] split = assumptionsTxt.split(":");
        assumptionsTxt = split[1];
        
        BufferedReader br;

        try {

            String currentLine;
            br = new BufferedReader(new FileReader(assumptionsTxt));

            while ((currentLine = br.readLine()) != null) {
                //text and result is spearated by a | in the .txt file
                String[] temp = currentLine.split("\\|");
                //get the assumption text
                String aTxt = temp[0].trim(); 
                /*
                String bigTxt = temp[0].trim(); 
                for(int i = 0; i < bigTxt.length(); i++){
                    
                }*/
                //whether the assumption is correct or no
                //1 - correct and 0 - wrong
                int res = Integer.parseInt(temp[1].trim());     
                assumptionsList.add(new AssumptionsDAO(aTxt, res));
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
