/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ia2020.tp.busquedainfectados;

import java.awt.ScrollPane;
import java.io.File;
import java.lang.Thread.State;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utn.ia2020.tp.busquedainfectados.covid.RobotcovidAgent;
import utn.ia2020.tp.busquedainfectados.covid.RobotcovidEnvironment;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class MapDrawerController implements Initializable {
    @FXML
    private Pane panDrawer;
    @FXML
    private ImageView imgMap;
    @FXML
    private Button btnRunSimulator;
    @FXML
    private ComboBox<EnumEstrategia> cbEstrategia;
    @FXML
    private CheckBox cbInfectMovimRandom;
    @FXML
    private CheckBox cbAgregarInfectRandom;
    
    @FXML
    private TableView<AccionBusqueda> tvTablaAcciones;
    @FXML
    private TableColumn<AccionBusqueda,String> tcAcciones;
    private ObservableList<AccionBusqueda> obsListAcciones;
    
    public static Thread thre;
    
    //Tamaño de las imagenes
    final int IMG_H = 54;
    final int IMG_W = 54;
    final int INFECT_IMG_H = 44;
    final int INFECT_IMG_W = 44;
    
    final Double ORIGEN_X_PX = 572.0;
    final Double ORIGEN_Y_PX = 1034.0;
    
    
    
    private ImageView agent;
    private HashMap<Integer,ImageView> infectados = new HashMap<Integer,ImageView>();
    private HashMap<Integer,ImageView> infectadosAtrapados = new HashMap<Integer,ImageView>();
    private HashMap<Integer,ImageView> sensoresActivados = new HashMap<Integer,ImageView>();
    private HashMap<Integer,ImageView> bloqueosTotales = new HashMap<Integer,ImageView>();
    private HashMap<Integer,ImageView> bloqueosAgente = new HashMap<Integer,ImageView>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            this.agent = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/agent.png"));
            this.agent.setFitWidth(IMG_W);
            this.agent.setFitHeight(IMG_H);
            this.moverAgent(0.0, 0.0);
            this.panDrawer.getChildren().add(agent);
            ObservableList <EnumEstrategia> listaEstrategias = FXCollections.observableArrayList(EnumEstrategia.values());
            this.cbEstrategia.setItems(listaEstrategias);
        }
        catch(Exception e){
        }
    }
    
    /**
     * Agrega un infectado al mapa
     */
    public void agregarInfectado(Integer idEsquina, Double newXPosition, Double newYPosition){
    	ImageView infect = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/infectado.png"));
        infect.setFitWidth(INFECT_IMG_W);
        infect.setFitHeight(INFECT_IMG_H);
        infect.relocate(ORIGEN_X_PX-newXPosition*0.7-INFECT_IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-INFECT_IMG_H);
        this.infectados.put(idEsquina,infect);
        this.panDrawer.getChildren().add(infect);
    }
    
    public void borrarInfectado(Integer idEsquina) {
    	this.panDrawer.getChildren().remove(this.infectados.remove(idEsquina));
    }
    
    public void borrarInfectados() {
    	for(Map.Entry<Integer,ImageView> imgInfectado : infectados.entrySet()) {
    		this.panDrawer.getChildren().remove(imgInfectado.getValue());
    	}
    	infectados.clear();
    }
    
    public void agregarSensor(Integer idEsquina, Double newXPosition, Double newYPosition){
    	if(sensoresActivados.get(idEsquina)!=null)
    		return;
    	
    	ImageView sensorActivo = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/sensor_activado.png"));
    	sensorActivo.setFitWidth(INFECT_IMG_W);
    	sensorActivo.setFitHeight(INFECT_IMG_H);
    	sensorActivo.relocate(ORIGEN_X_PX-newXPosition*0.7-INFECT_IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-INFECT_IMG_H);
        this.sensoresActivados.put(idEsquina,sensorActivo);
        this.panDrawer.getChildren().add(sensorActivo);
    }
    
	public void borrarSensor(int idEsquina) {
		if(sensoresActivados.get(idEsquina)!=null)
			sensoresActivados.get(idEsquina).setImage( new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/sensor_desactivado.png") );
	}
    
    public void agregarCapturado(Integer idEsquina, Double newXPosition, Double newYPosition){
    	if(infectadosAtrapados.get(idEsquina)!=null)
    		return;
    	
        ImageView capturado = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/captured.png"));
        capturado.setFitWidth(IMG_W);
        capturado.setFitHeight(IMG_H);
        capturado.relocate(ORIGEN_X_PX-newXPosition*0.7-IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-IMG_H/2);
        this.infectadosAtrapados.put(idEsquina,capturado);
        this.panDrawer.getChildren().add(capturado);
        this.agent.toFront();	//Hace que el agente quede por encima del capturado
    }
    
    /**
     * Mueve el icono del agente en la simulaciÃ³n
     */
    public void moverAgent(Double newXPosition, Double newYPosition){
        this.agent.relocate((ORIGEN_X_PX-newXPosition*(0.7)-IMG_W/2) , (ORIGEN_Y_PX-newYPosition*(0.7)-IMG_H));
    }
    
    public void pintarBloqueo(Integer esquina1, Integer esquina2, Double newXPosition, Double newYPosition) {
    	ImageView bloqueo = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/bloqueo_desconocido.png"));
    	bloqueo.setFitWidth(IMG_W);
    	bloqueo.setFitHeight(IMG_H);
    	bloqueo.relocate(ORIGEN_X_PX-newXPosition*0.7-IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-IMG_H/2);
        this.bloqueosTotales.put(esquina1*100+esquina2,bloqueo);
        this.panDrawer.getChildren().add(bloqueo);
    }
    
    public void pintarBloqueoConocido(Integer esquina1, Integer esquina2, Double newXPosition, Double newYPosition) {
    	//Quita el bloqueo desconocido para luego poder reemplazarlo por un bloqueo conocido
    	this.panDrawer.getChildren().remove(this.bloqueosTotales.remove(esquina1*100+esquina2));
    	
    	ImageView bloqueo = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/bloqueo.png"));
    	bloqueo.setFitWidth(IMG_W);
    	bloqueo.setFitHeight(IMG_H);
    	bloqueo.relocate(ORIGEN_X_PX-newXPosition*0.7-IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-IMG_H/2);
        this.bloqueosTotales.put(esquina1*100+esquina2,bloqueo);
        this.panDrawer.getChildren().add(bloqueo);
    }
    
    /**Agrega un elemento a la lista de acciones**/
    public void agregarAccionALista(String action) {
    	obsListAcciones.add(new AccionBusqueda(action));
    }
    
    public void pintarYouLose() {
    	ImageView gameOver = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/game_over_lose.gif"));
    	gameOver.relocate(240, 275);
        this.panDrawer.getChildren().add(gameOver);
        ImageView gameOverText = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/game_over_lose_text.png"));
        gameOverText.relocate(500, 175);
        this.panDrawer.getChildren().add(gameOverText);
    }
    
    public void pintarYouWin() {
    	ImageView gameOver = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/game_over_win.png"));
    	gameOver.relocate(314, 275);
        this.panDrawer.getChildren().add(gameOver);
    }
    
    @FXML
    public void testFunction() {
    	obsListAcciones = FXCollections.observableArrayList();
    	tvTablaAcciones.setItems(obsListAcciones);
    	tcAcciones.setCellValueFactory(new PropertyValueFactory <AccionBusqueda, String>("nombre"));
    	
    	//Guarda opciones seleccionadas en la interface
    	if(cbEstrategia.getValue() == null)
    		return;		//Para evitar que se ejecute una estrategia erronea => cancela ejecución
    	GestorConfiguración.estrategia = cbEstrategia.getValue();
    	GestorConfiguración.agregarAleatoriamenteInfectados = cbAgregarInfectRandom.isSelected();
    	GestorConfiguración.desplazamientoAleatorioInfectados = cbInfectMovimRandom.isSelected();
    	
    	//Configura interface
    	btnRunSimulator.setDisable(true);
    	InterfaceUpdater.setSimulacionActual(this);
    	
    	//Comienza la ejecución de la búsqueda en un hilo secundario para no trabar la simulación de la interface
    	thre = new Thread() {
    		public void run() {
    	    	RobotcovidAgent agent = new RobotcovidAgent();

    	        RobotcovidEnvironment environment = new RobotcovidEnvironment();

    	        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
    	        
    	        simulator.start();
    		}
    		
    		@Override
    		public void interrupt() {
    			super.interrupt();
    			System.out.println("Thread interrupted");
    			this.stop();
    		}
    	};
    	
        thre.start();
    }
    
    /***Termina la ejecución del hilo de búsqueda***/
    public static void closeSearchThread() {
    	if(thre!=null) {
    		if(!thre.isAlive())
    			return;
    		
    		//Evita interrumpirlo mientras el hilo está dormido para evitar una exception
    		while(thre.getState()==State.TIMED_WAITING) {
    			
    		}
    		thre.interrupt();
    	}
    }

    /**
     * Esta clase se usa únicamente para agregar elementos a la lista de acciones
     */
    public class AccionBusqueda{
    	public String nombre;
    	
    	public AccionBusqueda() {}
    	
    	public AccionBusqueda(String name) {
    		this.nombre = name;
    	}
    	
    	public String getNombre() {
    		return nombre;
    	}
    	
    	public void setNombre(String str) {
    		nombre = str;
    	}
    }
    
}


