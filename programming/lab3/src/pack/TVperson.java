package pack;

public final class TVperson extends Human{
	public TVperson(String name) {
		super(name);
	}
	public void appeared(TV tv) {
		System.out.print(this.toString() + " appear on " + tv.toString());
	}
	
	public void disappeared(TV tv) {
		System.out.println(this.toString() + " disappeared from the " +tv.toString());
	}
	
	@Override
	public void talk() {
		System.out.println(this.toString() + " talking");
		Carlson.beIrritated();
	}
}
