package lti.pojo.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.util.HibernateUtil;

public class DeptEmpTest {
	@Test
	public void testCase1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
 
		Department dept = new Department();
		dept.setDeptno(10);
		dept.setName("Admin");
		dept.setLocation("Andheri,Mumbai");

		session.save(dept);
		tx.commit();
	}

	@Test
	public void testCase2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Department dept = (Department) session.get(Department.class, 10);
		Employee emp = new Employee();
		emp.setEmpno(1005);
		emp.setName("Neha Padshala");
		emp.setSalary(3000.0);
		emp.setDept(dept);

		session.save(emp);
		tx.commit();

	}

	@Test
	public void testcase3() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Department dept = (Department) session.get(Department.class, 10);
		System.out.println(dept.getName());
		System.out.println(dept.getEmployees());
		tx.commit();
	}
}
