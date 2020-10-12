package lab2;

import ru.ifmo.se.pokemon.*;


public class lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battle b = new Battle();
		Audino p1 = new Audino("hui",10);
		System.out.println(p1.getHP());

		Pokemon p2 = new Pokemon("Хищник", 1);
		b.addAlly(p1);
		b.addFoe(p2);
		b.go();
	}

}
