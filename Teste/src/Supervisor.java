
public class Supervisor {

	private String nome;
	private String email;
	private long hora;
	
	public Supervisor (String nome, String email){
	Email e = new Email(nome, email);
		
		this.nome = nome;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printSupervisor()
	{
		System.out.println("\nNome: "+ nome +"\nEmail: "+ email);
	}
}
