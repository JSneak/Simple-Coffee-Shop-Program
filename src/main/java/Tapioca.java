
public class Tapioca extends CoffeeDecorator {
	private double cost = 1.00;
		
	Tapioca(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addTapioca();
	}
	
	private double addTapioca() {
		
		System.out.println(" + tapioca: $1.00");
		
		return cost;
	}
	
	public String printCost() {
		return specialCoffee.printCost() + " + tapioca: $1.00\n";
	}
	
}
