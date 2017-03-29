package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class CustomerRepository {
	@Autowired 
    @Qualifier("mysqlDb") 
    protected DataSource dataSource; 
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlTemplate;
	
	public Customer findByFirstName(String firstName) {
		return new Customer("Nina", "Zhang");
	}

	public String findByLastName(String lastName) {
		Map<String, Object> map = new HashMap<String, Object>();
		String query = "select * from wcm_pty_nm where lst_name = 'Cruz'";
		try {
			map = mysqlTemplate.queryForMap(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.toString();
//		Customer customer = new Customer("Nina", "Zhang");
//		List<Customer> list = new ArrayList<Customer>();
//		list.add(customer);
//		return list;
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