package utn.ia2020.tp.busquedainfectados.covid;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class RobotcovidEnvironment extends Environment {

    public RobotcovidEnvironment() {
        this.environmentState = new RobotcovidEnvironmentState();
    }

    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public Perception getPercept() {
    	PercepcionRobotcovid p = new PercepcionRobotcovid();
    	
    	p.setListaBloquosPosicionActual(this.getListaBloqueosActuales());

        //Retorna la nueva percepción creada
        return p;
    }
    
    public ArrayList<Integer[]> getListaBloqueosActuales() {
        return ((RobotcovidEnvironmentState) this.getEnvironmentState()).getBloqueosPosicionActual();
    }
}
