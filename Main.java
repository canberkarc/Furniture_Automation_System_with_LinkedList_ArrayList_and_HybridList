
import java.util.Scanner;
import java.util.InputMismatchException;

/**
*@author Canberk Arici
*
*/

public class Main{

	/**
	 *
	 * Main method of this application.
	 * @param args Array of string arguments.
	 */
	public static void main(String[] args){
		Company company = new Company();
		
		Branch b1 = new Branch(1,"Pendik");
		Branch b2 = new Branch(2,"Maltepe");
		Branch b3 = new Branch(3,"Kadikoy");

		Customer c1 = new Customer("Tyrion", "Lannister", "tl@gmail.com", "tl123");
		Customer c2 = new Customer("Elon", "Musk", "elm@gmail.com", "elm123");
		
		BranchEmployee e1 = new BranchEmployee("Pendik", b1.getBranchId(), "John", "Snow", 1);
		BranchEmployee e2 = new BranchEmployee("Maltepe", b2.getBranchId(), "Arya", "Stark", 2);
		
		Furniture f1 = new Furniture("Office Chair", "M1", "Red", 1);
		Furniture f2 = new Furniture("Meeting Table","M1","Blue",2);
		Furniture f3 = new Furniture("Office Cabinet","M2","Brown",1);
		Furniture f4 = new Furniture("Office Desk","M3","Green",3);
		Furniture f5 = new Furniture("Bookcase","M2",2);
		
		Administrator admin = new Administrator("Canberk", "Arici");
		company.setAdmin(admin);

		company.getAdmin().addBranch(b1);
		company.getAdmin().addBranch(b2);
		company.getAdmin().addBranch(b3);

		company.getAdmin().addBranchEmployee(e1, 1);
		company.getAdmin().addBranchEmployee(e2, 2);

		company.getAdmin().addProduct(f1,1);
		company.getAdmin().addProduct(f2,2);
		company.getAdmin().addProduct(f3,2);
		company.getAdmin().addProduct(f4,3);
		company.getAdmin().addProduct(f5,1);

		e1.addCustomer(c1);
		e1.addCustomer(c2);

		int exit = 1;
		int customerIndex = -1;
		boolean loggedIn = false;
		String namee;
		String employeeName;
		String employeeSurname;
		@SuppressWarnings("resource")
        Scanner input= new Scanner(System.in);
        @SuppressWarnings("resource")
        Scanner inputString= new Scanner(System.in);

		while(exit != 0){
			System.out.println("\nWELCOME!");
			System.out.println("1- Login as Admin ");
            System.out.println("2- Login as Branch Employee");
            System.out.println("3- Login as Customer");
            System.out.println("0- EXIT ");
            System.out.println("Please enter your choice:");
            try{
            	exit = input.nextInt();
            }catch(InputMismatchException e){
		    	input.next();
		    	System.out.println("Please try with a number!!");
    			break;
			}

            while(exit > 3 || exit < 0){
            	System.out.println("Invalid choise!");
                System.out.println("Please enter valid choice:");
                try{	
                	exit = input.nextInt();
                }
				catch(InputMismatchException e){
		        	input.next();
		        	System.out.println("Please try with a number!!");
		        	break;
				}
            }

            switch(exit){
            	case 1:
            		System.out.println("\nWelcome "+company.getAdmin().getName() + " " + company.getAdmin().getSurname());
                    System.out.println("\n1- Add a branch");
                    System.out.println("2- Remove a branch");
                    System.out.println("3- Add a branch employee");
                    System.out.println("4- Remove a branch employee");
                    System.out.println("5- See all branches, employees and customers");
                    System.out.println("6- Query products that need to be supplied");
                    System.out.println("\nPlease enter your choice, input will be requested until input is valid: ");
	                try{ 
	                    do{
	                		exit = input.nextInt();
	                	}while(exit == 0);
	                }
					catch(InputMismatchException e){
					    	input.next();
					    	System.out.println("Please try with a number!!");
					    	break;
				    }
                    switch(exit){
                    	case 1:
                    		System.out.println("Please enter branch name that you want to add: ");
                    		namee = inputString.nextLine();
                            Branch newBranch = new Branch(company.getNumberOfBranches()+1,namee);
                            company.getAdmin().addBranch(newBranch);
                            company.showBranches();
                            break;

                        case 2:
                        	if(company.getNumberOfBranches() > 0)
                        		company.showBranches();
                        	else{
                        		System.out.println("There is no branch of company yet.");
                        		break;
                        	}
                        	System.out.println("Enter \"branch id\" that you want to remove, input will be requested until input is valid: ");
	                        try{
	                        	do{
	                        		exit = input.nextInt();
	                        	}while(exit == 0);
                        	}
    						catch(InputMismatchException e){
					    		input.next();
					    		System.out.println("Please try with a number!!");
					    		break;
				    		}
                        	int index = -1;
                        	if(company.getNumberOfBranches() > 0){
	                        	for(int i=0; i<company.getNumberOfBranches(); i++){
									if(company.getBranchList().get(i).getBranchId() == exit){
										index = i;
									}
								}
							}
							if(index != -1){
								company.getAdmin().removeBranch(company.getBranchList().get(index));
								company.showBranches();
							}
							else{
                        		System.out.println("There is no branch that you wanted.");
                        	}
                        	break;
                        
                        case 3:
                        	company.showBranches();
                        	boolean checkBranch = false;
                        	namee = "";
                        	int index3 = -1;
	                        while(checkBranch == false){
                        		System.out.println("Please enter \"branch name\" to add a branch employee:");
                            	namee = inputString.nextLine();
	                        	for(int i=0; i < company.getNumberOfBranches(); i++){
	                        		if(company.getBranchList().get(i).getBranchName().equals(namee)){
	                        				checkBranch = true;
	                        				index3 = company.getBranchList().get(i).getBranchId();
	                        				break;
	                        		}
	                        	}
	                        }

                        	System.out.println("Please enter employee name: ");
                            employeeName = inputString.nextLine();
                        	
                        	System.out.println("Please enter employee surname: ");
                            employeeSurname = inputString.nextLine();
                            
                            int employeeId = company.getNumberOfEmployees() + 1;
                            BranchEmployee newEmployee = new BranchEmployee(namee, index3, employeeName, employeeSurname, employeeId);
                            company.getAdmin().addBranchEmployee(newEmployee, index3);
                            company.showEmployees();
                            break;

                        case 4:
                        	if(company.getNumberOfEmployees() > 0)
                        		company.showEmployees();
                        	else{
                        		System.out.println("There is no employee of company yet.");
                        		break;
                        	}

                        	int brId = -1;

                    	  	checkBranch = false;
							while(checkBranch == false){
	                        	System.out.println("\nPlease enter \"branch id\" that you want to remove a branch employee:");
	                        	System.out.println("Input will be requested until input is valid");
								
	                        	try{
									brId = input.nextInt();
								}
								catch(InputMismatchException e){
							    	input.next();
							    	System.out.println("Please try with a number!!");
					    			break;
				    			}

								for(int i=0; i<company.getNumberOfBranches(); i++){
									if(company.getBranchList().get(i).getBranchId() == brId){
										checkBranch = true;
										break;
									}
	                        	}
	                        }

                        	System.out.println("Enter \"employee id\" that you want to remove:");
                        	System.out.println("Input will be requested until input is valid");

	                        try{
	                        	do{
	                        		exit = input.nextInt();
	                        	}while(exit == 0);
	                        }
	                        catch(InputMismatchException e){
							    	input.next();
							    	System.out.println("Please try with a number!!");
					    			break;
			    			}

                        	int index1 = -1;
                        	if(company.getNumberOfEmployees() > 0){
	                        	for(int i=0; i<company.getNumberOfEmployees(); i++){
									if(company.getEmployeeList().get(i).getId() == exit){
										index1 = i;
										break;
									}
								}
							}

							if(index1 != -1){
								company.getAdmin().removeBranchEmployee(company.getEmployeeList().get(index1), brId);
								company.showEmployees();								
							}
							else{
                        		System.out.println("There is no branch or employee that you wanted.");
                        	}
                        	break;

                        case 5:
							System.out.println(company);
							break;

						case 6:
							company.getAdmin().queryNeededProducts();
							break;
                    }
                    break;
               
                case 2:
                	if(company.getNumberOfEmployees() <= 0){
                		System.out.println("There is no branch employee.");
                		break;
                	}
                	System.out.println("\n1- Check product stock.");
                    System.out.println("2- Add product.");
                    System.out.println("3- Remove product.");
                    System.out.println("4- View previous orders of a customer.");
                    System.out.println("5- Make sale.");
                    System.out.println("Enter your choice, input will be requested until input is valid: ");
	                try{
	                    do{
	                		exit = input.nextInt();
	                	}while(exit == 0);
	                }
					catch(InputMismatchException e){
				    	input.next();
				    	System.out.println("Please try with a number!!");
				    	break;
				    }
                    switch(exit){
                    	case 1:
                    		company.getEmployeeList().get(0).seeProductList(); // HATA CIKARSA BURADAKI get'i BIR KONTROL ET //
                    		break;

                    	case 2:
                    		int numberToAdd = 0;
                    		String productName;
                    		String modelName;
                    		String color;
                    		company.getEmployeeList().get(0).seeProductList(); // HATA CIKARSA BURADAKI get'i BIR KONTROL ET //
                    		int control = 0;
	                    	while(control == 0){
	                    		System.out.println("\nPlease enter product name: ");
	                    		productName = inputString.nextLine();
	                    		System.out.println("Please enter model name: ");
	                    		modelName = inputString.nextLine();
	                    		System.out.println("Please enter color: ");
	                    		color = inputString.nextLine();
	                    		System.out.println("Please enter how many you want to add, input will be requested until input is valid: ");
	                    		
	                    		try{
		                    		do{
				                		numberToAdd = input.nextInt();
				                	}while(numberToAdd == 0);
			                	}
        						catch(InputMismatchException e){
							    	input.next();
							    	System.out.println("Please try with a number!!");
					    			break;
				    			}
			                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
			                		if(company.getFurnitureList()[i].getProduct().equals(productName) && company.getFurnitureList()[i].getModel().equals(modelName)){
			                			control = i;
			                			break;
			                		}
			                	}
	                    	}
                    		company.getEmployeeList().get(0).addProduct(company.getFurnitureList()[control],numberToAdd);
                    		company.getEmployeeList().get(0).seeProductList();
                    		break;

                    	case 3:
                    		company.getEmployeeList().get(0).seeProductList();
                    		int control1 = -1;
                    		int numToDelete = 0;
	                    	while(control1 == -1){
	                    		System.out.println("\nProduct's information will be requested until information is valid.");
	                    		System.out.println("Please enter product name: ");
	                    		productName = inputString.nextLine();
	                    		System.out.println("Please enter model name: ");
	                    		modelName = inputString.nextLine();
	                    		System.out.println("Please enter color: ");
	                    		color = inputString.nextLine();
	                    		System.out.println("Please enter how many you want to delete, input will be requested until input is not 0: ");
		                    	
		                    	try{
		                    		do{	
		                    			numToDelete = input.nextInt();
		                    		}while(numToDelete == 0);
			                	}
			                	catch(InputMismatchException e){
							    	input.next();
							    	System.out.println("Please try with a number!!");
					    			break;
				    			}

			                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
			                		if(company.getFurnitureList()[i].getProduct().equals(productName) && company.getFurnitureList()[i].getModel().equals(modelName)){
			                			control1 = i;
			                			break;
			                		}
			                	}
	                    	}
                    		company.getEmployeeList().get(0).removeProduct(company.getFurnitureList()[control1], numToDelete);
	                    	company.getEmployeeList().get(0).seeProductList();
	                    	break;

                    	case 4:
                    		company.showCustomers();
                    		System.out.println("Please select \"customer id\" that you want to see its previous orders: ");
                    		System.out.println("Input will be requested until input is valid: ");
                    		int customersNum = 0;
	                    	try{	
	                    		do{
	                        		customersNum = input.nextInt();
	                        	}while(customersNum == 0);
	                        }
	                        catch(InputMismatchException e){
	                        	input.next();
	                        	System.out.println("Please try with a number!!");
	                        	break;
	                        }
							company.getEmployeeList().get(0).viewPreviousOrders(customersNum);
							break;

						case 5:
							boolean cntrol = company.showCustomers();    
							if(cntrol == true){                    	
								
	                    		int customersId2 = -1;
                    			boolean checkBranch = false;
							
								while(checkBranch == false){
		                        	System.out.println("Please select \"customer number\" that you want to make sale: ");
									System.out.println("Input will be requested until input is valid:  ");
									
									try{
										exit = input.nextInt();
									}
									catch(InputMismatchException e){
								    	input.next();
								    	System.out.println("Please try with a number!!");
						    			break;
					    			}

									for(int i=0; i<company.getNumberOfBranches(); i++){
										if(company.getCustomerList().get(i).getCustomerNumber() == exit){
											checkBranch = true;
											customersId2 = exit;
											break;
										}
		                        	}
		                        }

	                        	company.getEmployeeList().get(0).seeProductList();

	                        	int control2 = 0;
	                        	String productName1;
	                    		String modelName1;
	                    		String color1;
	                        	while(control2 == 0){
		                    		System.out.println("\nPlease enter product name: ");
		                    		productName1 = inputString.nextLine();
		                    		System.out.println("Please enter model name: ");
		                    		modelName1 = inputString.nextLine();
		                    		System.out.println("Please enter color: ");
		                    		color1 = inputString.nextLine();
				                	
				                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
				                		if(company.getFurnitureList()[i].getProduct().equals(productName1) && company.getFurnitureList()[i].getModel().equals(modelName1)){
				                			control2 = i;
				                			break;
					                		}
					                	}
		                    	}
								company.getEmployeeList().get(0).makeSale(company.getCustomerList().get(customersId2-1), company.getFurnitureList()[control2]);
								if(company.getFurnitureList()[control2].getNumberInStock()-1 == 0 ){
									company.getFurnitureList()[control2].setNumberInStock(0);
								}
								else if(company.getFurnitureList()[control2].getNumberInStock() == 0){
									System.out.println("Manager informed, this product will be supplied soon.\n");
									company.getAdmin().addProduct(company.getFurnitureList()[control2], 5);
								}
								else{
									company.getFurnitureList()[control2].setNumberInStock(company.getFurnitureList()[control2].getNumberInStock()-1);
								}
								
								break;
							}
							else
								break;
                    		}

