import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller{

    // Importamos las variables que utilizaremos de la ventana
    @FXML Label tx_orden1,tx_orden2,tx_orden3,tx_orden4,tx_orden5,tx_orden6;
    @FXML Button bt_orden1,bt_orden2, bt_orden3, bt_orden4, bt_orden5, bt_orden6;

    // variable estatica para tener la pizza seleccionada
    public static String pizza;

    /**
     * Metodo encargado de manejar todos los eventos de la ventana de home o menu de pizza
     * @param e evento
     * @throws IOException manejo de excepciones
     */
    public void evento(ActionEvent e) throws IOException {
        if(e.getSource() == bt_orden1){
            // Asignamos la pizza selecciona a la variable pizza
            pizza = tx_orden1.getText();
        }
        if(e.getSource() == bt_orden2){
            pizza = tx_orden2.getText();
        }
        if(e.getSource() == bt_orden3){
            pizza = tx_orden3.getText();
        }
        if(e.getSource() == bt_orden4){
            pizza = tx_orden4.getText();
        }
        if(e.getSource() == bt_orden5){
            pizza = tx_orden5.getText();
        }
        if(e.getSource() == bt_orden6){
            pizza = tx_orden6.getText();
        }

        // Cambiamos a la ventana de orden
        cambiar_Ventana("orden", bt_orden1);
    }


    /***
     * Metodo encargado de cambiar las ventanas del programa
     * @param nombre de la ventana que deseemos cambiar
     * @param bt_selecionado sera el boton que dispare la accion
     * @throws IOException manejo de excepciones
     */
    public void cambiar_Ventana(String nombre, Button bt_selecionado) throws IOException {
        nombre = nombre + ".fxml";
        Stage stage = (Stage) bt_selecionado.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource(nombre));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
