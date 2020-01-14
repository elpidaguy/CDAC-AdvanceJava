package id_gen;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import pojos.MyEmp;

public class EmpIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("in generate "+arg0+" "+arg1);
		MyEmp e=(MyEmp) arg1;
		String jpql="select count(*) from MyEmp e";
		String id=e.getCity()+"_"+e.getDept()+"_"+(arg0.createQuery(jpql,Long.class).getSingleResult()+1);
		System.out.println("emp id "+id);
		return id;
	}

}
