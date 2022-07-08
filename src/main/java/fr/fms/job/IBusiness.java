package fr.fms.job;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.entities.Users;

public interface IBusiness {
	
	/**
	 * Allows you to add a User to the database
	 * @param user
	 */
	public void addUsers(Users user);
	
	/**
	 * Allows to add a Tasks in database
	 * @param task
	 */
	public void addTask(Task task);
	
	/**
	 * Allows you to delette a Tasks in database
	 * @param id
	 */
	public void delTask(Long id);
	
	/**
	 * Allows you to update a Tasks in database
	 * @param task
	 */
	public void updateTask(Task task);
	
	/**
	 * Displays the entire Task in the database
	 * @return
	 */
	public Page<Task> readTasksByUsers(Long id,PageRequest pageRequest);
	
	/**
	 * Displays the entire Task in the database by Category
	 * @param id
	 * @return
	 */
	public Page<Task> readTasksbyUsersAndCategory(Long id, PageRequest pageRequest);
	
	public List<Category> findAllCategories();
	
	public Page<Task> readByDescriptionContains(String contain);
}
