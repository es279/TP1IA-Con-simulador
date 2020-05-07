package utn.ia2020.tp.busquedainfectados.covid;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class RobotcovidEnvironment extends Environment {

    public RobotcovidEnvironment() {
        // Create the environment state
        this.environmentState = new RobotcovidEnvironmentState();
    }

    @Override
    public String toString() {
        return "";
    }
    
    public ArrayList<Integer[]> getListaBloqueosActuales() {
    	System.out.println("Soy un "+this.getEnvironmentState()+" ajsdlakjsdlakndlaksdlaksd");
        return ((RobotcovidEnvironmentState) this.getEnvironmentState()).getBloqueosPosicionActual();
    }
    
    @Override
    public Perception getPercept() {
    	
    	PercepcionRobotcovid p = new PercepcionRobotcovid();
    	
    	p.setListaBloquosPosicionActual(this.getListaBloqueosActuales());
    	
        //		 El ambiente crea una percepción que va a ser recibida por el Snake.- 
/***    	PercepcionSnake p = new PercepcionSnake();***/

        // Es necesario realizar un "cast" para acceder a los métodos del agente Snake.- 
        //AgenteSnake snake = (AgenteCalculus)agent;

        // Asigna las percepciones en los sensores.-
/***        p.setSensorNorte(this.getNorte());
        p.setSensorOeste(this.getOeste());
        p.setSensorEste(this.getEste());
        p.setSensorSur(this.getSur());***/

        // Retorna la nueva percepción creada.-
        return p;
    }
    
}
