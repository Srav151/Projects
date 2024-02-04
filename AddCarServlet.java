package com.ty.carmanagementsystem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
@WebServlet("/addCar")
public class AddCarServlet  extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int carId= Integer.parseInt(req.getParameter("carId"));
	int carPrice= Integer.parseInt(req.getParameter("carPrice"));
	String carModel=req.getParameter("carModel");
	String carBrand= req.getParameter("carBrand");
	
	Car car= new Car();
	car.setCarId(carId);
	car.setCarModel(carModel);
	car.setCarBrand(carBrand);
	car.setCarPrice(carPrice);
	
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();
	session.save(car);
	transaction.commit();
	session.close();
	resp.sendRedirect("index.jsp");
}
}
