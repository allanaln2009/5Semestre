package ex7;

public class Jogo {
	private int pass;
	private int attempts;
	
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getAttempts() {
		return attempts;
	}
	public void addAttempts() {
		attempts++;
	}
	public void restart() {
		pass = 0;
		attempts = 0;
	}
	
	public String comparePass(int pass2){
		if((pass2+1) == pass || (pass2-1) == pass){
			return "T� QUENTE!!!";
		}else if(pass2 > pass){
			return "A senha � menor";
		}else if(pass2 < pass){
			return "A senha � maior"; 
		}else{
			return "Voc� acertou!";
		}
	}
}
