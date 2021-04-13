/**
*@author Canberk Arici
*
*/
import java.util.ListIterator;

public class Administrator extends Company implements Person{

	/**
	 * That string is the name of administrator.
	 */
	private String name;

	/**
	 * That string is the surname of administrator.
	 */
	private String surname;

	/**
	 * Two-parameter Constructor
	 * @param name string of the admin's name.
	 * @param surname string of the admin's surname.
	 */
	public Administrator(String name, String surname){
		this.name = name;
		this.surname = surname;
	}

	/**
	 * That method gets the admin's name.
	 * @return name string of the admin's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * That method sets the admin's name.
	 * @param name string of the admin's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;	
	}

	/**
	 * That method gets the admin's surname.
	 * @return surname string of the admin's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	
	/**
	 * That method sets the admin's surname.
	 * @param surname string of the admin's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * That method adds branch to branchList
	 * @param newBranch Branch object to be added
	 */
	public void addBranch(Branch newBranch){
		int check = 0;
		if(branchList.size() > 0){
			for(int i=0; i<branchList.size(); i++){
				if(branchList.get(i).getBranchName().equals(newBranch.getBranchName()))
					check = 1;
			}
		}
		if(check == 1){
			System.out.println(newBranch.getBranchName() + " branch is not added because it exists already.\n");
			return;
		}
		else{
				branchList.addFirst(newBranch);
				System.out.println(newBranch.getBranchName() + " branch is added.\n");
		}
	}
	
	/**
	 * That method removes branch from branchList
	 * @param rBranch Branch object to be removed
	 */
	public void removeBranch(Branch rBranch){
		int index = -1;
		if(branchList.size() == 0){
			System.out.println("There is no branch to remove\n");
			return;
		}
		else{	
			index = branchList.indexOf(rBranch);
		if(index != -1){
			
			ListIterator<Branch> iter = branchList.listIterator();
			
			if(branchList.size() == 1){
				iter.next();
				iter.remove();
			}
			else{
				int ind = 0;
				while(ind != branchList.indexOf(rBranch)){
					ind++;
					iter.next();
				}
				iter.next();
				iter.remove(); /* Delete wanted branch*/

				System.out.println(rBranch.getBranchName() + " is removed \n");
			}	
		}
		else
			System.out.println(rBranch.getBranchName() + " is not found therefore couldn't deleted\n");
		}
	}

	/**
	 * That method adds branch employee from a branch's employee list
	 * @param newEmployee BranchEmployee object to be added
	 * @param branchId integer value that is id of branch 
	 */
	public void addBranchEmployee(BranchEmployee newEmployee, int branchId){
		int check = 0;
		for(int i=0; i<branchList.size(); i++){
			if(branchList.get(i).getBranchId() == branchId){
				check = 1;
			}
		}
		if(check == 1){
			if(employeeList.size() > 0){
				for(int i=0; i<employeeList.size(); i++){
					if(branchList.get(branchId).employeeList.get(i) == newEmployee){
						System.out.println(newEmployee.getName() + " cannot be added in " + branchList.get(branchId).getBranchName() + " because already in there.\n");
						return;
					}
				}
			}

		branchList.get(branchId-1).employeeList.add(newEmployee);
		int new_emp_index = employeeList.size();

		branchList.get(branchId-1).employeeList.get(new_emp_index).setBranchId(branchList.get(branchId-1).getBranchId());
		branchList.get(branchId-1).employeeList.get(new_emp_index).setBranchName(branchList.get(branchId-1).getBranchName());
		System.out.println(newEmployee.getName() + " " + newEmployee.getSurname() + " is added to " + branchList.get(branchId-1).getBranchName() + ".\n");
		}
		if(check == 0)
			System.out.println("Branch " + branchId + " is not found in the company.\n");
	}

