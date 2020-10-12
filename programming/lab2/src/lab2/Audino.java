import java.awt.Window.Type;

import ru.ifmo.se.pokemon.*;

public class Audino  extends Pokemon {
	public Audino(String name, int lvl ) {
		super(name, lvl);
		setStats(103, 60, 86, 60, 86, 50);
		setType(Type.NORMAL);
		setMove(new HuperVoice(), new DreamEater(), new Growl(), new BabyDollEyes());
	}
}

class HuperVoice extends SpecialMove {
	public HuperVoice(){
		super(Type.NORMAL, 90, 1.0);
	}
}

class DreamEater extends SpecialMove{
	public DreamEater(){
		super(Type.PSYCHIC, 100, 1.0);
	}
}

class Growl extends StatusMove{
	public Growl(){
		super(Type.NORMAL, 0, 1.0);

	}

	@Override
	
}