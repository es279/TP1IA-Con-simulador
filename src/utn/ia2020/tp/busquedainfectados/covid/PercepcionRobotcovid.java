package utn.ia2020.tp.busquedainfectados.covid;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionRobotcovid extends Perception {
	
	public PercepcionRobotcovid() {
    }

    public PercepcionRobotcovid(Agent agent, Environment environment) {
        super(agent, environment);
    }
	
	//Lista de bloqueos de la posición actual
		public ArrayList<Integer[]> listaBloquosPosicionActual = new ArrayList<Integer[]>();

	@Override
	public void initPerception(Agent agent, Environment environment) {
		RobotcovidEnvironment ambiente = (RobotcovidEnvironment) environment;
		
		this.setListaBloquosPosicionActual(ambiente.getListaBloqueosActuales());
	}

	public ArrayList<Integer[]> getListaBloquosPosicionActual() {
		return listaBloquosPosicionActual;
	}

	public void setListaBloquosPosicionActual(ArrayList<Integer[]> listaBloquosPosicion) {
		this.listaBloquosPosicionActual.addAll(listaBloquosPosicion);
	}
	
}
