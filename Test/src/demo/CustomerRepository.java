package demo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository 
public class CustomerRepository {
	@Autowired 
    @Qualifier("mysqlDb") 
    protected DataSource dataSource; 
	
	public Customer findByFirstName(String firstName) {
		return new Customer("Nina", "Zhang");
	}

	public List<Customer> findByLastName(String lastName) {
		Customer customer = new Customer("Nina", "Zhang");
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer);
		return list;
	}

	public void deleteAll() {
		System.out.println("deleteAll");
	}

	public void save(Customer customer) {
		System.out.println("save");
	}

	public List<Customer> findAll() {
		Customer customer = new Customer("Nina", "Zhang");
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer);
		return list;
	}

}