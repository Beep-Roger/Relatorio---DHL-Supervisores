import java.util.ArrayList;

public class Supervisores {

	private ArrayList<Supervisor> supervisores = new ArrayList<Supervisor>();
	
	public Supervisores(String query) {
		Conectando sp = new Conectando(query);

		for (int i = 0; i < sp.getResultado().size();i+= 2 )
		{	
			addSupervisor(sp.getResultado().get(i),sp.getResultado().get(i+1));

		}
		for (int i = 1; i < supervisores.size();i++ )
		{
			supervisores.get(i).printSupervisor();
		}
	}
	
	public void addSupervisor(String nome, String email)
	{
		supervisores.add(new Supervisor(nome, email));

	}
	
	
}
