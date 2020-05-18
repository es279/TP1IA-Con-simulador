package utn.ia2020.tp.busquedainfectados.covid;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;
import utn.ia2020.tp.busquedainfectados.GestorConfiguración;
import utn.ia2020.tp.busquedainfectados.InterfaceUpdater;
import utn.ia2020.tp.busquedainfectados.covid.actions.*;

public class RobotcovidAgent extends SearchBasedAgent {


    public RobotcovidAgent() {
        // Robot agent goal
        RobotcovidGoal goal = new RobotcovidGoal();

        // Robot agent state
        RobotcovidAgentState agentState = new RobotcovidAgentState();
        this.setAgentState(agentState);

        // Robot agent actions
        Vector<SearchAction> actions = new Vector<SearchAction>();
        
        //Acciones del agente
        actions.addElement(new capturarInfectado());
        

        actions.addElement(new irEsquina0());
        actions.addElement(new irEsquina1());
        actions.addElement(new irEsquina2());
        actions.addElement(new irEsquina3());
        actions.addElement(new irEsquina4());
        actions.addElement(new irEsquina5());
        actions.addElement(new irEsquina6());
        actions.addElement(new irEsquina7());
        actions.addElement(new irEsquina8());
        actions.addElement(new irEsquina9());
        actions.addElement(new irEsquina10());
        actions.addElement(new irEsquina11());
        actions.addElement(new irEsquina12());
        actions.addElement(new irEsquina13());
        actions.addElement(new irEsquina14());
        actions.addElement(new irEsquina15());
        actions.addElement(new irEsquina16());
        actions.addElement(new irEsquina17());
        actions.addElement(new irEsquina18());
        actions.addElement(new irEsquina19());
        actions.addElement(new irEsquina20());
        actions.addElement(new irEsquina21());
        actions.addElement(new irEsquina22());
        actions.addElement(new irEsquina23());
        actions.addElement(new irEsquina24());
        actions.addElement(new irEsquina25());
        actions.addElement(new irEsquina26());
        actions.addElement(new irEsquina27());
        actions.addElement(new irEsquina28());
        actions.addElement(new irEsquina29());
        actions.addElement(new irEsquina30());
        actions.addElement(new irEsquina31());
        actions.addElement(new irEsquina32());
        actions.addElement(new irEsquina33());
        actions.addElement(new irEsquina34());
        actions.addElement(new irEsquina35());
        actions.addElement(new irEsquina36());
        actions.addElement(new irEsquina37());
        actions.addElement(new irEsquina38());
        actions.addElement(new irEsquina39());
        actions.addElement(new irEsquina40());
        actions.addElement(new irEsquina41());
        actions.addElement(new irEsquina42());
        actions.addElement(new irEsquina43());
        actions.addElement(new irEsquina44());
        actions.addElement(new irEsquina45());
        actions.addElement(new irEsquina46());
        actions.addElement(new irEsquina47());
        actions.addElement(new irEsquina48());
        actions.addElement(new irEsquina49());
        
        actions.addElement(new irEsquina50());
        actions.addElement(new irEsquina51());
        actions.addElement(new irEsquina52());
        actions.addElement(new irEsquina53());
        actions.addElement(new irEsquina54());
        actions.addElement(new irEsquina55());
        actions.addElement(new irEsquina56());
        actions.addElement(new irEsquina57());
        actions.addElement(new irEsquina58());
        actions.addElement(new irEsquina59());
//        
        actions.addElement(new irEsquina60());
        actions.addElement(new irEsquina61());
        actions.addElement(new irEsquina62());
        actions.addElement(new irEsquina63());
        actions.addElement(new irEsquina64());
        actions.addElement(new irEsquina65());
        actions.addElement(new irEsquina66());
        actions.addElement(new irEsquina67());
        actions.addElement(new irEsquina68());
        actions.addElement(new irEsquina69());
//        
        actions.addElement(new irEsquina70());
        actions.addElement(new irEsquina71());
        actions.addElement(new irEsquina72());
        actions.addElement(new irEsquina73());
        actions.addElement(new irEsquina74());
        actions.addElement(new irEsquina75());
        actions.addElement(new irEsquina76());
        actions.addElement(new irEsquina77());
        actions.addElement(new irEsquina78());
        actions.addElement(new irEsquina79());
//        
        actions.addElement(new irEsquina80());
        actions.addElement(new irEsquina81());
        actions.addElement(new irEsquina82());
        actions.addElement(new irEsquina83());
        actions.addElement(new irEsquina84());
        actions.addElement(new irEsquina85());
        actions.addElement(new irEsquina86());
        actions.addElement(new irEsquina87());
        actions.addElement(new irEsquina88());
        actions.addElement(new irEsquina89());
//        
        actions.addElement(new irEsquina90());
        actions.addElement(new irEsquina91());
        actions.addElement(new irEsquina92());
        actions.addElement(new irEsquina93());
        actions.addElement(new irEsquina94());
        actions.addElement(new irEsquina95());
        actions.addElement(new irEsquina96());
        actions.addElement(new irEsquina97());
        actions.addElement(new irEsquina98());
        actions.addElement(new irEsquina99());
//        
        actions.addElement(new irEsquina100());
        actions.addElement(new irEsquina101());
        actions.addElement(new irEsquina102());
        actions.addElement(new irEsquina103());
        actions.addElement(new irEsquina104());
        actions.addElement(new irEsquina105());
        actions.addElement(new irEsquina106());
        actions.addElement(new irEsquina107());
        actions.addElement(new irEsquina108());
        actions.addElement(new irEsquina109());
//        
        actions.addElement(new irEsquina110());
        actions.addElement(new irEsquina111());
        actions.addElement(new irEsquina112());
        actions.addElement(new irEsquina113());
        actions.addElement(new irEsquina114());
        actions.addElement(new irEsquina115());
        actions.addElement(new irEsquina116());
        actions.addElement(new irEsquina117());
        actions.addElement(new irEsquina118());
        actions.addElement(new irEsquina119());
//        
        actions.addElement(new irEsquina120());
        actions.addElement(new irEsquina121());
        actions.addElement(new irEsquina122());
        actions.addElement(new irEsquina123());
        actions.addElement(new irEsquina124());
        actions.addElement(new irEsquina125());
        actions.addElement(new irEsquina126());
        actions.addElement(new irEsquina127());
        actions.addElement(new irEsquina128());
        actions.addElement(new irEsquina129());
//        
        actions.addElement(new irEsquina130());
        actions.addElement(new irEsquina131());
        actions.addElement(new irEsquina132());
        actions.addElement(new irEsquina133());
        actions.addElement(new irEsquina134());
        actions.addElement(new irEsquina135());
        actions.addElement(new irEsquina136());
        actions.addElement(new irEsquina137());
        actions.addElement(new irEsquina138());
        actions.addElement(new irEsquina139());
//        
        actions.addElement(new irEsquina140());
        actions.addElement(new irEsquina141());
        actions.addElement(new irEsquina142());
        actions.addElement(new irEsquina143());
        actions.addElement(new irEsquina144());
        actions.addElement(new irEsquina145());
        actions.addElement(new irEsquina146());
        actions.addElement(new irEsquina147());
        actions.addElement(new irEsquina148());
        actions.addElement(new irEsquina149());
//        
        actions.addElement(new irEsquina150());
        actions.addElement(new irEsquina151());
        actions.addElement(new irEsquina152());
        actions.addElement(new irEsquina153());
        actions.addElement(new irEsquina154());
        actions.addElement(new irEsquina155());
        actions.addElement(new irEsquina156());
        actions.addElement(new irEsquina157());
        actions.addElement(new irEsquina158());
        actions.addElement(new irEsquina159());
//        
        actions.addElement(new irEsquina160());

        // Robot agent problem
        Problem problem = new Problem(goal, agentState, actions);
        this.setProblem(problem);
    }

