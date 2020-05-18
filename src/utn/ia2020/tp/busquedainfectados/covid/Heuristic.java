package utn.ia2020.tp.busquedainfectados.covid;

import java.util.ArrayList;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction {
	
    @Override
    public double getEstimatedCost(NTree node) {
    	ArrayList<Integer> listaInfectados = ((RobotcovidAgentState) node.getAgentState()).getListaInfectados();
    	Integer posicionAgente = Integer.parseInt(((RobotcovidAgentState) node.getAgentState()).getPosition());
    	int heuristica = 0;
    	
    	int xInfec;
    	int yInfec;
    	
    	int xAgente = RobotcovidEnvironmentState.listaEsquinas.get(posicionAgente).getxEsquina();
    	int yAgente = RobotcovidEnvironmentState.listaEsquinas.get(posicionAgente).getyEsquina();
    	
    	for(Integer posicionInfectado : listaInfectados) {
    		xInfec = RobotcovidEnvironmentState.listaEsquinas.get(posicionInfectado).getxEsquina();
    		yInfec = RobotcovidEnvironmentState.listaEsquinas.get(posicionInfectado).getyEsquina();
    		
    		heuristica += Math.abs(xAgente-xInfec)+Math.abs(yAgente-yInfec);
    	}
    	
    	return heuristica;
    }
}
