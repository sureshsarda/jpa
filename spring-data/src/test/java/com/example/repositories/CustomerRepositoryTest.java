package com.example.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.App;
import com.example.bean.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repo;

	@Test
	public void testDefaultMethods() {
		repo.save(new Customer("Elidia", "Galey"));
		repo.save(new Customer("Jasmine", "Franceschini"));
		repo.save(new Customer("Darlena", "Gilroy"));
		repo.save(new Customer("Tod", "Campion"));
		repo.save(new Customer("Man", "Hazard"));
		repo.save(new Customer("Lai", "Barns"));
		repo.save(new Customer("Cinda", "Heater"));
		repo.save(new Customer("Patti", "Gilroy"));
		repo.save(new Customer("Cassondra", "Davidson"));
		repo.save(new Customer("Jeanie", "Viggiano"));

		assertEquals(10, repo.count());

		List<Customer> result = repo.findByLastName("Gilroy");
		assertEquals(2, result.size());

		assertTrue(result.contains(new Customer("Darlena", "Gilroy")));
		assertTrue(result.contains(new Customer("Patti", "Gilroy")));
		
		repo.delete(result.get(0).getId());
		repo.delete(result.get(1).getId());
		
		assertEquals(8, repo.count());
		
		result = repo.findByLastName("Gilroy");
		assertEquals(0, result.size());

	}
}
