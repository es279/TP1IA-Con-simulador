package utn.ia2020.tp.busquedainfectados.covid;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class RobotcovidMain {
	
	 public static void main(String[] args) throws PrologConnectorException {
	        RobotcovidAgent agent = new RobotcovidAgent();

	        RobotcovidEnvironment environment = new RobotcovidEnvironment();

	        SearchBasedAgentSimulator simulator =
	                new SearchBasedAgentSimulator(environment, agent);
	        
	        simulator.start();
	    }
}
