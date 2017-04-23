package aquecimento;

public class ControleRemoto {
	Televisao tv = new Televisao();
	void aumVol(){
		int vol = tv.getVolume();
		tv.setVolume(vol + 1);
	}
	void dimVol(){
		int vol = tv.getVolume();
		if(vol > 0){
			tv.setVolume(vol - 1);
		}
	}
	void aumCh(){
		int ch = tv.getCanal();
		tv.setCanal(ch + 1);
	}
	void dimCh(){
		int ch = tv.getCanal();
		if(ch > 0){
			tv.setCanal(ch + 1);
		}
	}
	void setCanal(int ch){
		tv.setCanal(ch);
	}
	void display(){
		System.out.println("Volume: " + tv.getVolume() + "\nCanal: " + tv.getCanal());
	}
}
