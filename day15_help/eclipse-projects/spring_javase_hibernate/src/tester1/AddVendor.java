package tester1;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.VendorProductIntf;

import pojos1.*;

public class AddVendor {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC started");
			System.out.println("Enyer vendor details nm pass ");
			Vendor v1 = new Vendor(sc.next(), sc.next());
			VendorProductIntf dao = ctx.getBean("vendor_dao", VendorProductIntf.class);
			System.out.println(dao.addVendor(v1));

		}

	}

}
