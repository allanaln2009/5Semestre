package ex2;

public class AnalisaTri {
	public String tipoTri(float l1, float l2, float l3){
		if(l1 == l2 && l1 == l3){
			return "Equil�tero";
		}else if((l1 == l2) || (l1 == l3)){
			return "Is�sceles";
		}else/*if(l1 != l2 && l1 != l3 && l2 != l3)*/{
			return "Escaleno";
		}
	}
}