    @Override
    public Action selectAction() {
    	//La estrategia se elige en la interface
    	Search searchSolver;
    	switch(GestorConfiguración.estrategia) {
    		case AMPLITUD:
    			// Breath first strategy (búsqueda en amplitud)
    			BreathFirstSearch searchStrategy1 = new BreathFirstSearch();
    			searchSolver = new Search(searchStrategy1);
    			break;
    		case COSTO_UNIFORME:
    			// Uniform cost strategy (búsqueda de costo uniforme)
    			IStepCostFunction stepCost = new RobotcovidStepCost();
    			UniformCostSearch searchStrategy2 = new UniformCostSearch(stepCost);
    			searchSolver = new Search(searchStrategy2);
    			break;
    		case PROFUNDIDAD:
    			// Depth first strategy (búsqueda en profundidad)
    			DepthFirstSearch searchStrategy3 = new DepthFirstSearch();
    			searchSolver = new Search(searchStrategy3);
    			break;
    		case ASTAR:
    		default:
    			//A Star Search (is default):
    			IStepCostFunction cost = new CostFunction();
                IEstimatedCostFunction heuristic = new Heuristic();
                AStarSearch searchStrategy4 = new AStarSearch(cost, heuristic);
                searchSolver = new Search(searchStrategy4);
                break;
    	}        

    	
        // Set the search tree to be written in an XML file
        searchSolver.setVisibleTree(Search.XML_TREE);

        // Set the search solver
        this.setSolver(searchSolver);

        // Run the actions selection process
        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(RobotcovidAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Si no se encuentra la solución => muestra por pantalla
        if(selectedAction==null) {
        	InterfaceUpdater.agregarGameOver(false);
        }
        else if((selectedAction instanceof irEsquina) || (selectedAction instanceof capturarInfectado)) {
        	InterfaceUpdater.agregarAccionALista(selectedAction.toString());
        }
        
        // Return the selected action
        return selectedAction;
    }

    //Recibe la percepción por parte del simulador
    @Override
    public void see(Perception perception) {
        this.getAgentState().updateState(perception);
    }
}
