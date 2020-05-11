package utn.ia2020.tp.busquedainfectados.covid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import frsf.cidisi.faia.agent.situationcalculus.KnowledgeBase;
import frsf.cidisi.faia.state.EnvironmentState;
import utn.ia2020.tp.busquedainfectados.InterfaceUpdater;

public class RobotcovidEnvironmentState extends EnvironmentState {
	
		public String agentPosition = "1";
		
		//Lista de bloqueos del ambiente
		public ArrayList<Integer[]> listaBloqueos = cargarBloqueos();
		
		//TODO cambiar esta lista de bloqueos (pone un bloqueo entre 2 y 3)
				private ArrayList<Integer[]> cargarBloqueos() {
					ArrayList<Integer[]> listaBloqueos = new ArrayList<Integer[]>();
					Integer[] vec0 = new Integer[2];
					vec0[0]=2;
					vec0[1]=3;
					//listaBloqueos.add(vec0);
					
					Integer[] vec1 = new Integer[2];
					vec1[0]=3;
					vec1[1]=4;
					//listaBloqueos.add(vec1);
					
					Integer[] vec2 = new Integer[2];
					vec2[0]=21;
					vec2[1]=12;
					//listaBloqueos.add(vec2);
					
					//TODO: Interface. Pinta los bloqueos en la interface de simulacion
					for(Integer[] bloqueo : listaBloqueos) {
						InterfaceUpdater.agregarBloqueoDesconocido(bloqueo[0], bloqueo[1]);
					}
					
					return listaBloqueos;
				}
		
		//Lista de esquinas donde se encuentran los infectados y sensores activos
		public static ArrayList<Integer> listaInfectados = cargarInfectados();
				
		//TODO cambiar esta lista de infectados (pone un infectado en la esquina 11 y otro en la 12)
		private static ArrayList<Integer> cargarInfectados() {
			ArrayList<Integer> listaInfectados = new ArrayList<Integer>();
			
			//Seteamos los sensores activados al principio de la lista
			listaInfectados.add(3);
			RobotcovidAgentState.CANTIDAD_SENSORES = listaInfectados.size();
			
			//Seteamos los infectados (móviles)
			listaInfectados.add(12);
			listaInfectados.add(24);
			
			//TODO: Interface. Pinta los infectados en la interface de simulacion
			InterfaceUpdater.repaintUbicacionInfectados(listaInfectados);
			
			return listaInfectados;
		}
	    
		//Lista de esquinas del entorno estudiado
	    public static ArrayList<Esquina> listaEsquinas = cargarEsquinas();
	    