							break;

                case 3:
                	System.out.println("\n1- Login.");
                	System.out.println("2- View products list.");
                    System.out.println("3- Search a product.");
                    System.out.println("4- Buy");
                    System.out.println("5- View previous orders.");
                    System.out.println("Enter your choice, input will be requested until input is valid:");
	               try{
	                    do{
	                		exit = input.nextInt();
	                	}while(exit == 0);
	                }
	                catch(InputMismatchException e){
							    	input.next();
							    	System.out.println("Please try with a number!!");
					    			break;
	    			}

                	switch(exit){
                		case 1:
                			boolean check4case = false;
		    				System.out.println("\nLog In");
		    				System.out.println("Please enter your email");
		    				String emailC = inputString.nextLine();
		    				System.out.println("Please enter your password");
		    				String passwordC = inputString.nextLine();
		    				for(int i=0; i<company.getNumberOfCustomers(); i++){
		    					if(company.getCustomerList().get(i).getEmail().equals(emailC) && company.getCustomerList().get(i).getPassword().equals(passwordC)){
		    						loggedIn = true;
		    						check4case = true;
		    						customerIndex = company.getCustomerList().get(i).getCustomerNumber()-1;
		        					System.out.println("\nLog in successful.\n");
		    						break;
		    					}
		    				}

		    				if(check4case == false){
		        				System.out.println("\nThere is no customer with given email or password.\n");
		        				break;
		    				}
		    				break;

                		case 2:
                			if(company.getNumberOfCustomers() > 0)
                				company.getCustomerList().get(0).seeProductList();
                			else
		        				System.out.println("\nThere is no customer for now.\n");

                			break;

                		case 3:
                			int control3 = -1;
                			int index3 = 0;
                        	String productName2;
                    		String modelName2;
                    		String color2;
                        	
                    		company.seeProductList();

                    		System.out.println("\nPlease enter product name: ");
                    		productName2 = inputString.nextLine();
                    		System.out.println("Please enter model name: ");
                    		modelName2 = inputString.nextLine();
                    		System.out.println("Please enter color: ");
                    		color2 = inputString.nextLine();
		                	
		                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
		                		if(company.getFurnitureList()[i].getProduct().equals(productName2) && company.getFurnitureList()[i].getModel().equals(modelName2)){
		                			control3 = i;
		                			break;
			                		}
			                	}
	                    	
