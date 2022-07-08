package fr.fms;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.dao.UsersRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.entities.Users;
import fr.fms.job.IBusinessImpl;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner{
	
	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		usersRepository.save(new Users(null, "Louis", "12345", null));
//		usersRepository.save(new Users(null, "Nathan", "54321", null));
		usersRepository.save(new Users((long) 999999999, "Acuiel", "Bienvenue", null));
//		
//		Category aFaire = categoryRepository.save(new Category(null,"a Faire",null));
//		Category aLOcation = categoryRepository.save(new Category(null,"a l'ocation",null));
//		Category Urgent = categoryRepository.save(new Category(null,"Urgent",null));
//		taskRepository.save(new Task(null,"Ecole","penser a aller aux college a la rentré", "1er Septembre 2022", categoryRepository.findById((long) 1).get(),usersRepository.findById((long) 1).get()));
//		taskRepository.save(new Task(null,"Ecole","penser a aller aux college a la rentré", "1er Septembre 2022", categoryRepository.findById((long) 1).get(),usersRepository.findById((long) 2).get()));
		
	}
}