	    private static ArrayList<Esquina> cargarEsquinas () {
	    	
	    	ArrayList<Esquina> listaEsq = new ArrayList<Esquina>();
	    	
	    	listaEsq.add(new Esquina( 0, -41, 0));
	    	listaEsq.add(new Esquina( 1,  0,  0));
	    	listaEsq.add(new Esquina( 2, 108, 0));
			listaEsq.add(new Esquina( 3, 213, 0));
			listaEsq.add(new Esquina( 4, 310, 0));
			listaEsq.add(new Esquina( 5, 414, 0));
			listaEsq.add(new Esquina( 6, 517, 0));
			listaEsq.add(new Esquina( 7, 631, 0));
			listaEsq.add(new Esquina( 8, 774, 0));
			listaEsq.add(new Esquina( 9, -101, 106));
			listaEsq.add(new Esquina( 10, 0, 108));
			listaEsq.add(new Esquina( 11, 108, 110));
			listaEsq.add(new Esquina( 12, 214, 111));
			listaEsq.add(new Esquina( 13, 310, 107));
			listaEsq.add(new Esquina( 14, 415, 105));
			listaEsq.add(new Esquina( 15, 521, 107));
			listaEsq.add(new Esquina( 16, 631, 104));
			listaEsq.add(new Esquina( 17, 735, 104));
			listaEsq.add(new Esquina( 18, -170, 210));
			listaEsq.add(new Esquina( 19, 2, 208));
			listaEsq.add(new Esquina( 20, 107, 208));
			listaEsq.add(new Esquina( 21, 210, 210));
			listaEsq.add(new Esquina( 22, 314, 210));
			listaEsq.add(new Esquina( 23, 418, 208));
			listaEsq.add(new Esquina( 24, 520, 208));
			listaEsq.add(new Esquina( 25, 632, 208));
			listaEsq.add(new Esquina( 26, 698, 208));
			listaEsq.add(new Esquina( 27, -230, 313));
			listaEsq.add(new Esquina( 28, -200, 320));
			listaEsq.add(new Esquina( 29, -98, 316));
			listaEsq.add(new Esquina( 30, 2, 314));
			listaEsq.add(new Esquina( 31, 110, 314));
			listaEsq.add(new Esquina( 32, 211, 313));
			listaEsq.add(new Esquina( 33, 314, 313));
			listaEsq.add(new Esquina( 34, 420, 314));
			listaEsq.add(new Esquina( 35, 521, 314));
			listaEsq.add(new Esquina( 36, 664, 311));
			listaEsq.add(new Esquina( 37, 5, 370));
			listaEsq.add(new Esquina( 38, 108, 369));
			listaEsq.add(new Esquina( 39, 212, 366));
			listaEsq.add(new Esquina( 40, 317, 369));
			listaEsq.add(new Esquina( 41, 420, 369));
			listaEsq.add(new Esquina( 42, -295, 421));
			listaEsq.add(new Esquina( 43, -198, 423));
			listaEsq.add(new Esquina( 44, -97, 420));
			listaEsq.add(new Esquina( 45, 7, 417));
			listaEsq.add(new Esquina( 46, 110, 418));
			listaEsq.add(new Esquina( 47, 214, 417));
			listaEsq.add(new Esquina( 48, 317, 416));
			listaEsq.add(new Esquina( 49, 421, 415));
	    	listaEsq.add(new Esquina( 50, 523, 414));
	    	listaEsq.add(new Esquina( 51, 627, 414));
	    	listaEsq.add(new Esquina( 52, -311, 450));
	    	listaEsq.add(new Esquina( 53, -351, 528));
	    	listaEsq.add(new Esquina( 54, -298, 524));
	    	listaEsq.add(new Esquina( 55, -197, 524));
	    	listaEsq.add(new Esquina( 56, -94, 521));
	    	listaEsq.add(new Esquina( 57, 10, 521));
	    	listaEsq.add(new Esquina( 58, 111, 520));
	    	listaEsq.add(new Esquina( 59, 217, 520));
	    	listaEsq.add(new Esquina( 60, 320, 520));
	    	listaEsq.add(new Esquina( 61, 423, 517));
	    	listaEsq.add(new Esquina( 62, 524, 517));
	    	listaEsq.add(new Esquina( 63, 604, 520));
	    	listaEsq.add(new Esquina( 64, -388, 630));
	    	listaEsq.add(new Esquina( 65, -297, 629));
	    	listaEsq.add(new Esquina( 66, -196, 627));
	    	listaEsq.add(new Esquina( 67, -91, 626));
	    	listaEsq.add(new Esquina( 68, 13, 624));
	    	listaEsq.add(new Esquina( 69, 115, 623));
	    	listaEsq.add(new Esquina( 70, 218, 623));
	    	listaEsq.add(new Esquina( 71, 323, 621));
	    	listaEsq.add(new Esquina( 72, 424, 621));
	    	listaEsq.add(new Esquina( 73, 525, 621));
	    	listaEsq.add(new Esquina( 74, 585, 621));
	    	listaEsq.add(new Esquina( 75, -400, 733));
	    	listaEsq.add(new Esquina( 76, -294, 734));
	    	listaEsq.add(new Esquina( 77, -191, 731));
	    	listaEsq.add(new Esquina( 78, -90, 730));
	    	listaEsq.add(new Esquina( 79, 14, 729));
	    	listaEsq.add(new Esquina( 80, 118, 728));
	    	listaEsq.add(new Esquina( 81, 221, 727));
	    	listaEsq.add(new Esquina( 82, 324, 728));
	    	listaEsq.add(new Esquina( 83, 427, 727));
	    	listaEsq.add(new Esquina( 84, 565, 727));
	    	listaEsq.add(new Esquina( 85, -398, 860));
	    	listaEsq.add(new Esquina( 86, -291, 857));
	    	listaEsq.add(new Esquina( 87, -189, 856));
	    	listaEsq.add(new Esquina( 88, -85, 854));
	    	listaEsq.add(new Esquina( 89, 22, 853));
	    	listaEsq.add(new Esquina( 90, 122, 850));
	    	listaEsq.add(new Esquina( 91, 223, 841));
	    	listaEsq.add(new Esquina( 92, 325, 839));
	    	listaEsq.add(new Esquina( 93, 430, 836));
	    	listaEsq.add(new Esquina( 94, 548, 834));
	    	listaEsq.add(new Esquina( 95, -394, 954));
	    	listaEsq.add(new Esquina( 96, -288, 950));
	    	listaEsq.add(new Esquina( 97, -186, 944));
	    	listaEsq.add(new Esquina( 98, -83, 943));
	    	listaEsq.add(new Esquina( 99, 24, 949));
	    	listaEsq.add(new Esquina( 100, 122, 947));
	    	listaEsq.add(new Esquina( 101, 174, 941));
	    	listaEsq.add(new Esquina( 102, 226, 939));
	    	listaEsq.add(new Esquina( 103, 330, 936));
	    	listaEsq.add(new Esquina( 104, 431, 934));
	    	listaEsq.add(new Esquina( 105, 527, 933));
	    	listaEsq.add(new Esquina( 106, -392, 1047));
	    	listaEsq.add(new Esquina( 107, -287, 1040));
	    	listaEsq.add(new Esquina( 108, -185, 1040));
	    	listaEsq.add(new Esquina( 109, -81, 1038));
	    	listaEsq.add(new Esquina( 110, 26, 1037));
	    	listaEsq.add(new Esquina( 111, 31, 1069));
	    	listaEsq.add(new Esquina( 112, 129, 1069));
	    	listaEsq.add(new Esquina( 113, 228, 1034));
	    	listaEsq.add(new Esquina( 114, 333, 1029));
	    	listaEsq.add(new Esquina( 115, 436, 1027));
	    	listaEsq.add(new Esquina( 116, 514, 1020));
	    	listaEsq.add(new Esquina( 117, -390, 1143));
	    	listaEsq.add(new Esquina( 118, -284, 1136));
	    	listaEsq.add(new Esquina( 119, -181, 1133));
	    	listaEsq.add(new Esquina( 120, -78, 1131));
	    	listaEsq.add(new Esquina( 121, 34, 1126));
	    	listaEsq.add(new Esquina( 122, 127, 1127));
	    	listaEsq.add(new Esquina( 123, 230, 1124));
	    	listaEsq.add(new Esquina( 124, 334, 1123));
	    	listaEsq.add(new Esquina( 125, 437, 1120));
	    	listaEsq.add(new Esquina( 126, 501, 119));
	    	listaEsq.add(new Esquina( 127, 130, 1183));
	    	listaEsq.add(new Esquina( 128, 231, 1180));
	    	listaEsq.add(new Esquina( 129, 337, 1177));
	    	listaEsq.add(new Esquina( 130, 439, 1176));
	    	listaEsq.add(new Esquina( 131, -380, 1244));
	    	listaEsq.add(new Esquina( 132, -283, 1240));
	    	listaEsq.add(new Esquina( 133, -179, 1237));
	    	listaEsq.add(new Esquina( 134, -77, 1234));
	    	listaEsq.add(new Esquina( 135, 36, 1233));
	    	listaEsq.add(new Esquina( 136, 129, 1231));
	    	listaEsq.add(new Esquina( 137, 234, 1229));
	    	listaEsq.add(new Esquina( 138, 337, 1226));
	    	listaEsq.add(new Esquina( 139, 439, 1223));
	    	listaEsq.add(new Esquina( 140, 499, 1220));
	    	listaEsq.add(new Esquina( 141, -378, 1346));
	    	listaEsq.add(new Esquina( 142, -281, 1346));
	    	listaEsq.add(new Esquina( 143, -173, 1341));
	    	listaEsq.add(new Esquina( 144, -69, 1340));
	    	listaEsq.add(new Esquina( 145, 34, 1337));
	    	listaEsq.add(new Esquina( 146, 137, 1334));
	    	listaEsq.add(new Esquina( 147, 241, 1331));
	    	listaEsq.add(new Esquina( 148, 341, 1329));
	    	listaEsq.add(new Esquina( 149, 441, 1327));
	    	listaEsq.add(new Esquina( 150, 500, 1327));
	    	listaEsq.add(new Esquina( 151, -373, 1447));
	    	listaEsq.add(new Esquina( 152, -280, 1447));
	    	listaEsq.add(new Esquina( 153, -173, 1446));
	    	listaEsq.add(new Esquina( 154, -69, 1444));
	    	listaEsq.add(new Esquina( 155, 34, 1441));
	    	listaEsq.add(new Esquina( 156, 140, 1439));
	    	listaEsq.add(new Esquina( 157, 241, 1437));
	    	listaEsq.add(new Esquina( 158, 344, 1434));
	    	listaEsq.add(new Esquina( 159, 443, 1433));
	    	listaEsq.add(new Esquina( 160, 503, 1431));
			listaEsq.add(new Esquina( 161, -100, 210));
	    	
	    	return listaEsq;
	    }

