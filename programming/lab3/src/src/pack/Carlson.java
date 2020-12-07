package pack;

public final class Carlson extends Human {	
	private static Carlson instance;
    private Carlson(String name){
    	super(name);
    }
    
    public static Carlson getInstance(){ // #3
    if(instance == null){
        instance = new Carlson("Carlson");	
        }
    return instance;
    }
    
    public static void beIrritated() {
		instance.condition = Condition.IRRITATED;
		System.out.println("Carlson became irritated");
	}
    
}
