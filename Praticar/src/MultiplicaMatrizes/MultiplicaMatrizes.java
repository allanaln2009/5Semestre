package MultiplicaMatrizes;

public class MultiplicaMatrizes {
	private Integer[][] vetor1;
	private Integer[][] vetor2;
	private Integer[][] v;

	public MultiplicaMatrizes(Integer[][] vetor1, Integer[][] vetor2) {
		super();
		if((vetor1.length != vetor2[0].length) || (vetor1[0].length != vetor2.length)){
			throw new ArrayIndexOutOfBoundsException("Quantidade de linhas e colunas são incompatíveis.");
		}

		// define tamanho de linha e coluna para cada vetor
		this.vetor1 = new Integer[vetor1.length][vetor1[0].length];
		this.vetor2 = new Integer[vetor2.length][vetor2[0].length];
		this.v = new Integer[vetor1.length][vetor1[0].length];
		this.vetor1 = vetor1;
		this.vetor2 = vetor2;
		this.v = calcula();
	}

	public Integer[][] getResultado() {
		return v;
	}

	public Integer[][] calcula() {
		Integer[][] v = this.v;
		for(int i = 0; i < v.length; i++){
			for(int j = 0; j < v[i].length; j++){
				v[i][j] = multiplica(vetor1[i], j);
			}
		}
		return v;
	}

	private Integer multiplica(Integer[] linhaA, Integer colunaB) {
		Integer r = 0;
		for(int i = 0; i < linhaA.length; i++){
			r += linhaA[i] * vetor2[i][colunaB];
		}
		return r;
	}
}
