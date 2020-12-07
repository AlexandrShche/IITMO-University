package pack;

public class Human extends Creature{

	public Human(String name) {
		super(name);
		condition = Condition.NORMAL;
	}
	public void smile() {
		System.out.println(this.toString() + " smiles");
	}
	public void smile(Human h) {
		System.out.println(this.toString() + " smiles at " + h.toString());
	}
	public void talk() {
		System.out.println(this.toString() + " talking");
	}
	
	public void pushButtons() {
		System.out.println(this.toString() + " push all buttons");
	}
	
	public Condition condition;
	@Override
	public void appeared() {
	}
	@Override
	public void disappeared() {		
	}	
}

enum Condition{
	NORMAL, IRRITATED	
} 