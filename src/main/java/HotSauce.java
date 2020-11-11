
public class HotSauce extends CoffeeDecorator {

private double cost = 1.50;
	
	HotSauce(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addHotSauce();
	}
	
	private double addHotSauce() {
		
		System.out.println(" + Hot Sauce: $1.50");
		
		return cost;
	}	
	
	public String printCost() {
		return specialCoffee.printCost() + " + Hot Sauce: $1.50\n";
	}

}
