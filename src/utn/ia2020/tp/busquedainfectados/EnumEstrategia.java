package utn.ia2020.tp.busquedainfectados;

public enum EnumEstrategia {
	ASTAR,AMPLITUD,PROFUNDIDAD,COSTO_UNIFORME;
	
	@Override
	public String toString() {
		switch (this) {
			case ASTAR:
				return "A*";
			case AMPLITUD:
				return "Amplitud";
			case PROFUNDIDAD:
				return "Profundidad";
			case COSTO_UNIFORME:
				return "Costo uniforme";
			default:
				return "Estrategia no definida";
		}
			
		
		
	}
}
