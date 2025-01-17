package utn.ia2020.tp.busquedainfectados.covid;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class RobotcovidStepCost implements IStepCostFunction {

	public RobotcovidStepCost() {
		super();
	}
	
	@Override
	public double calculateCost(NTree node) {
		String accion = node.getAction().toString();
	
		if(accion.equals("capturarInfectado"))
			return 0.0;
		
		CostFunction cost = new CostFunction();
		return cost.calculateCost(node);
	}

}
