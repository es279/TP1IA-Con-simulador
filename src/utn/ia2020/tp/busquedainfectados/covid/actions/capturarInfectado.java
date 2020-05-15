package utn.ia2020.tp.busquedainfectados.covid.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import utn.ia2020.tp.busquedainfectados.InterfaceUpdater;
import utn.ia2020.tp.busquedainfectados.covid.Esquina;
import utn.ia2020.tp.busquedainfectados.covid.RobotcovidAgentState;
import utn.ia2020.tp.busquedainfectados.covid.RobotcovidEnvironmentState;

public class capturarInfectado extends SearchAction {
	

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
    	RobotcovidAgentState agentState = (RobotcovidAgentState) s;

        String posicionAgente = agentState.getPosition();

        /* Solo es posible capturar a un infectado si este se encuentra en la misma
         * posición que el agente. Si es así, saco el id de la esquina de la lista de infectados8*/
        
        if(agentState.getListaInfectados().contains(Integer.parseInt(posicionAgente))) {
        	Integer indiceEsquinaInfectado = agentState.getListaInfectados().indexOf(Integer.parseInt(posicionAgente));
        	
        	agentState.eliminarInfectado(indiceEsquinaInfectado);
        	
        	if(agentState.getListaInfectados().isEmpty()) {

        		agentState.setEnBusqueda(false);
        	}
        	
        	return agentState;
        }
        
        return null;

        /*//Referencia
        if (pacmanState.getWorld()[row][col] == PacmanPerception.FOOD_PERCEPTION) {
            // If the action is Eat, then the actual position has no more food.
            pacmanState.setWorldPosition(row, col, PacmanPerception.EMPTY_PERCEPTION);
            return pacmanState;
        }
        
        return null;*/
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    	RobotcovidAgentState agentState = (RobotcovidAgentState) ast;
    	RobotcovidEnvironmentState environmentState = (RobotcovidEnvironmentState) est;

        String posicionAgente = agentState.getPosition();
        
        /* Solo es posible capturar a un infectado si este se encuentra en la misma
         * posición que el agente. Si es así, saco el id de la esquina de la lista de infectados8*/
        
        // TODO Notar que acá me fijo si me encuentro en la misma posición que un infectado según la lista del entorno, y saco
        // 		esa información tanto de la lista del entorno como de la del infectado. No sé si eso puede traer problemas
        //		(traería problemas si las listas no son iguales)
        
        if(agentState.getListaInfectados().contains(Integer.parseInt(posicionAgente))) {
        	Integer indiceEsquinaInfectado = agentState.getListaInfectados().indexOf(Integer.parseInt(posicionAgente));
        	agentState.getListaInfectados().remove(indiceEsquinaInfectado);
        	
        	//TODO remover infectado de la lista de RobotcovidEnvironmentState

        	agentState.eliminarInfectado(indiceEsquinaInfectado);
        	environmentState.eliminarInfectado(indiceEsquinaInfectado);
        	
        	//Si el infectado capturado estaba en uno de los sensores, entonces se debe descontar ese sensor de la cantidad de sensores activos
        	if(indiceEsquinaInfectado < RobotcovidAgentState.CANTIDAD_SENSORES) {
        		RobotcovidAgentState.CANTIDAD_SENSORES--;
        		
        		//TODO: Interface. Quita el infectado del sensor de la simulación grafica
	        	Esquina esquinaActual = RobotcovidAgentState.listaEsq.get(Integer.parseInt(agentState.getPosition()));
	        	InterfaceUpdater.borrarSensor(esquinaActual);
        	}
        	else {
        		//TODO: Interface. Quita el infectado de la esquina de la simulación grafica
	        	Esquina esquinaActual = RobotcovidAgentState.listaEsq.get(Integer.parseInt(agentState.getPosition()));
	        	InterfaceUpdater.borrarInfectado(esquinaActual);
	        	InterfaceUpdater.agregarCapturado(esquinaActual);
        	}
        	
        	
        	if(agentState.getListaInfectados().isEmpty()) {
        		InterfaceUpdater.agregarGameOver(true);
        		agentState.setEnBusqueda(false);
        	}
        	
        	return environmentState;
        }
        
        return null;

        /*//Referencia
        if (pacmanState.getWorld()[row][col] == PacmanPerception.FOOD_PERCEPTION) {
            // If the action is Eat, then the actual position has no more food.
            pacmanState.setWorldPosition(row, col, PacmanPerception.EMPTY_PERCEPTION);
            return pacmanState;
        }
        
        return null;*/
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        //return new Double(0);
    	return  100.0;
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "capturarInfectado";
    }
	
}
