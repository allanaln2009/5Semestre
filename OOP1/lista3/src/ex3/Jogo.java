package ex3;

import java.util.Random;

public class Jogo {
	private int obj;
	private int objCPU;

	public Jogo(int obj) {
		super();
		this.obj = obj;
		geraObjCPU();
	}

	public int getObj() {
		return obj;
	}
	public void setObj(int obj) {
		this.obj = obj;
	}
	
	public int getObjCPU() {
		return objCPU;
	}
	
	private void geraObjCPU() {
		objCPU = randInt(0, 2);
		System.out.print("CPU escolheu ");
		if(objCPU == 0){
			System.out.println("pedra");
		}else if(objCPU == 1){
			System.out.println("papel");
		}if(objCPU == 2){
			System.out.println("tesoura");
		}
	}

	public int comparaObj(){
		if(obj == objCPU){
			System.out.println("Empate!");
			return -1;
		}else if(obj == 0){
			if(objCPU == 1){
				//System.out.println("Pedra perde para papel.");
				return 1;
			}else if(objCPU == 2){
				//System.out.println("Pedra ganha de tesoura.");
				return 0;
			}
		}else if(obj == 1){
			if(objCPU == 0){
				//System.out.println("Papel ganha de pedra.");
				return 0;
			}else if(objCPU == 2){
				//System.out.println("Papel perde para tesoura.");
				return 1;
			}
		}else{ //(obj == 2)
			if(objCPU == 0){
				//System.out.println("Tesoura perde para pedra.");
				return 1;
			}else{ //if(objCPU == 1){
				//System.out.println("Tesoura ganha de papel.");
				return 0;
			}
		}
		return 0;
	}
	
	public static int randInt(int min, int max){
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
}
