/**
*@author Canberk Arici
*
*/

public class Furniture{

	/**
	 * This string is the name of product.
	 */
	private String product;

	/**
	 * This string is the name of model.
	 */
	private String model;

	/**
	 * This string is the name of color.
	 */
	private String color;

	/**
	 * This integer value shows which branch furniture is in
	 */
	private int which_branch;

	/**
	 * This integer value give number of furniture in stock
	 */
	private int numberInStock;

	/**
	 * Package third-parameter Constructor
	 * @param product string of the product name.
	 * @param model string of the model name.
	 * @param which_branch integer value of branch that has furniture
	 */
	public Furniture(String product, String model, int which_branch){
		this.product = product;
		this.model = model;
		this.color = "None";
		this.which_branch = which_branch;
		this.numberInStock = 0;
	}

	/**
	 * Package four-parameter Constructor
	 * @param product string of the product name.
	 * @param model string of the model name.
	 * @param color string of the color of furniture.
	 * @param which_branch integer value of branch that has furniture
	 */
	public Furniture(String product, String model, String color, int which_branch){
		this.product = product;
		this.model = model;
		this.color = color;
		this.which_branch = which_branch;
		this.numberInStock = 0;
	}

	/**
	 * This method gets number of furnitures in stock.
	 * @return numberInStock integer value number of furnitures in stock
	 */
	public int getNumberInStock(){
		return numberInStock;
	}

	/**
	 * This method sets number of furnitures in stock.
	 * @param numberInStock integer value number of furnitures in stock.
	 */
	public void setNumberInStock(int numberInStock){
		this.numberInStock = numberInStock;
	}

	/**
	 * This method gets name of product.
	 * @return product string of name of product
	 */
	public String getProduct(){
		return product;
	}

	/**
	 * This method sets name of product.
	 * @param product string of name of product
	 */
	public void setProduct(String product){
		this.product = product;
	}

	/**
	 * This method gets name of model.
	 * @return model string of name of model
	 */
	public String getModel(){
		return model;
	}

	/**
	 * This method sets name of model.
	 * @param model string of name of model
	 */
	public void setModel(String model){
		this.model = model;
	}

	/**
	 * This method gets color of furniture.
	 * @return color string of color of furniture
	 */
	public String getColor(){
		return color;
	}

	/**
	 * This method sets color of furniture.
	 * @param color String of type color of furniture
	 */
	public void setColor(String color){
		this.color = color;
	}

	/**
	 * This method gets branch of furniture.
	 * @return which_branch integer value branch of furniture
	 */
	public int getWhichBranch(){
		return which_branch;
	}

	/**
	 * This method sets branch of furniture.
	 * @param which_branch integer value branch of furniture
	 */
	public void setWhichBranch(int which_branch){
		this.which_branch = which_branch;
	}
}