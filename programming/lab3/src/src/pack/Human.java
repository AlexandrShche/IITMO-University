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
	
	public void pushButtons(TV tv) {
		System.out.println(this.toString() + " push all buttons of " + tv.toString());
	}
	
	public Condition condition;

	@Override
	public void appeared(TV tv) {

	}
	@Override
	public void disappeared(TV tv) {
		
	}	
}

enum Condition{
	NORMAL, IRRITATED	
} 