package com.ty.carmanagementsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
@WebServlet("/saveUpdateCar")
public class SaveUpdatedCar  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
	    Transaction beginTransaction = session.beginTransaction();
	    
	    int carId= Integer.parseInt(req.getParameter("carId"));
		int carPrice= Integer.parseInt(req.getParameter("carPrice"));
		String carModel=req.getParameter("carModel");
		String carBrand= req.getParameter("carBrand");
	    
	    
		Car car= new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarPrice(carPrice);
	    
	session.update(car);
	    
	    beginTransaction.commit();
	    
	    Query<Car> createQuery = session.createQuery("FROM Car");
	     
	   
	    List<Car> cars = createQuery.list();
	    
	    req.setAttribute("carsList", cars);
	    
	    RequestDispatcher dispatcher= req.getRequestDispatcher("displayCars.jsp");
	    dispatcher.forward(req, resp);
	}
}
