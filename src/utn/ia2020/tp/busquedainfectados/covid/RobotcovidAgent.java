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
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
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
//        actions.addElement(new irSiguienteEsquina("37"));
//        actions.addElement(new irSiguienteEsquina("38"));
//        actions.addElement(new irSiguienteEsquina("39"));
//        actions.addElement(new irSiguienteEsquina("40"));
//        actions.addElement(new irSiguienteEsquina("41"));
//        actions.addElement(new irSiguienteEsquina("42"));
//        actions.addElement(new irSiguienteEsquina("43"));
//        actions.addElement(new irSiguienteEsquina("44"));
//        actions.addElement(new irSiguienteEsquina("45"));
//        actions.addElement(new irSiguienteEsquina("46"));
//        actions.addElement(new irSiguienteEsquina("47"));
//        actions.addElement(new irSiguienteEsquina("48"));
//        actions.addElement(new irSiguienteEsquina("49"));
//        
//        actions.addElement(new irSiguienteEsquina("50"));
//        actions.addElement(new irSiguienteEsquina("51"));
//        actions.addElement(new irSiguienteEsquina("52"));
//        actions.addElement(new irSiguienteEsquina("53"));
//        actions.addElement(new irSiguienteEsquina("54"));
//        actions.addElement(new irSiguienteEsquina("55"));
//        actions.addElement(new irSiguienteEsquina("56"));
//        actions.addElement(new irSiguienteEsquina("57"));
//        actions.addElement(new irSiguienteEsquina("58"));
//        actions.addElement(new irSiguienteEsquina("59"));
//        
//        actions.addElement(new irSiguienteEsquina("60"));
//        actions.addElement(new irSiguienteEsquina("61"));
//        actions.addElement(new irSiguienteEsquina("62"));
//        actions.addElement(new irSiguienteEsquina("63"));
//        actions.addElement(new irSiguienteEsquina("64"));
//        actions.addElement(new irSiguienteEsquina("65"));
//        actions.addElement(new irSiguienteEsquina("66"));
//        actions.addElement(new irSiguienteEsquina("67"));
//        actions.addElement(new irSiguienteEsquina("68"));
//        actions.addElement(new irSiguienteEsquina("69"));
//        
//        actions.addElement(new irSiguienteEsquina("70"));
//        actions.addElement(new irSiguienteEsquina("71"));
//        actions.addElement(new irSiguienteEsquina("72"));
//        actions.addElement(new irSiguienteEsquina("73"));
//        actions.addElement(new irSiguienteEsquina("74"));
//        actions.addElement(new irSiguienteEsquina("75"));
//        actions.addElement(new irSiguienteEsquina("76"));
//        actions.addElement(new irSiguienteEsquina("77"));
//        actions.addElement(new irSiguienteEsquina("78"));
//        actions.addElement(new irSiguienteEsquina("79"));
//        
//        actions.addElement(new irSiguienteEsquina("80"));
//        actions.addElement(new irSiguienteEsquina("81"));
//        actions.addElement(new irSiguienteEsquina("82"));
//        actions.addElement(new irSiguienteEsquina("83"));
//        actions.addElement(new irSiguienteEsquina("84"));
//        actions.addElement(new irSiguienteEsquina("85"));
//        actions.addElement(new irSiguienteEsquina("86"));
//        actions.addElement(new irSiguienteEsquina("87"));
//        actions.addElement(new irSiguienteEsquina("88"));
//        actions.addElement(new irSiguienteEsquina("89"));
//        
//        actions.addElement(new irSiguienteEsquina("90"));
//        actions.addElement(new irSiguienteEsquina("91"));
//        actions.addElement(new irSiguienteEsquina("92"));
//        actions.addElement(new irSiguienteEsquina("93"));
//        actions.addElement(new irSiguienteEsquina("94"));
//        actions.addElement(new irSiguienteEsquina("95"));
//        actions.addElement(new irSiguienteEsquina("96"));
//        actions.addElement(new irSiguienteEsquina("97"));
//        actions.addElement(new irSiguienteEsquina("98"));
//        actions.addElement(new irSiguienteEsquina("99"));
//        
//        actions.addElement(new irSiguienteEsquina("100"));
//        actions.addElement(new irSiguienteEsquina("101"));
//        actions.addElement(new irSiguienteEsquina("102"));
//        actions.addElement(new irSiguienteEsquina("103"));
//        actions.addElement(new irSiguienteEsquina("104"));
//        actions.addElement(new irSiguienteEsquina("105"));
//        actions.addElement(new irSiguienteEsquina("106"));
//        actions.addElement(new irSiguienteEsquina("107"));
//        actions.addElement(new irSiguienteEsquina("108"));
//        actions.addElement(new irSiguienteEsquina("109"));
//        
//        actions.addElement(new irSiguienteEsquina("110"));
//        actions.addElement(new irSiguienteEsquina("111"));
//        actions.addElement(new irSiguienteEsquina("112"));
//        actions.addElement(new irSiguienteEsquina("113"));
//        actions.addElement(new irSiguienteEsquina("114"));
//        actions.addElement(new irSiguienteEsquina("115"));
//        actions.addElement(new irSiguienteEsquina("116"));
//        actions.addElement(new irSiguienteEsquina("117"));
//        actions.addElement(new irSiguienteEsquina("118"));
//        actions.addElement(new irSiguienteEsquina("119"));
//        
//        actions.addElement(new irSiguienteEsquina("120"));
//        actions.addElement(new irSiguienteEsquina("121"));
//        actions.addElement(new irSiguienteEsquina("122"));
//        actions.addElement(new irSiguienteEsquina("123"));
//        actions.addElement(new irSiguienteEsquina("124"));
//        actions.addElement(new irSiguienteEsquina("125"));
//        actions.addElement(new irSiguienteEsquina("126"));
//        actions.addElement(new irSiguienteEsquina("127"));
//        actions.addElement(new irSiguienteEsquina("128"));
//        actions.addElement(new irSiguienteEsquina("129"));
//        
//        actions.addElement(new irSiguienteEsquina("130"));
//        actions.addElement(new irSiguienteEsquina("131"));
//        actions.addElement(new irSiguienteEsquina("132"));
//        actions.addElement(new irSiguienteEsquina("133"));
//        actions.addElement(new irSiguienteEsquina("134"));
//        actions.addElement(new irSiguienteEsquina("135"));
//        actions.addElement(new irSiguienteEsquina("136"));
//        actions.addElement(new irSiguienteEsquina("137"));
//        actions.addElement(new irSiguienteEsquina("138"));
//        actions.addElement(new irSiguienteEsquina("139"));
//        
//        actions.addElement(new irSiguienteEsquina("140"));
//        actions.addElement(new irSiguienteEsquina("141"));
//        actions.addElement(new irSiguienteEsquina("142"));
//        actions.addElement(new irSiguienteEsquina("143"));
//        actions.addElement(new irSiguienteEsquina("144"));
//        actions.addElement(new irSiguienteEsquina("145"));
//        actions.addElement(new irSiguienteEsquina("146"));
//        actions.addElement(new irSiguienteEsquina("147"));
//        actions.addElement(new irSiguienteEsquina("148"));
//        actions.addElement(new irSiguienteEsquina("149"));
//        
//        actions.addElement(new irSiguienteEsquina("150"));
//        actions.addElement(new irSiguienteEsquina("151"));
//        actions.addElement(new irSiguienteEsquina("152"));
//        actions.addElement(new irSiguienteEsquina("153"));
//        actions.addElement(new irSiguienteEsquina("154"));
//        actions.addElement(new irSiguienteEsquina("155"));
//        actions.addElement(new irSiguienteEsquina("156"));
//        actions.addElement(new irSiguienteEsquina("157"));
//        actions.addElement(new irSiguienteEsquina("158"));
//        actions.addElement(new irSiguienteEsquina("159"));
//        
//        actions.addElement(new irSiguienteEsquina("160"));

        // Robot agent problem
        Problem problem = new Problem(goal, agentState, actions);
        this.setProblem(problem);
    }

    @Override
    public Action selectAction() {
        // Breath first strategy
    	//Si no funciona, devolver próxima línea
/*        BreathFirstSearch searchStrategy = new BreathFirstSearch();*/
//        DepthFirstSearch searchStrategy = new DepthFirstSearch();
//        Search searchSolver = new Search(searchStrategy);
    	
    	//A Star Search:
            IStepCostFunction cost = new CostFunction();
            IEstimatedCostFunction heuristic = new Heuristic();
            AStarSearch strategy = new AStarSearch(cost, heuristic);
            Search searchSolver = new Search(strategy);

        // Set the search tree to be written in an XML file
        searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);

        // Set the search solver
        this.setSolver(searchSolver);

        // Run the actions selection process
        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(RobotcovidAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }

    @Override
    public void see(Perception perception) {
        this.getAgentState().updateState(perception);
    }
}
