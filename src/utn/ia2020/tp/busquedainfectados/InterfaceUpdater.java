package utn.ia2020.tp.busquedainfectados;

import java.util.ArrayList;

import javafx.application.Platform;
import utn.ia2020.tp.busquedainfectados.covid.Esquina;
import utn.ia2020.tp.busquedainfectados.covid.RobotcovidAgentState;

public class InterfaceUpdater {
	private static MapDrawerController simulacionActual;
	private final static int SLEEP_TIME = 100;
	
	public static void actualizarUbicacionAgete(Esquina esq) {
		Thread thre = new Thread() {
			public void run(){
				simulacionActual.moverAgent(new Double(esq.getxEsquina()), new Double(esq.getyEsquina()));
			}
		};
		thre.start();
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrarInfectado(Esquina esquinaInfect) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						simulacionActual.borrarInfectado(esquinaInfect.getIdEsquina());
					}
				});
			}
		};
		thre.start();
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void repaintUbicacionInfectados(ArrayList<Integer> infectados) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						for(Integer indexEsquinaInfectado : infectados) {
							System.out.println("Esquina: "+simulacionActual+indexEsquinaInfectado);
							Esquina esquinaInfect = RobotcovidAgentState.listaEsq.get(indexEsquinaInfectado);
							
							InterfaceUpdater.simulacionActual.agregarInfectado(esquinaInfect.getIdEsquina(),new Double(esquinaInfect.getxEsquina()), new Double(esquinaInfect.getyEsquina()));
						}
					}
				});
			}
		};
		thre.start();
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void agregarCapturado(Esquina esquinaCapturado) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						simulacionActual.agregarCapturado(esquinaCapturado.getIdEsquina(),new Double(esquinaCapturado.getxEsquina()), new Double(esquinaCapturado.getyEsquina()));
						
					}
				});
			}
		};
		thre.start();
	}
	
	public static void agregarBloqueoDesconocido(Integer esquina1, Integer esquina2) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						Esquina esq1 = RobotcovidAgentState.listaEsq.get(esquina1);
						Esquina esq2 = RobotcovidAgentState.listaEsq.get(esquina2);
						
						simulacionActual.pintarBloqueo(esquina1, esquina2, 
								new Double(esq1.getxEsquina()+esq2.getxEsquina())/2,
								new Double(esq1.getyEsquina()+esq2.getyEsquina())/2);
					}
				});
			}
		};
		thre.start();
	}
	
	public static void agregarBloqueoConocido(Integer esquina1, Integer esquina2) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						Esquina esq1 = RobotcovidAgentState.listaEsq.get(esquina1);
						Esquina esq2 = RobotcovidAgentState.listaEsq.get(esquina2);
						
						simulacionActual.pintarBloqueoConocido(esquina1, esquina2, 
								new Double(esq1.getxEsquina()+esq2.getxEsquina())/2,
								new Double(esq1.getyEsquina()+esq2.getyEsquina())/2);
					}
				});
			}
		};
		thre.start();
	}

	public static MapDrawerController getSimulacionActual() {
		return simulacionActual;
	}

	public static void setSimulacionActual(MapDrawerController simulacionActual) {
		InterfaceUpdater.simulacionActual = simulacionActual;
	}
}
