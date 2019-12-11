package tester;

import java.time.LocalDate;
import java.util.Scanner;

import dao.VendorDaoImpl;
import pojos.Vendor;

public class RegisterVendorTester {

	public static void main(String[] args) {
		
		VendorDaoImpl vdi = new VendorDaoImpl();
		boolean flag = true;
		try(Scanner sc = new Scanner(System.in))
		{
		while(flag)
		{
			System.out.println("Menu");
			System.out.println("1.Register a Vendor");
			System.out.println("2.Get Vendor Details");
			System.out.println("3.List all Vendors");
			System.out.println("4.List User by City and Reg Date");
			System.out.println("5.Update city and phone");
			System.out.println("6.Remove Vendor");
			System.out.println("7.Exit");
			System.out.println("Enter Choice: ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter Details: ");
				System.out.println("name, email, password, city, phone, registration amount, registration date");
				System.out.println(vdi.registerVendor(new Vendor(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()))));
				break;
				
			case 2:
				System.out.println("Enter Vendor Id");
				System.out.println(vdi.getDetails(sc.nextInt()));
				break;
			case 3:
				System.out.println("All vendors: ");
				
				for(Vendor v : vdi.getAllVendors())
				{
					System.out.println(v);
				}
				break;
				
			case 4:
				System.out.println("Enter City and Registration Date to view Vendors");
				for(Vendor v : vdi.getSelectedVendors(sc.next(), LocalDate.parse(sc.next())))
				{
					System.out.println(v);
				}
				break;
				
			case 5:
				System.out.println("Enter ID, New City and New Phone Number for Vendor");
				System.out.println(vdi.updateVendorDetails(sc.nextInt(), sc.next(), sc.next()));
				break;

			case 6:
				System.out.println("Enter ID of Vendor to delete");
				System.out.println(vdi.deleteVendorDetails(sc.nextInt()));
				break;
				
			case 7:
				flag=false;
				break;
				
			default:
				break;
			}
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
