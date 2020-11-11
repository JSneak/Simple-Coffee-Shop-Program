
public class BuildOrder {
	private Coffee order;
	
	BuildOrder() {
		order = new BasicCoffee();
	}
	
	public void addCream() {
		order = new Cream(order);
	}
	
	public void addExtraShot() {
		order = new ExtraShot(order);
	}
	
	public void addHotSauce() {
		order = new HotSauce(order);
	}
	
	public void addSugar() {
		order = new Sugar(order);
	}
	
	public void addTapioca() {
		order = new Tapioca(order);
	}
	
	public Coffee getOrder() {
		return order;
	}
}
