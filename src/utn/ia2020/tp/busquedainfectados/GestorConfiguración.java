package utn.ia2020.tp.busquedainfectados;

public class GestorConfiguración {
	public static EnumEstrategia estrategia = EnumEstrategia.ASTAR;
	
	/**
	 * Indica si los infectados pueden moverse a esquinas cercanas de manera aleatorias durante la ejecución
	 * La opción deberá obtenerse de la selección del usuario en la interface
	 */
	public static boolean desplazamientoAleatorioInfectados = false;
	
	/**
	 * Indica si pueden aparecer nuevos infectados en esquinas aleatorias durante la ejecución
	 * La opción deberá obtenerse de la selección del usuario en la interface
	 */
	public static boolean agregarAleatoriamenteInfectados = false;
}
