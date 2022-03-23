package com.arp.lti.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.arp.lti.beans.Admin;
import com.arp.lti.beans.Flight;
import com.arp.lti.beans.User;
import com.arp.lti.exception.AdminNotFoundException;
import com.arp.lti.exception.FlightNotFoundException;
import com.arp.lti.exception.UserAlreadyExistsException;
import com.arp.lti.exception.UserNotFoundException;

@Repository("adminDao")
@EnableTransactionManagement
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager em;
	

	public List<Flight> getAllFlights() {
		String sql= "SELECT f FROM Flight f";
		Query q = em.createQuery(sql);
		List <Flight> flightList = q.getResultList();
		return flightList;
		
	}

	@Override
	public Flight getFlightById(int flightId) throws FlightNotFoundException{
			// TODO Auto-generated method stub
			/*
			 * Flight f = em.find(Flight.class, flightId); return f;
			 */
		String sql = "SELECT f FROM Flight f where f.flightId= :flightId";
		TypedQuery<Flight> tq = em.createQuery(sql, Flight.class);
		tq.setParameter("flightId", flightId );
		try
		{
			Flight flight=tq.getSingleResult();
			return flight;
		}
		catch(Exception e)
		{
			throw new FlightNotFoundException("No such flight exists");
		}
	}
	@Override
	@Transactional
	public String deleteFlightbyId(int flightId) throws FlightNotFoundException{
		//Flight f = em.find(Flight.class, flightId);
		//em.remove(f);
		String sql = "SELECT f FROM Flight f where f.flightId= :flightId";
		//String sql1="SELECT b FROM Bookings b where b.flightId= :flightId";
		TypedQuery<Flight> tq = em.createQuery(sql, Flight.class);
		tq.setParameter("flightId", flightId );
		List<Flight> flights = tq.getResultList();
		try
		{
			Flight flight=tq.getSingleResult();
			em.remove(flight);
			return "Flight deleted successfully";
		}
		catch(Exception e)
		{
			throw new FlightNotFoundException("No such flight exists");
		}
	}
	
	public Admin loginAdmin(String email, String password) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		System.out.println(email);
		System.out.println(password);
		String sql = "SELECT a FROM Admin a where a.email= :email AND a.password= :password";
		TypedQuery<Admin> tq = em.createQuery(sql, Admin.class);
		tq.setParameter("email", email);
		tq.setParameter("password", password);
		try
		{
			Admin admin=tq.getSingleResult();
			return admin;
		}
		catch(Exception e)
		{
			throw new AdminNotFoundException("No admin for entered details");
		}
	}

	@Transactional
	@Override
	public Flight addFlight(Flight f) {
		em.persist(f);
		return f;
	}
	@Transactional
	@Override
	public Admin addAdmin(Admin a) {
		em.persist(a);
		return a;
	}
}
