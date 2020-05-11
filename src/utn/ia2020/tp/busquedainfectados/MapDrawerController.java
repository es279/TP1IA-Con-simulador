/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.ia2020.tp.busquedainfectados;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    
    final int AGENT_IMG_H = 54;
    final int AGENT_IMG_W = 54;
    final int INFECT_IMG_H = 44;
    final int INFECT_IMG_W = 44;
    final int CAPTURED_IMG_H = 54;
    final int CAPTURED_IMG_W = 54;
    final int BLOQUEO_IMG_H = 54;
    final int BLOQUEO_IMG_W = 54;
    
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
            this.agent.setFitWidth(AGENT_IMG_W);
            this.agent.setFitHeight(AGENT_IMG_H);
            this.moverAgent(0.0, 0.0);
            this.panDrawer.getChildren().add(agent);
        }
        catch(Exception e){
            //TODO: mostrar ventana advirtiendo que no se encontrÃ³ la imagen del agente
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
    	//TODO modificar constantes
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
        capturado.setFitWidth(CAPTURED_IMG_W);
        capturado.setFitHeight(CAPTURED_IMG_H);
        capturado.relocate(ORIGEN_X_PX-newXPosition*0.7-CAPTURED_IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-CAPTURED_IMG_H/2);
        this.infectadosAtrapados.put(idEsquina,capturado);
        this.panDrawer.getChildren().add(capturado);
        this.agent.toFront();	//Hace que el agente quede por encima del capturado
    }
    
    /**
     * Mueve el icono del agente en la simulaciÃ³n
     */
    public void moverAgent(Double newXPosition, Double newYPosition){
        //TODO: verificar que no sea menos de 0 (que no se salgan fuera de la pantalla)
        this.agent.relocate((ORIGEN_X_PX-newXPosition*(0.7)-AGENT_IMG_W/2) , (ORIGEN_Y_PX-newYPosition*(0.7)-AGENT_IMG_H));
    }
    
    public void pintarBloqueo(Integer esquina1, Integer esquina2, Double newXPosition, Double newYPosition) {
    	ImageView bloqueo = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/car.png"));
    	bloqueo.setFitWidth(BLOQUEO_IMG_W);
    	bloqueo.setFitHeight(BLOQUEO_IMG_H);
    	bloqueo.relocate(ORIGEN_X_PX-newXPosition*0.7-BLOQUEO_IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-BLOQUEO_IMG_H/2);
        this.bloqueosTotales.put(esquina1*100+esquina2,bloqueo);
        this.panDrawer.getChildren().add(bloqueo);
    }
    
    public void pintarBloqueoConocido(Integer esquina1, Integer esquina2, Double newXPosition, Double newYPosition) {
    	//Quita el bloqueo desconocido para luego poder reemplazarlo por un bloqueo conocido
    	this.panDrawer.getChildren().remove(this.bloqueosTotales.remove(esquina1*100+esquina2));
    	
    	ImageView bloqueo = new ImageView(new Image("File:src/utn/ia2020/tp/busquedainfectados/resources/bloqueo.png"));
    	bloqueo.setFitWidth(BLOQUEO_IMG_W);
    	bloqueo.setFitHeight(BLOQUEO_IMG_H);
    	bloqueo.relocate(ORIGEN_X_PX-newXPosition*0.7-BLOQUEO_IMG_W/2, ORIGEN_Y_PX-newYPosition*0.7-BLOQUEO_IMG_H/2);
        this.bloqueosTotales.put(esquina1*100+esquina2,bloqueo);
        this.panDrawer.getChildren().add(bloqueo);
    }
    
    
    
    @FXML
    public void testFunction() {
    	InterfaceUpdater.setSimulacionActual(this);
    	
    	//Comienza la ejecución de la búsqueda en un hilo secundario para no trabar la simulación de la interface
    	Thread thre = new Thread() {
    		public void run() {
    	    	RobotcovidAgent agent = new RobotcovidAgent();

    	        RobotcovidEnvironment environment = new RobotcovidEnvironment();

    	        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
    	        
    	        simulator.start();
    		}
    	};
        thre.start();
    }
    
    private int cont=0;
    @FXML
    public void atestFunction() {
        //try{
        switch(cont){
            case 0:
                agregarInfectado(1,228.0, 1034.0);
                break;
            case 1:
                moverAgent(108.0, 0.0);
                break;
            case 2:
                moverAgent(108.0, 110.0);
                break;
            case 3:
                moverAgent(107.0, 208.0);
                break;
            case 4:
                moverAgent(210.0, 210.0);
                borrarInfectados();
                agregarInfectado(1,226.0, 939.0);
                break;
        }
        cont++;
        /*}
        catch(InterruptedException e){
            System.out.println("Y se marchÃ³!");
        }*/
    }
}
