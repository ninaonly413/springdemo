package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
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