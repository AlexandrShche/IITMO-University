package pack;

public class lab3 {

	public static void main(String[] args) {
		Carlson carlson = new Carlson("Carlson");
		TV announcer = new TV("announcer");
		Human baby = new Human("Baby");
		TV sirs = new TV("serious and fat gentelmen");
		
		announcer.smile();
		carlson.smile(announcer);
		
		carlson.push(baby);
		announcer.disappeared();
		
		sirs.appeared();
		sirs.talk();
		
		carlson.condition = Condition.IRRITATED;
		System.out.println("Carlson became irritated");
		
		carlson.pushButtons();
	}
}