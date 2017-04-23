package bateria1;

public class ArabicoParaRomano {
	private int num;

	public ArabicoParaRomano(int num) {
		this.num = num;
	}

	private String M() {
		return "MMMMM".substring(0, (int) (num / 1000));
	}

	private String D() {
		int n = dig(1000, 100);
		if(n == 9){
			return "CM";
		}else if(n > 4){
			return "DCCC".substring(0, n - 4);
		}else if(n == 4){
			return "CD";
		}else{
			return "CCC".substring(0, n);
		}
	}

	private String X() {
		int n = dig(100, 10);
		if(n == 9){
			return "XC";
		}else if(n > 4){
			return "LXXX".substring(0, n - 4);
		}else if(n == 4){
			return "XL";
		}else{
			return "XXX".substring(0, n);
		}
	}

	private String I() {
		int n = dig(10, 1);
		if(n == 9){
			return "IX";
		}else if(n > 4){
			return "VIII".substring(0, n - 4);
		}else if(n == 4){
			return "IV";
		}else{
			return "III".substring(0, n);
		}
	}

	private int dig(int a, int b) {
		return (int) ((num % a) / b);
	}

	public void setnum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		if(num > 0 && num < 5000){
			return M() + D() + X() + I();
		}else{
			return "Número inválido";
		}
	}
}