package ex1;

public class Calcula {
	private float x1;
	private float x2;
	private float y1;
	private float y2;
	
	public Calcula(float x1, float x2, float y1, float y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	double resDist(){
		return Math.sqrt(Math.pow((x2 - x1), 2d) + Math.pow((y2 - y1), 2d));
	}
}
