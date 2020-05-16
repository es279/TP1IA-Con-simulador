package utn.ia2020.tp.busquedainfectados.covid.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import utn.ia2020.tp.busquedainfectados.InterfaceUpdater;
import utn.ia2020.tp.busquedainfectados.covid.*;

public class irEsquina extends SearchAction {
	protected Integer ID_ESQUINA = -1;
	protected String IDENTIFICADOR_ESQ = "-1";
	
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        RobotcovidAgentState agentState = (RobotcovidAgentState) s;
        
        if(agentState.getLastPosition().equals(IDENTIFICADOR_ESQ)) {
        	return null;
        }
        
//        //Verificamos que no esté pasando por un tramo ya recorrido
//        for(String[] tramo : agentState.getTramosRecorridos()) {
//        	if(tramo[0].equals(agentState.getPosition()) && tramo[1].equals(IDENTIFICADOR_ESQ)) {
//        		return null;
//        	}
//        }
        
        
        /////////////////////////////////////////////////////////////////
        //Verifico que no haya bloqueo conocido entre el inicio y fin del camino (posición actual y siguiente)
        //si hay bloqueo, no se puede pasar --> retorno null
        Integer inicioCamino =Integer.parseInt(agentState.getPosition());
        Integer finalCamino = ID_ESQUINA;
        
        for(Integer[] elementoActual : agentState.getListaBloqueosConocidos()) {
        	if((elementoActual[0]==inicioCamino && elementoActual[1]==finalCamino) || ((elementoActual[0]==finalCamino && elementoActual[1]==inicioCamino))) {
        		return null;
        	}
        }
        
        /////////////////////////////////////////////////////////////////
        
        
        ArrayList<String> successors = new ArrayList<String>(agentState.getSuccessors());
        if (successors != null) {
            int index = successors.indexOf(IDENTIFICADOR_ESQ);
            if (index >= 0) {
            	agentState.setLastPosition(agentState.getPosition());
                agentState.setPosition(IDENTIFICADOR_ESQ);
                return agentState;
            }

        }

        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
//        this.execute((SearchBasedAgentState) ast);
//
//        return null;
    	RobotcovidAgentState agentState = (RobotcovidAgentState) ast;
    	RobotcovidEnvironmentState environmentState = (RobotcovidEnvironmentState) est;
    	
    	
    	//Añade nuevo infectado con una probabilidad de RobotcovidAgentState.PROBABILIDAD_NUEVO_INFECTADO
		agentState.randomNuevoInfectado(environmentState);
    	
    	RobotcovidAgentState.contadorDePasos++;
    	if(RobotcovidAgentState.contadorDePasos == RobotcovidAgentState.FRECUENCIA_DESP_INFECT) {
    		agentState.randomPosicionInfectados();
    		RobotcovidAgentState.contadorDePasos = 0;
    		//TODO: Interface.
    		InterfaceUpdater.repaintUbicacionInfectados(agentState.listaInfectados);
    	}
    	System.out.println(",amsndlasnd"+est.toString());
    	
        ArrayList<String> successors = new ArrayList<String>(agentState.getSuccessors());
        if (successors != null) {
            int index = successors.indexOf(IDENTIFICADOR_ESQ);
            if (index >= 0) {
            	agentState.setLastPosition(agentState.getPosition());
                agentState.setPosition(IDENTIFICADOR_ESQ);
                environmentState.setAgentPosition(IDENTIFICADOR_ESQ);
                
                //TODO: Interface.
                Integer indice = Integer.parseInt(agentState.getPosition());
                InterfaceUpdater.actualizarUbicacionAgete(RobotcovidAgentState.listaEsq.get(indice));
                /*try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

                
                return est;
            }

        }

        return null;
        
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "GoEsquina" + IDENTIFICADOR_ESQ;
    }
}
