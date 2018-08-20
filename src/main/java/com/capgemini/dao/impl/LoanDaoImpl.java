package com.capgemini.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.LoanDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.LoanEntity;

@Repository
public class LoanDaoImpl extends AbstractDao<LoanEntity, Long> implements LoanDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CarEntity> findCarsRented10TimesBy10DifferentCustomer() {
		String view = "select le.car.id from LoanEntity le inner join le.car c where le.car.id = c.id "
				+ "group by le.car.id having count(distinct le.customer.id) > 10 ";
		Query query = entityManager.createQuery("select ce from CarEntity ce " + " where ce.id in (" + view + ")");

		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public int countCarsRentedBeetweenDates(String rentalDate, String returnDate) {
		Query query = entityManager.createQuery(
				"select count(distinct le.car.id) from LoanEntity le where le.rentalDate >= :rentalDate  and le.returnDate <= :returnDate");

		query.setParameter("rentalDate", Date.valueOf(rentalDate));
		query.setParameter("returnDate", Date.valueOf(returnDate));

		return (int) query.getSingleResult();
	}

}
