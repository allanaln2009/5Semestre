package aula2.exercicio4_v2;

public class Processa {
	private String op;
	private float v1;
	private float v2;
	private float res;
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	public float getV1() {
		return v1;
	}
	public void setV1(float v1) {
		this.v1 = v1;
	}
	
	public float getV2() {
		return v2;
	}
	public void setV2(float v2) {
		this.v2 = v2;
	}
	
	public float getRes() {
		return res;
	}
	
	public void calcula(){
		if(op.equals("+")){
			res = v1+v2;
		}else if(op.equals("-")){
			res = v1-v2;
		}else if(op.equals("*")){
			res = v1*v2;
		}else if(op.equals("/")){
			res = v1/v2;
		}else{
			System.out.println("Digite uma operação válida.");
		}
		
	}
}
