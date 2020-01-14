package tester1;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.VendorProductIntf;

import pojos1.*;

public class AddVendorProduct {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC started");
			System.out.println("Enter vendor product details vid pid price ");

			VendorProductIntf dao = ctx.getBean("vendor_dao", VendorProductIntf.class);
			System.out.println(dao.addVendorProduct(sc.nextLong(), sc.nextLong(), sc.nextDouble()));

		}

	}

}