	    /**
	     * This map has a point of the world (A, B, C, ...) as key, and a collection
	     * of successors of that point.
	     */
	    private static HashMap<String, Collection<String>> map;

	    public static final String[][] POSITIONS = new String[][]{
	    	
	    	{"0", "1", "9"},
	        {"1", "2"},
	        {"2", "3", "11"},
	        {"3", "4"},
	        {"4", "5", "13"},
	        {"5", "6"},
	        {"6", "7", "15"},
	        {"7", "16", "8"},
	        {"8", "17"},
	        {"9", "18", "0"},
	        {"10", "9", "1"},
	        {"11", "10", "20"},
	        {"12", "3", "11"},
	        {"13", "22", "12"},
	        {"14", "5", "13"},
	        {"15", "24", "14"},
	        {"16", "7", "25"},
	        {"17", "8", "26", "16"},
	        {"18", "27", "9", "161"},
	        {"19", "10", "20", "161"},
	        {"20", "31", "21", "19"},
	        {"21", "12", "22", "20"},
	        {"22", "33", "23", "21"},
	        {"23", "14", "24", "22"},
	        {"24", "25", "23"},
	        {"25", "16", "26", "24"},
	        {"26", "35", "17"},
	        {"27", "18", "37"},
	        {"28", "27"},
	        {"29", "44", "28"},
	        {"30", "19", "29"},
	        {"31", "38", "30"},
	        {"32", "31", "21"},
	        {"33", "40", "32"},
	        {"34", "23", "33"},
	        {"35", "50", "34"},
	        {"36", "26", "51"},
	        {"37", "30", "38"},
	        {"38", "46", "39", "37"},
	        {"39", "32", "38"},
	        {"40", "48", "41"},
	        {"41", "34", "40"},
	        {"42", "27", "52", "43"},
	        {"43", "28", "53", "44"},
	        {"44", "54", "45"},
	        {"45", "37", "46"},
	        {"46", "56", "47"},
	        {"47", "39", "48"},
	        {"48", "58", "49"},
	        {"49", "41", "50"},
	        {"50", "60", "51"},
	        {"51", "36", "61"},
	        {"52", "53", "54", "42"},
	        {"53", "64", "52"},
	        {"54", "65", "53"},
	        {"55", "54", "43"},
	        {"56", "55", "67"},
	        {"57", "45", "56"},
	        {"58", "69", "57"},
	        {"59", "47", "58"},
	        {"60", "71", "59"},
	        {"61", "49", "60"},
	        {"62", "73", "61"},
	        {"63", "51", "74", "62"},
	        {"64", "53", "75", "65"},
	        {"65", "76", "66"},
	        {"66", "55", "67"},
	        {"67", "78", "68"},
	        {"68", "57", "69"},
	        {"69", "80", "70"},
	        {"70", "59", "71"},
	        {"71", "82", "72"},
	        {"72", "61", "73"},
	        {"73", "74"},
	        {"74", "63", "84"},
	        {"75", "85", "64"},
	        {"76", "86", "75"},
	        {"77", "66", "76"},
	        {"78", "88", "77"},
	        {"79", "68", "78"},
	        {"80", "90", "79"},
	        {"81", "70", "80"},
	        {"82", "92", "81"},
	        {"83", "72", "82"},
	        {"84", "74", "94", "83"},
	        {"85", "75", "95", "86"},
	        {"86", "96", "87"},
	        {"87", "77", "88"},
	        {"88", "98", "89"},
	        {"89", "79", "90"},
	        {"90", "100", "91"},
	        {"91", "81", "92"},
	        {"92", "103", "93"},
	        {"93", "83", "94"},
	        {"94", "84", "105"},
	        {"95", "106", "85"},
	        {"96", "107", "95"},
	        {"97", "87", "96"},
	        {"98", "109", "97"},
	        {"99", "89", "98"},
	        {"100", "99"},
	        {"101", "113", "100"},
	        {"102", "91", "101"},
	        {"103", "114", "102"},
	        {"104", "93", "103"},
	        {"105", "94", "116", "104"},
	        {"106", "95", "117", "107"},
	        {"107", "118", "108"},
	        {"108", "97", "109"},
	        {"109", "120", "110"},
	        {"110", "99"},
	        {"111", "110", "112"},
	        {"112", "122", "111"},
	        {"113", "112", "101"},
	        {"114", "115", "124"},
	        {"115", "114", "104", "116"},
	        {"116", "115", "105", "126"},
	        {"117", "106", "131"},
	        {"118", "132", "117"},
	        {"119", "108", "118"},
	        {"120", "134", "119"},
	        {"121", "111", "120"},
	        {"122", "127", "121"},
	        {"123", "113", "122"},
	        {"124", "129", "123"},
	        {"125", "115", "124"},
	        {"126", "116", "140"},
	        {"127", "128", "136"},
	        {"128", "123"},
	        {"129", "130", "138"},
	        {"130", "129", "125"},
	        {"131", "141", "117", "132"},
	        {"132", "142", "133"},
	        {"133", "119", "134"},
	        {"134", "144", "135"},
	        {"135", "121", "136"},
	        {"136", "146", "137"},
	        {"137", "128", "138"},
	        {"138", "148", "139"},
	        {"139", "130", "140"},
	        {"140", "126", "150"},
	        {"141", "151", "131"},
	        {"142", "141", "152"},
	        {"143", "133", "142"},
	        {"144", "154", "143"},
	        {"145", "135", "144"},
	        {"146", "156", "145"},
	        {"147", "146"},
	        {"148", "158", "147"},
	        {"149", "139", "148"},
	        {"150", "140", "160", "149"},
	        {"151", "152"},
	        {"152", "153"},
	        {"153", "143", "154"},
	        {"154", "155"},
	        {"155", "145", "156"},
	        {"156", "157"},
	        {"157", "147", "158"},
	        {"158", "159"},
	        {"159", "149", "160"},
	        {"160", "150"},
	        {"161", "29", "18", "19"},
	        
	        
	    };

