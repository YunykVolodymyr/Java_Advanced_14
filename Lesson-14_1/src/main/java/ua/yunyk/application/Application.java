package ua.yunyk.application;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.yunyk.model.Cart;
import ua.yunyk.model.Item;

public class Application {

	public static void main(String[] args) {

		Cart cart = new Cart(0, "cart1");
		Item item0 = new Item(1000);
		Item item1 = new Item(1001);
		Item item2 = new Item(1002);
		Item item3 = new Item(1003);
		cart.setItems(new HashSet<Item>(Arrays.asList(item0, item1, item2, item3)));

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		session.close();

	}

}
