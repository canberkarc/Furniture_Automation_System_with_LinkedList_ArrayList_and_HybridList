/**
*@author Canberk Arici
*
*/ 

public class Company{

	/**
	* This static array in type Branch is the branches' list
	*/
	protected static KWLinkedList<Branch> branchList = new KWLinkedList<Branch>();
	/**
	* This static array in type BranchEmployee is the employees' list
	*/
	protected static KWArrayList<BranchEmployee> employeeList = new KWArrayList<BranchEmployee>();
	/**
	* This static array in type Furniture is the customers' list
	*/
	protected static KWArrayList<Customer> customerList = new KWArrayList<Customer>();
	/**
	* This static array in type Furniture is the furnitures' list
	*/
	protected static HybridList<Furniture> furnitureList = new HybridList<Furniture>();

	/**
	* This Administrator type value is administrator
	*/
	private Administrator admin;

	/** No parameter constructor
	*
	*/
	public Company(){}

	/**
	 * This method gives number of branches.
	 * @return integer.
	 */
	public int getNumberOfBranches(){
		return branchList.size();
	}

	/**
	 * This method gives number of furnitures.
	 * @return integer.
	 */
	public int getNumberOfFurnitures(){
		return furnitureList.getElCount();
	}

	/**
	 * This method gives number of employees.
	 * @return integer.
	 */
	public int getNumberOfEmployees(){
		return employeeList.size();
	}

	/**
	 * This method gives number of customers.
	 * @return integer.
	 */
	public int getNumberOfCustomers(){
		return customerList.size();
	}

	/**
	 * This method gives array of Branch objects.
	 * @return Branch type array.
	 */
	public KWLinkedList<Branch> getBranchList(){
		return branchList;
	}

	/**
	 * This method gives array of BranchEmployee objects.
	 * @return BranchEmployee type array.
	 */
	public KWArrayList<BranchEmployee> getEmployeeList(){
		return employeeList;
	}

	/**
	 * This method gives array of Furniture objects.
	 * @return Furniture type array.
	 */
	public HybridList<Furniture> getFurnitureList(){
		return furnitureList;
	}

	/**
	 * This method gives array of Customer objects.
	 * @return Customer type array.
	 */
	public KWArrayList<Customer> getCustomerList(){
		return customerList;
	}

	/**
	 * That method sets the admin.
	 * @param admin the Administrator object.
	 */
	public void setAdmin(Administrator admin){
		this.admin = admin;
	}

	/**
	 * That method sets the admin.
	 * @param admin the Administrator object.
	 */
	public Administrator getAdmin(){
		return admin;
	}

	/**
	 * That method prints the branch array.
	 */
	public void showBranches(){
		String str = "";
		if(branchList.size() > 0){	
			str += "Branches of Company: \n\n";
			for(int i=0; i<branchList.size(); i++){
				str = str + "Branch Name: " + branchList.get(i).getBranchName();
				str += "\n";
				str = str + "Branch Id: " + branchList.get(i).getBranchId();
				str += "\n";
			str += "\n\n";
			}
		}
		System.out.println(str);
	}

	/**
	 * That method prints the customer array.
	 */
	public boolean showCustomers(){
		String str = "";
		if(customerList.size() > 0){	
			str += "Customers of Company: \n\n";
			for(int i=0; i<customerList.size(); i++){
				str = str + "Name: " + customerList.get(i).getName();
				str += "\n";
				str = str + "Surname: " + customerList.get(i).getSurname();
				str += "\n";
				str = str + "Customer Number: " + customerList.get(i).getCustomerNumber();
				str += "\n";
			str += "\n\n";
			}
		}
		else{
			str += "There is no customer yet.";
			return false;
		}
		System.out.println(str);
		return true;
	}

	/**
	 * That method prints the employee array.
	 */
	public void showEmployees(){
		String str = "";
		if(employeeList.size() > 0){	
			str += "Employees of Company: \n\n";
			for(int i=0; i<employeeList.size(); i++){
				str = str + "Name: " + employeeList.get(i).getName();;
				str += "\n";
				str = str + "Surname: " + employeeList.get(i).getSurname();
				str += "\n";
				str += "Employee Id: " + employeeList.get(i).getId();
				str += "\n";
				str = str + "Branch Id: " + employeeList.get(i).getBranchId();
				str += "\n";
			str += "\n\n";
			}
		}
		else
			str = str + "There is no employee in the company\n";
		System.out.println(str);
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
	 *This method returns string representation of Company object.
	 *@return string of representation of Company object
	 */
	@Override
	public String toString(){
		String str = "";
		if(branchList.size() > 0){	
			str += "Branches of Company: \n\n";
			for(int i=0; i<branchList.size(); i++){
				str = str + "Branch Name: " + branchList.get(i).getBranchName();
				str += "\n";
				str = str + "Branch Id: " + branchList.get(i).getBranchId();
				str += "\n";
			str += "\n\n";
			}
		}
		else{
			str += "Branches of Company: \n\n";
			str = str + "There is no branch of the company.\n";
			str += "\n\n";
		}
		if(employeeList.size() > 0){	
			str += "Employees of Company: \n\n";
			for(int i=0; i<employeeList.size(); i++){
				str = str + "Name: " + employeeList.get(i).getName();;
				str += "\n";
				str = str + "Surname: " + employeeList.get(i).getSurname();
				str += "\n";
				str += "Employee Id: " + employeeList.get(i).getId();
				str += "\n";
				str = str + "Branch Id: " + employeeList.get(i).getBranchId();
				str += "\n";
				str += "Branch Name: ";
				str += branchList.get(i).getBranchName();
			str += "\n\n";
			}
		}
		else{
			str += "Employees of Company: \n\n";
			str = str + "There is no employee of the company.\n";
			str += "\n\n";
		}
		if(customerList.size() > 0){	
			str += "Customers of Company: \n\n";
			for(int i=0; i<customerList.size(); i++){
				str = str + "Name: " + customerList.get(i).getName();
				str += "\n";
				str = str + "Surname: " + customerList.get(i).getSurname();
				str += "\n";
				str = str + "Customer Number: " + customerList.get(i).getCustomerNumber();
				str += "\n";
			str += "\n\n";
			}
		}
		else{
			str += "Customers of Company: \n\n";
			str = str + "There is no customer of the company.\n";
			str += "\n\n";
		}
		return str;
	}


}