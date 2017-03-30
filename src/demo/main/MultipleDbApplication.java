package demo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import demo.dao.CustomerRepository;

@SpringBootApplication
@ComponentScan({"demo"})
@EntityScan("demo")
public class MultipleDbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		// SpringApplication.run(MultipleDbApplication.class, args);
		new SpringApplicationBuilder(MultipleDbApplication.class).web(false).run(args);

	}

	@Override
	public void run(String... args) throws Exception {		
		System.out.println(repository.findByLastName("Alice"));

//		for (Customer customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
	}
}