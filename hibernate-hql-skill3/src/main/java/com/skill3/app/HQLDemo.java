
package com.skill3.app;

import com.skill3.entity.Product;
import com.skill3.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Laptop", "Electronics", 55000, 10));
        session.persist(new Product("Mouse", "Electronics", 500, 50));
        session.persist(new Product("Keyboard", "Electronics", 1200, 20));
        session.persist(new Product("Chair", "Furniture", 3000, 5));
        session.persist(new Product("Table", "Furniture", 7000, 3));

        tx.commit();

        System.out.println("=== Sort by Price ASC ===");
        session.createQuery("from Product p order by p.price asc", Product.class)
                .getResultList().forEach(p -> System.out.println(p.getName()));

        System.out.println("=== Pagination First 3 ===");
        session.createQuery("from Product", Product.class)
                .setFirstResult(0).setMaxResults(3)
                .getResultList().forEach(p -> System.out.println(p.getName()));

        System.out.println("=== Total Count ===");
        Long count = session.createQuery("select count(p) from Product p", Long.class)
                .getSingleResult();
        System.out.println(count);

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
