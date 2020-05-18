package utn.ia2020.tp.busquedainfectados.covid;

import frsf.cidisi.faia.state.AgentState;
import utn.ia2020.tp.busquedainfectados.InterfaceUpdater;
import frsf.cidisi.faia.agent.search.GoalTest;

public class RobotcovidGoal extends GoalTest {
	
	@Override
    public boolean isGoalState(AgentState agentState) {
        return (((RobotcovidAgentState) agentState).getListaInfectados().size() == 0); 
    }
}
