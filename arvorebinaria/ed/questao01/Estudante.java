package questao01;

public class Estudante {
	private String nome;
	private String matricula;
	private int pos;
	
	public Estudante(String nome, String matricula, int pos) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.pos = pos;
	}
	public Estudante(){
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
