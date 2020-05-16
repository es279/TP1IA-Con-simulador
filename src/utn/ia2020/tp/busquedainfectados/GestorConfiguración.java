package utn.ia2020.tp.busquedainfectados;

public class GestorConfiguraci�n {
	public static EnumEstrategia estrategia = EnumEstrategia.ASTAR;
	
	/**
	 * Indica si los infectados pueden moverse a esquinas cercanas de manera aleatorias durante la ejecuci�n
	 * La opci�n deber� obtenerse de la selecci�n del usuario en la interface
	 */
	public static boolean desplazamientoAleatorioInfectados = false;
	
	/**
	 * Indica si pueden aparecer nuevos infectados en esquinas aleatorias durante la ejecuci�n
	 * La opci�n deber� obtenerse de la selecci�n del usuario en la interface
	 */
	public static boolean agregarAleatoriamenteInfectados = false;
}