	    RobotcovidEnvironmentState() {
	        map = new HashMap<String, Collection<String>>();
	    }

	    @Override
	    public Object clone() {
	    	
	    	RobotcovidEnvironmentState newState = new RobotcovidEnvironmentState();
	    	newState.setAgentPosition(agentPosition);
	    	
	    	ArrayList<Integer> listaInfec = (ArrayList<Integer>) listaInfectados.clone();
	        newState.setListaInfectados(listaInfec);
	        
	        newState.setMap(map);
	        
	        ArrayList<Integer[]> listaBlock = new ArrayList<Integer[]>();
	        
	        for(Integer[] bloqueo : this.listaBloqueos) {
	        	
	        	Integer[] arreglo = new Integer[2];
	        	
	        	arreglo = bloqueo.clone();
	        	listaBlock.add(arreglo);
	        	
			 }
	        newState.setListaBloqueos(listaBlock);
	    	
	        return newState;
	    }

	    @Override
	    public void initState() {
	        /**
	         * In this matrix the first element of each row represents a position
	         * in the map and the seccessors of that position.
	         */
	        map = new HashMap<String, Collection<String>>();
	        
	        for (int i = 0; i < POSITIONS.length; i++) {
	            ArrayList<String> successors = new ArrayList<String>();
	            for (int j = 1; j < POSITIONS[i].length; j++) {
	                successors.add(POSITIONS[i][j]);
	            }
	            map.put(POSITIONS[i][0], successors);

	        }
	    }