	                    	if(control3 != -1){
	                    		System.out.println("\nThere is this type of office furniture in the stock.\n");
	                    		break;
	                    	}
                			else{
                				System.out.println("\nSorry, we couldn't find product you wanted.\n");
                				break;
                			}

                		case 4:
                			boolean addressPh = false;
                			int howMany;
                			if(loggedIn == false){
                    			System.out.println("\nIf you are a subscribed customer please login else you have to subscribe to buy a product.");
                    			System.out.println("If you are a subscribed customer please enter yes else no:");
	            				String yesOrNo;
	            				int checkAns = -1;
	            				while(checkAns == -1){	
	            					yesOrNo = inputString.nextLine();
	            					if(yesOrNo.equals("yes")){
	            						checkAns = 1;
	            						break;
	            					}
	            					else if(yesOrNo.equals("no")){
	            						checkAns = 0;
	            						break;
	            					}
	            				}
	            				if(checkAns == 1){
                    				System.out.println("\nPlease login first\n");
                    				break;
	            				}
	            				else{
	            					String nameC;
	            					String surnameC;
                    				System.out.println("\nPlease enter your name:");
                    				nameC = inputString.nextLine();
                    				System.out.println("Please enter your surname:");
                    				surnameC = inputString.nextLine();
                    				System.out.println("Please enter your email:");
                    				emailC = inputString.nextLine();
                    				System.out.println("Please enter your password:");
                    				passwordC = inputString.nextLine();
                    				Customer newCustomer = new Customer(nameC, surnameC, emailC, passwordC);
                    				company.getEmployeeList().get(0).addCustomer(newCustomer);
                    				loggedIn = true;
                    				customerIndex = newCustomer.getCustomerNumber()-1;
	            				}

                			}
                			if(loggedIn == true){
	    						System.out.println("\nDo you want to buy online? Please write yes or no.\n");
	            				String yesOrNo2;
	            				int checkAns2 = -1;
	            				while(checkAns2 == -1){	
	            					yesOrNo2 = inputString.nextLine();
	            					if(yesOrNo2.equals("yes")){
	            						checkAns2 = 1;
	            						break;
	            					}
	            					else if(yesOrNo2.equals("no")){
	            						checkAns2 = 0;
	            						break;
	            					}
	            				}
	            				if(checkAns2 == 1){
		            				if(company.getCustomerList().get(customerIndex).getAddress().equals("None") || company.getCustomerList().get(customerIndex).getPhoneNumber().equals("None")) {
		            					String addressC;
		            					String phoneC;
		                				System.out.println("\nPlease enter your address:");
		                				addressC = inputString.nextLine();
		                				System.out.println("Please enter your phone number:");
		                				phoneC = inputString.nextLine();
		                				company.getCustomerList().get(customerIndex).setAddress(addressC);
		                				company.getCustomerList().get(customerIndex).setPhoneNumber(phoneC);
		                				addressPh = true;
		            				}
		            				if(!(company.getCustomerList().get(customerIndex).getAddress().equals("None") || company.getCustomerList().get(customerIndex).getPhoneNumber().equals("None")))
		            					addressPh = true;

		            				if(addressPh == true){
		            					index3 = -1;
			                        	
			                        	company.getEmployeeList().get(0).seeProductList();
			                    		System.out.println("\nPlease enter product name you want to buy: ");
			                    		productName2 = inputString.nextLine();
			                    		System.out.println("Please enter model name you want to buy: ");
			                    		modelName2 = inputString.nextLine();
			                    		System.out.println("Please enter color: ");
			                    		color2 = inputString.nextLine();
		                    			System.out.println("Please enter how many you want, input will be requested until input is valid: ");
				                    	try{	
				                    		do{
				                    			howMany = input.nextInt();
				                    		}while(howMany<0);
					                	}
					                	catch(InputMismatchException e){
									    	input.next();
									    	System.out.println("Please try with a number!!");
							    			break;
						    			}
					                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
					                		if(company.getFurnitureList()[i].getProduct().equals(productName2) && company.getFurnitureList()[i].getModel().equals(modelName2)){
					                			index3 = i;
					                			break;
						                		}
						                	}
				                    	
				                    	if(index3 != -1){
				                    		if(company.getFurnitureList()[index3].getNumberInStock() >= howMany){	
				                    			boolean checkBuy = company.getCustomerList().get(company.getNumberOfCustomers()-1).buy(company.getFurnitureList()[index3]);
				                    			
				                    			if(checkBuy == true){
			                						
			                						System.out.println("\nSale is done.");

				                					if(company.getFurnitureList()[index3].getNumberInStock()-1 == 0 ){
														company.getFurnitureList()[index3].setNumberInStock(0);
													}
													else if(company.getFurnitureList()[index3].getNumberInStock() == 0){
														System.out.println("Manager informed, this product will be supplied soon.\n");
														company.getAdmin().addProduct(company.getFurnitureList()[index3], 5);
													}
													else{
														company.getFurnitureList()[index3].setNumberInStock(company.getFurnitureList()[index3].getNumberInStock()-1);
													}	

			                					}
				                    			break;
				                    		}
					                    	else{
					                    		/* Inform Manager */
			                					System.out.println("\nSorry, we could not find the number of products you wanted.");
			                					System.out.println("Manager informed, this product will be supplied soon.\n");
			                					company.getAdmin().addProduct(company.getFurnitureList()[index3], howMany+5);
			                					break;
						                    	}
				                    	}
			                			else{
			                				System.out.println("\nSorry, we couldn't find product you wanted.\n");
			                				break;
			                			}
		            				}
		            			}
		            			else{
		            				index3 = -1;
		            				company.getEmployeeList().get(0).seeProductList();
		                    		System.out.println("\nPlease enter product name you want to buy: ");
		                    		productName2 = inputString.nextLine();
		                    		System.out.println("Please enter model name you want to buy: ");
		                    		modelName2 = inputString.nextLine();
		                    		System.out.println("Please enter color: ");
		                    		color2 = inputString.nextLine();
		                    		System.out.println("Please enter how many you want, input will be requested until input is valid: ");
			                    	try{
			                    		do{
			                    			howMany = input.nextInt();
			                    		}while(howMany<0);
				                	}
				                	catch(InputMismatchException e){
								    	input.next();
								    	System.out.println("Please try with a number!!");
						    			break;
					    			}
				                	for(int i=0; i<company.getNumberOfFurnitures(); i++){
				                		if(company.getFurnitureList()[i].getProduct().equals(productName2) && company.getFurnitureList()[i].getModel().equals(modelName2)){
				                			index3 = i;
				                			break;
					                		}
					                	}
			                    	
			                    	if(index3 != -1){
				                    	if(company.getFurnitureList()[index3].getNumberInStock() >= howMany){	
				                    		boolean checkBuy2 = company.getCustomerList().get(company.getNumberOfCustomers()-1).buy(company.getFurnitureList()[index3]);
					                    	if(checkBuy2 == true){	
					                    		System.out.println("\nSale is done.");

												if(company.getFurnitureList()[index3].getNumberInStock()-1 == 0 ){
													company.getFurnitureList()[index3].setNumberInStock(0);
												}
												else if(company.getFurnitureList()[index3].getNumberInStock() == 0){
													System.out.println("Manager informed, this product will be supplied soon.\n");
													company.getAdmin().addProduct(company.getFurnitureList()[index3], 5);
												}
												else{
													company.getFurnitureList()[index3].setNumberInStock(company.getFurnitureList()[index3].getNumberInStock()-1);
												}	
											}
				                    		break;
				                    	}
				                    	else{
		                					System.out.println("\nSorry, we could not find the number of products you wanted.");
		                					System.out.println("Manager informed, this product will be supplied soon.\n");
		                					company.getAdmin().addProduct(company.getFurnitureList()[index3], howMany+5);
		                					break;
				                    	}
			                    	}
		                			else{
		                				System.out.println("\nSorry, we couldn't find product you wanted.\n");
		                				break;
		                			}
		            			}
            				}
            	case 5:
            		if(loggedIn){
	            		company.getCustomerList().get(company.getNumberOfCustomers()-1).viewPreviousOrders();		
	            		break;
	            	}
	            	else{
        				System.out.println("\nYou have to log in firstly to see previous orders.\n");
	            		break;
	            	}
            	}
            }		
		}
	}
}