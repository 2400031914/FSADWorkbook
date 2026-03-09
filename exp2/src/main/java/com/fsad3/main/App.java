package com.fsad3.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fsad3.entity.Product;
import com.fsad3.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Scanner laptop = new Scanner(System.in);

        while (true) {

            System.out.println("===== Product CRUD MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int windows = laptop.nextInt();

            Session phone = HibernateUtil.getSessionFactory().openSession();
            Transaction apple = phone.beginTransaction();

            switch (windows) {

            case 1:

            	phone = HibernateUtil.getSessionFactory().openSession();
            	apple = phone.beginTransaction();

                System.out.print("Enter ID: ");
                int samsung = laptop.nextInt();
                laptop.nextLine();

                System.out.print("Enter Name: ");
                String sony = laptop.nextLine();

                System.out.print("Enter Description: ");
                String dell = laptop.nextLine();

                System.out.print("Enter Price: ");
                double hp = laptop.nextDouble();

                System.out.print("Enter Quantity: ");
                int asus = laptop.nextInt();

                Product lenovo = new Product(samsung, sony, dell, hp, asus);

                phone.persist(lenovo);
                apple.commit();

                System.out.println("Product Added Successfully");

                phone.close();

            break;

            case 2:

                phone = HibernateUtil.getSessionFactory().openSession();

                System.out.print("Enter Product ID: ");
                int pid = laptop.nextInt();

                Product dell1 = phone.get(Product.class, pid);

                if(dell1 != null){

                    System.out.println("ID: " + dell1.getId());
                    System.out.println("Name: " + dell1.getName());
                    System.out.println("Description: " + dell1.getDes());
                    System.out.println("Price: " + dell1.getPrice());
                    System.out.println("Quantity: " + dell1.getQuantity());

                } else {

                    System.out.println("Product Not Found");

                }

                phone.close();

            break;

            case 3:
                // Update Product
                System.out.print("Enter Product ID to Update: ");
                int id = laptop.nextInt();

                Product p = phone.get(Product.class, id);

                if(p != null) {

                    laptop.nextLine();

                    System.out.print("Enter New Name: ");
                    String name = laptop.nextLine();

                    System.out.print("Enter New Description: ");
                    String des = laptop.nextLine();

                    System.out.print("Enter New Price: ");
                    double price = laptop.nextDouble();

                    System.out.print("Enter New Quantity: ");
                    int quantity = laptop.nextInt();

                    p.setName(name);
                    p.setDes(des);
                    p.setPrice(price);
                    p.setQuantity(quantity);

                    phone.update(p);
                    apple.commit();

                    System.out.println("Product Updated Successfully");

                } else {
                    System.out.println("Product Not Found");
                }

            break;

            case 4:

                System.out.print("Enter Product ID to Delete: ");
                int pid1 = laptop.nextInt();

                Product d = phone.get(Product.class, pid1);

                if(d != null) {

                    phone.delete(d);
                    apple.commit();

                    System.out.println("Product Deleted Successfully");

                } else {
                    System.out.println("Product Not Found");
                }

            break;

            case 5:
                System.exit(0);

            }

            phone.close();
        }
    }
}