import java.util.ArrayList;

public class Lista {
	private static Lista instance = new Lista();
	public ArrayList<Item> itens;

	private Lista() {
		itens = new ArrayList<>();
	}
	
	public Lista add(String name){
		itens.add(new Item(name));
		return this;
	}
	
	public static Lista getInstance(){
		return instance;
	}
}
