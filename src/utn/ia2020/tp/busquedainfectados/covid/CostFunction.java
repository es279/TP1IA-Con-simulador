package utn.ia2020.tp.busquedainfectados.covid;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
    	
//    	System.out.println("/////////");
    	String accion = node.getAction().toString();
//    	System.out.println("Acción: "+accion);
    	
    	if(accion.equals("capturarInfectado")) {
    		return 0.0;
    	}
    	
//    	System.out.println("Inicio---------------------------");
    	
    	int x0=0;
    	int y0=0;
    	int x1=0;
    	int y1=0;
    	int x2=0;
    	int y2=0;
    	
    	int costo = 0;
    	
    	int esquina0 = -10;
    	int esquina1 = -10;
    	int esquina2 = -10;
    	
    	//Verifica que el nodo padre no sea nulo
    	if(node.getParent().getAction() != null  && node.getParent().getAction() != null) {
    		String accionPadre = node.getParent().getAction().toString();
//        	System.out.println("Acción padre: "+accionPadre);
        	
//        	String esq = ((RobotcovidAgentState) node.getParent().getAgentState()).getPosition();
        	esquina1 = Integer.parseInt(((RobotcovidAgentState) node.getParent().getAgentState()).getPosition());
        	x1 = RobotcovidAgentState.listaEsq.get(esquina1).xEsquina;
        	y1 = RobotcovidAgentState.listaEsq.get(esquina1).yEsquina;
        	
    	}
    	else {
//    		System.out.println("Padre nulo");
    	}
    	
    	//Verifica que el nodo abuelo no sea nulo
    	if(node.getParent().getParent() != null && node.getParent().getParent().getAction() != null) {
    		String accionAbuelo = node.getParent().getParent().getAction().toString();
//        	System.out.println("Acción abuelo: "+accionAbuelo);
        	
        	
        	esquina0 = Integer.parseInt(((RobotcovidAgentState) node.getParent().getParent().getAgentState()).getPosition());
        	x0 = RobotcovidAgentState.listaEsq.get(esquina0).xEsquina;
        	y0 = RobotcovidAgentState.listaEsq.get(esquina0).yEsquina;
    	}
    	else {
//    		System.out.println("Abuelo nulo");
    		x0 = -777;
        	y0 = -777;
    	}
    		
    	esquina2 = Integer.parseInt(((RobotcovidAgentState) node.getAgentState()).position);
       	x2 = RobotcovidAgentState.listaEsq.get(esquina2).xEsquina;
       	y2 = RobotcovidAgentState.listaEsq.get(esquina2).yEsquina;
    	
   		//Calcula longitud entre esquinas contiguas
   		Integer longitud = (int) Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
//   	System.out.println("x0: "+x0);
//    	System.out.println("y0: "+y0);
//   	System.out.println("x1: "+x1);
//   	System.out.println("y1: "+y1);
//    	System.out.println("x2: "+x2);
//    	System.out.println("y2: "+y2);
//    	System.out.println("Longitud: "+longitud);
    		
    	costo += longitud;
    		
    	Integer theta = 0;
    	if(!(x0==-777 && y0==-777)) {//Abuelo no nulo
       		theta = (int) Math.toDegrees(Math.acos(((x1-x0)*(x2-x1)+(y1-y0)*(y2-y1))/((Math.sqrt(Math.pow((x1-x0), 2)+Math.pow((y1-y0), 2))*Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))))));
    	}
//    	System.out.println("Theta: "+theta);
    		
    	costo += theta*(100.0/180.0);
    		
//    	System.out.println("Final---------------------------");
//    	double costo = 0.0;
    	System.out.println(esquina1+"-->"+esquina2+"; Dist:="+longitud+"; Theta="+theta+"; Costo="+costo);
    	return costo;
    	//return ((RobotcovidAgentState) node.getAgentState()).getListaInfectados().size();
    	//return ((RobotcovidAgentState) node.getAgentState()).getLongCamino();
    }
}
