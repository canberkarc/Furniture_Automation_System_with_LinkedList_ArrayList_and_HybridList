/**
*@author Canberk Arici
*
*/

public class Customer extends Company implements Person{
	/**
	 * Name of the customer.
	 */
	private String name;

	/**
	 * Surname of the customer.
	 */
	private String surname;

	/**
	 * Address of the customer.
	 */
	private String address;

	/**
	 * Phone number of the customer.
	 */
	private String phoneNumber;

	/**
	 * E-mail of the customer.
	 */
	private String email;

	/**
	 * Password of the customer.
	 */
	private String password;

	/**
	 * Customer number of the customer.
	 */
	private int customer_number;

	/**
	 * Array of previous orders of the customer.
	 */
	private HybridList<Furniture> previousOrders = new HybridList<Furniture>();

	/**
	 * Customer four-parameter Constructor
	 * @param name string of the customer's name.
	 * @param surname string of the customer's surname.
	 * @param email string of the customer's email.
	 * @param password string of the customer's password.
	 */
	public Customer(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = "None";
		this.phoneNumber = "None";
		this.customer_number = 0;
	}

	/**
	 * Customer six-parameter Constructor
	 * @param name string of the customer's name.
	 * @param surname string of the customer's surname.
	 * @param email string of the customer's email.
	 * @param password string of the customer's password.
	 * @param address string of the customer's address.
	 * @param phoneNumber string of the customer's phone number.
	 */
	public Customer(String name, String surname, String email, String password, String address, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customer_number = 0;
	}

	/**
	* That method gets previous orders list
	* @return previousOrders array of Furniture objects
	*/
	public HybridList<Furniture> getPreviousOrders(){
		return previousOrders;
	}

	/**
	 * That method sets the customer's name.
	 * @param name string of the customer's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;	
	}

	/**
	 * That method gets the customer's name.
	 * @return name string of the customer's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * That method sets the customer's surname.
	 * @param surname string of the customer's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * That method gets the customer's surname.
	 * @return surname string of the customer's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}

	/**
	 * That method sets the customer's address.
	 * @param address string of the customer's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * That method gets the customer's address.
	 * @return address string of the customer's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * That method sets the customer's phone number.
	 * @param phoneNumber string of the customer's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * That method gets the customer's phone number.
	 * @return phoneNumber string of the customer's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * That method sets the customer's e-mail.
	 * @param email string of the customer's e-mail.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * That method gets the customer's e-mail.
	 * @return email string of the customer's e-mail.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * That method sets the customer's password.
	 * @param password string of the customer's password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * That method gets the customer's password.
	 * @return password string of the customer's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * That method sets the customer's customer number.
	 * @param customer_number integer value of the customer's customer number.
	 */
	public void setCustomerNumber(int customer_number) {
		this.customer_number = customer_number;
	}
		
	/**
	 * That method gets the customer's customer number.
	 * @return customer_number integer value of the customer's customer number.
	 */	
	public int getCustomerNumber() {
		return customer_number;
	}

	/**
	 * That method prints the furnitures.
	 */
	public void seeProductList(){
		int count = 0;
		for(int i=0; i<furnitureList.size(); i++){ 
			for(int j=0; j<furnitureList.get(i).size(); j++){
				if(furnitureList.get(i).get(j).getNumberInStock() > 0){
					System.out.println("Product: " + furnitureList.get(i).get(j).getProduct());
					System.out.println("Model: " + furnitureList.get(i).get(j).getModel());
					System.out.println("Color: " + furnitureList.get(i).get(j).getColor());
					System.out.println("Number in stock: " + furnitureList.get(i).get(j).getNumberInStock());
					System.out.println("Branch: " + furnitureList.get(i).get(j).getWhichBranch());
					System.out.println("\n");
				}
				else{
					System.out.println("***SOLD OUT***");
					System.out.println("Product: " + furnitureList.get(i).get(j).getProduct());
					System.out.println("Model: " + furnitureList.get(i).get(j).getModel());
					System.out.println("Color: " + furnitureList.get(i).get(j).getColor());
					System.out.println("Number in stock: " + furnitureList.get(i).get(j).getNumberInStock());
					System.out.println("Branch: " + furnitureList.get(i).get(j).getWhichBranch());
					System.out.println("\n");
					count += 1;
				}
			}
		}
		if(count == furnitureList.getElCount())
			System.out.println("Sorry, all stock is empty now");
	}

	/**
	* That method searchs for a given furniture in furniture list
	* @param fur Furniture object of furniture to be searched
	* @return boolean boolean value that means found or not found
	*/
	public boolean searchAproduct(Furniture fur){
		boolean check = false;
		for(int i=0; i<furnitureList.size(); i++){
			if(furnitureList.get(i).indexOf(fur) != -1){
				System.out.println("There is this type of office furniture in the stock.\n");
				return true;
			}
		}
		System.out.println("Sorry, we couldn't find product you wanted.\n");
		return false;
	}

	/**
	* That method sets previous orders of a customer with a given furniture
	* @param f Furniture object of furniture that bought by customer
	*/
	public void setPreviousOrders(Furniture f){
		this.previousOrders.addElement(f);
	}

	/**
	* That method prints a customer's previous orders
	*/
	public void viewPreviousOrders(){
		if(this.previousOrders.getElCount() >0){
			System.out.println("Previous Orders: \n\n");

			for(int i=0; i<furnitureList.size(); i++){
				for(int j=0; j<furnitureList.get(i).size(); j++){
					System.out.println("Product: " + this.previousOrders.get(i).get(j).getProduct() + ".\n");
					System.out.println("Model: " + this.previousOrders.get(i).get(j).getModel() + ".\n");
					System.out.println("Color: " + this.previousOrders.get(i).get(j).getColor() + ".\n");
					System.out.println("\n");
				}
			}
		}
		else
			System.out.println("There is no previous order. \n");
	}

	/**
	* That method makes customer buy furniture in furniture list
	* @param fur Furniture object of furniture to be bought
	* @return boolean boolean value that means bought or not
	*/
	public boolean buy(Furniture fur){
		int check = 0, check2 = 0;
		
		if(furnitureList.getElCount() > 0){	
			for(int i=0; i<furnitureList.size(); i++){
				for(int j=0; j<furnitureList.get(i).size(); j++){
					
					if(furnitureList.get(i).get(j).getProduct().equals(fur.getProduct()) && furnitureList.get(i).get(j).getModel().equals(fur.getModel())) {
						if(furnitureList.get(i).get(j).getNumberInStock() == 0){
							check2 = 1;
						}
						check = 1;
						break;				
					}

				}
			}
		}
		if(check == 1 && check2 == 0){
			this.setPreviousOrders(fur);
			return true;
		}
		else if(check == 1 && check2 == 1){
			System.out.println("Sorry, we don't have enough number of this product in our stock.\n");
			return false;
		}
		else{
			System.out.println("Sorry, we couldn't find product you wanted.\n");
			return false;
		}
	}

	/**
	 *This method returns string representation of Customer object.
	 *@return string of representation of Customer object
	 */
	@Override
	public String toString(){
		String str = "";
		if(customerList.size() > 0){	
			str += "Customer Information: \n\n";
			str += "Name: ";
			str += this.getName();
			str += "\n";
			str += "Surname: ";
			str += this.getSurname();
			str += "\n";
			str += "Email: ";
			str += this.getEmail();
			str += "\n";
			str += "Customer Number: ";
			str += this.getCustomerNumber();
			str += "\n";
		}
		return str;
	}
}