package tester;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.app.service.VendorServiceIntf;

import pojos.Vendor;

public class DisplayVendorList {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml"))
		{
			System.out.println("SC started....");
			//get service bean from SC & invoke B.L
			VendorServiceIntf service=ctx.getBean("vendorService", VendorServiceIntf.class);
			System.out.println("Displaying Vendors ...........");
			List<Vendor> l1=service.listVendors();
			l1.forEach(System.out::println);
			System.out.println("Displaying vehicles.............");
			l1.forEach(v->v.getVehicles().forEach(System.out::println));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
