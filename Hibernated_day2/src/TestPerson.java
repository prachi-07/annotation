import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.pojo.Book;
import lti.pojo.Person;
import lti.util.HibernateUtil;

public class TestPerson {
	@Test
	public void testSaveBook() {
		Session session = HibernateUtil.getSession();
		Person p = new Person(new Person.Id("India",12345),"Polo",21);
		Transaction txn = session.beginTransaction();
		session.save(p);
		txn.commit();
	}
}