	/**
	 * That method removes branch employee to a Company's employee list
	 * @param rEmployee BranchEmployee object to be added
	 * @param branchId integer value that is id of branch 
	 */
	public void removeBranchEmployee(BranchEmployee rEmployee, int branchId){
		for(int i=0; i < branchList.size(); i++){
			if(branchList.get(i).getBranchId() == branchId){
				int empIndex = -1;
				
				if(branchList.get(i).employeeList.indexOf(rEmployee) != -1){
					empIndex = branchList.get(i).employeeList.indexOf(rEmployee);
					break;
				}

				if(empIndex != -1){
					branchList.get(i).employeeList.remove(empIndex);
					System.out.println(rEmployee.getName() + " " + rEmployee.getSurname() + " is removed from " + branchList.get(i).getBranchName() + " \n");	
				}
				else
					System.out.println(rEmployee.getName() + " " + rEmployee.getSurname() + " is not removed from " + branchList.get(i).getBranchName() + " because it is not found.\n");
			}
		}
		
	}

	/**
	 * That method prints branch names
	 */
	public void getBranches(){
		if(branchList.size() >0){
			for(int i=0; i<branchList.size(); i++){
				System.out.println(branchList.get(i).getBranchName());
			}
		}
		else
			System.out.println("There is no branch of this company yet.\n");
	}

	/**
	 * That method prints information of employees
	 */
	public void getEmployees(){
		if(employeeList.size() > 0){
			for(int i=0; i<employeeList.size(); i++){
				System.out.println(employeeList.get(i).getName() + " " + employeeList.get(i).getSurname());
			}
		}
		else
			System.out.println("There is no branch of this company yet.\n");
	}

	/**
	 * This method adds the new product to Company's furniture list
	 * @param f Furniture object to be added to furnitureList array.
	 * @param numberToAdd integer value that is number of furnitures to be added.
	 */

	////////////////////****************** BU METODA FURNITURE'I DUZELTTIKTEN SONRA BAK ********************/////////////////
	public void addProduct(Furniture f, int numberToAdd){
		if(numberToAdd == 0){
			System.out.println("Number of product to be added must be greater than 1.\n");
		}
		else if(numberToAdd > 0 && numberOfFurnitures > 0){
			int check = -1;
			for(int i=0; i<numberOfFurnitures; i++){
				if(furnitureList[i].getProduct() == f.getProduct() && furnitureList[i].getModel() == f.getModel()){
					check = i;
					break;
				}
			}
			if(check != -1){
				furnitureList[check].setNumberInStock(furnitureList[check].getNumberInStock() + numberToAdd);
			}
			else{
				furnitureList[numberOfFurnitures] = f;
				furnitureList[numberOfFurnitures].setNumberInStock(furnitureList[numberOfFurnitures].getNumberInStock() + numberToAdd);
				numberOfFurnitures += 1;
			}
		}
		else if(numberToAdd > 0 && numberOfFurnitures == 0){
			furnitureList[numberOfFurnitures] = f;
			furnitureList[numberOfFurnitures].setNumberInStock(furnitureList[numberOfFurnitures].getNumberInStock() + numberToAdd);
			numberOfFurnitures += 1;
		}		
	}

	/**
	 * That method show whether there is any product to be queried
	 */
	////////////////////****************** BU METODA FURNITURE'I DUZELTTIKTEN SONRA BAK ********************/////////////////
	public void queryNeededProducts(){
		int count = 0;
		if(numberOfFurnitures > 0){
			for(int i=0; i<numberOfFurnitures; i++){
				if(furnitureList[i].getNumberInStock() == 0){
					System.out.println("Product: " + furnitureList[i].getProduct());
					System.out.println("Model: " + furnitureList[i].getModel());
					System.out.println("Color: " + furnitureList[i].getColor());
					System.out.println("Number in stock: " + furnitureList[i].getNumberInStock());
					System.out.println("Branch: " + furnitureList[i].getWhichBranch());
					System.out.println("\n");
				}
				else
					count += 1;
			}
			if(count == numberOfFurnitures){
			System.out.println("There is no product that need to be supplied\n");
			}
		}
		else{
			System.out.println("There is no furniture yet.\n");
		}
	}
}