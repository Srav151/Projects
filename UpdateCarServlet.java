package com.ty.carmanagementsystem;

import java.io.IOException;

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
@WebServlet("/UpdateCar")
public class UpdateCarServlet extends  HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId= Integer.parseInt(req.getParameter("carId"));
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
	    Transaction beginTransaction = session.beginTransaction();
	    
	    Car car= session.find(Car.class, carId);
	    
	    req.setAttribute("car", car);
	    RequestDispatcher dispatcher= req.getRequestDispatcher("updateCar.jsp");
	    dispatcher.forward(req, resp);
	    
	    
	}
}
