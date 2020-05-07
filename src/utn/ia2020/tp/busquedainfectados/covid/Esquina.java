package utn.ia2020.tp.busquedainfectados.covid;

public class Esquina {

	int idEsquina;
	int xEsquina;
	int yEsquina;
	
	public Esquina() {
		
	}
	
	public Esquina(int id, int x, int y) {
		idEsquina = id;
		xEsquina = x;
		yEsquina = y;
	}

	public int getIdEsquina() {
		return idEsquina;
	}

	public void setIdEsquina(int idEsquina) {
		this.idEsquina = idEsquina;
	}

	public int getxEsquina() {
		return xEsquina;
	}

	public void setxEsquina(int xEsquina) {
		this.xEsquina = xEsquina;
	}

	public int getyEsquina() {
		return yEsquina;
	}

	public void setyEsquina(int yEsquina) {
		this.yEsquina = yEsquina;
	}
	
}