	    @Override
	    public String toString() {
	        String str = "";

	        str = str + "[ \n";
	        for (String point : map.keySet()) {
	            str = str + "[ " + point + " --> ";
	            Collection<String> successors = map.get(point);
	            if (successors != null) {
	                for (String successor : successors) {
	                    str = str + successor + " ";
	                }
	            }
	            str = str + " ]\n";
	        }
	        str = str + " ]";

	        return str;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        
	    	if (!(obj instanceof RobotcovidEnvironmentState)) {
	            return false;
	        }
	    	
	    	if(!(agentPosition.equals(((RobotcovidEnvironmentState) obj).getAgentPosition()))) {
	        	return false; 
	        }
	    	
	    	if(!(listaInfectados.equals(((RobotcovidAgentState) obj).getListaInfectados()))) {
	        	return false; 
	        }
	    	
	    	if(!map.equals(this.getMap())) {
	    		return false;
	    	}
	    	
	        return true;
	    }
	    
	    public void eliminarInfectado(int index) {
			listaInfectados.remove(index);
		}

		public String getAgentPosition() {
			return agentPosition;
		}

		public void setAgentPosition(String agentPosition) {
			this.agentPosition = agentPosition;
		}

		public ArrayList<Integer> getListaInfectados() {
			return listaInfectados;
		}

		public void setListaInfectados(ArrayList<Integer> listaInfectados) {
			this.listaInfectados = listaInfectados;
		}

		public HashMap<String, Collection<String>> getMap() {
			return map;
		}

		public void setMap(HashMap<String, Collection<String>> map) {
			this.map = map;
		}
		
		 public ArrayList<Integer[]> getListaBloqueos() {
			return listaBloqueos;
		}

		public void setListaBloqueos(ArrayList<Integer[]> listaBloqueos) {
			this.listaBloqueos = listaBloqueos;
		}

		public ArrayList<Integer[]> getBloqueosPosicionActual (){
			 ArrayList<Integer[]> lista = new ArrayList<Integer[]>();
			 
			 for(Integer[] bloqueo : this.listaBloqueos) {
				 if((bloqueo[0] == Integer.parseInt(this.agentPosition)) || (bloqueo[1] == Integer.parseInt(this.agentPosition))) {
					 lista.add(bloqueo);
					 System.out.println("Agregado nuevo bloqueo asndaksndascacona");
				 }
			 }
			 
			 return lista;
		}
	    
}
