

/*
 * 
 * @author Samuel Walton
 * 
 * */

public class Items {
	
	
	
	
	private String ingredientName;
	private double ingredientPrice;
	private String breadTypes;
	private double breadPrice;
	
	
	
	
	public Items(String ingredientName, double ingredientPrice, String breadTypes, double breadPrice) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientPrice = ingredientPrice;
		this.breadTypes = breadTypes;
		this.breadPrice = breadPrice;
	}
	
	
	
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public double getIngredientPrice() {
		return ingredientPrice;
	}
	public void setIngredientPrice(double ingredientPrice) {
		this.ingredientPrice = ingredientPrice;
	}
	public String getBreadTypes() {
		return breadTypes;
	}
	public void setBreadTypes(String breadTypes) {
		this.breadTypes = breadTypes;
	}
	public double getBreadPrice() {
		return breadPrice;
	}
	public void setBreadPrice(double breadPrice) {
		this.breadPrice = breadPrice;
	}
	
	
	
	
	

}
