package springbootmongotodos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class SpringbootMongoTodosApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository repository;
//	private @Autowired MongoClient  mongo;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoTodosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		MongoDatabase db= mongo.getDatabase("try2");
//		System.out.println("database = " + db.getCollection("newCollection").find().toString());
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("Izhar", "Yaakov"));


		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

}
