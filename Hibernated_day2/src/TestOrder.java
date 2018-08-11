import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.pojo.Order;
import lti.util.HibernateUtil;

public class TestOrder {

	@Test
	public void testCase1() {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();	 		//starting db transaction
			Order order = new Order();
			order.setPromoCode("ABC");
			order.setOrderDate(new Date() );
			order.setAmount(5000);
			
			session.save(order);		//saving customer object
			txn.commit();			//ending transaction with commit
		} catch (Exception e) {
			txn.rollback();			// transaction failed hence rollback
			e.printStackTrace();
		}
	}
	
}
