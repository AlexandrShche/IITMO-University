package pack;

public class lab3 {

	public static void main(String[] args) {
		Carlson carlson = Carlson.getInstance();
		TV tv = new TV("TV");
		TVperson announcer = new TVperson("announcer");
		Human baby = new Human("Baby");
		TVperson sirs = new TVperson("serious and fat gentelmen");
		
		
		announcer.smile();
		carlson.smile(announcer);
		
		carlson.push(baby);
		announcer.disappeared(tv);
		
		sirs.appeared(tv);
		sirs.talk();
		
		
		
		carlson.pushButtons(tv);
	}
}