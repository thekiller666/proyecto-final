import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Pizza Pty.
 */


public class Orden implements Initializable{
    // Importamos las variables que utilizaremos de la ventana
    @FXML
    Label tx_nom_pizza, tx_estado;
    @FXML
    TextField tx_cantidad,tx_total_pagar;
    @FXML
    Button bt_confirma_orden, bt_inicio;
    @FXML
    Pane p_pago;
    @FXML
    ComboBox cmb_tam;

    private String tamano;
    private float cantidad;
    private float total;
    private float precio;

    /**
     *Metodo encargado de manejar todos los eventos de la ventana de orden
     * @param e evento
     * @throws IOException manjeo de excepciones
     */
    public void eventoOrden(ActionEvent e) throws IOException {
        if(e.getSource() == bt_confirma_orden){
            try {
                // Obtenemos la cantidad y tamaño de pizza a ordenar

                cantidad = Integer.parseInt(tx_cantidad.getText());
                tamano = (String) cmb_tam.getValue();

                // Realizamos el calculo de la orden
                generar_precio(cantidad, tamano);

            }catch (NullPointerException e1){
                // Manejamos el error si el usuario no selecciona el tamaño
                tx_estado.setVisible(true);
                tx_estado.setText("** Por favor seleccione el tamaño.");
            }catch (NumberFormatException e1){
                // Manejamos el error si el usuario no ingresa una cantidad correcta
                tx_estado.setVisible(true);
                tx_estado.setText("** Por favor ingrese una cantida en numero.");
            }
        }
        if(e.getSource() == bt_inicio) {
            Controller home = new Controller();
            home.cambiar_Ventana("home", bt_inicio);

        }
    }

    /**
     * Metodo encargado de realizar el calculo de los precios de las pizzas
     * @param cantidad de pizzas a consumir
     * @param tamano de pizza difiren los precios
     */
    private void generar_precio(float cantidad, String tamano){
        tx_estado.setVisible(false);

        if(tamano.equalsIgnoreCase("pequeña")){
            precio = 6;
        } else if(tamano.equalsIgnoreCase("mediana")) {
            precio = 12;
        }else if(tamano.equalsIgnoreCase("grande")) {
            precio = 18;
        }else if(tamano.equalsIgnoreCase("familiar")) {
            precio = 22;
        }
        //Calculamos el total
        total = precio * cantidad;

        //Habilitamos la vista del total a pagar
        p_pago.setVisible(true);

        //Agregamos el total a pagar a la vista
        tx_total_pagar.setText("" + total);
    }

    /**
     * Metedo encargado de inicializar las varibales de la ventana de orden
     * @param location ubicacion del archivo
     * @param resources recursos utilizados
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tx_nom_pizza.setText(Controller.pizza);
    }
}
