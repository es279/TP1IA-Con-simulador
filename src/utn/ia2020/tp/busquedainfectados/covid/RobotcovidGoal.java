package utn.ia2020.tp.busquedainfectados.covid;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.agent.search.GoalTest;

public class RobotcovidGoal extends GoalTest {
	
	@Override
    public boolean isGoalState(AgentState agentState) {
        // Agent reach the goal if it is in...
//        if (((RobotcovidAgentState) agentState).getPosition().equals("5")) {
//            return true;
//        }
//        return false;
		
//            return (((RobotcovidAgentState) agentState).getEnBusqueda() == false || ((RobotcovidAgentState) agentState).getPosition().equals("20"));
  
//			  return (((RobotcovidAgentState) agentState).getEnBusqueda() == false ||  ((RobotcovidAgentState) agentState).getPosition().equals("27"));
			  return (((RobotcovidAgentState) agentState).getListaInfectados().size() == 0);
    }
}
