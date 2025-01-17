/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ia2020.tp.busquedainfectados;

import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class busquedainfectados extends Application {
    private Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MapDrawer.fxml"));
        Parent root = loader.load();
        
        scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //Indica que cuando se cierre la ventana se termine el hilo de b�squeda 
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        MapDrawerController.closeSearchThread();
    }
    
}
