package me.bouzri.multipledatasource;

import me.bouzri.multipledatasource.topics.FirstUser;
import me.bouzri.multipledatasource.todo.SecondUser;
import me.bouzri.multipledatasource.todo.TodoRepository;
import me.bouzri.multipledatasource.topics.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication

public class MultipleDataSourceApplication {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TopicRepository topicRepository;

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		SpringApplication.run(MultipleDataSourceApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			for (int i = 0; i < 10; i++){
				FirstUser user = new FirstUser();
				user.setName("FirstUser");
				topicRepository.save(user);
			}
			for (int i = 0; i < 10; i++){
				SecondUser user = new SecondUser();
				user.setName("SecondUser");
				todoRepository.save(user);
			}
		};
	}

}
