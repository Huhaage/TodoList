package fr.fms.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.TaskRepository;
import fr.fms.dao.UsersRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.entities.Users;

@Service
public class IBusinessImpl implements IBusiness {
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void addUsers(Users user) {
		usersRepository.save(user);
	}

	@Override
	public void addTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public void delTask(Long id) {
		taskRepository.deleteById(id);	
	}

	@Override
	public void updateTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public Page<Task> readTasksByUsers(Long id,PageRequest pageRequest) {
		return taskRepository.findAllByUsersId(id,PageRequest.of(0, 10));
	}

	@Override
	public Page<Task> readTasksbyUsersAndCategory(Long id,PageRequest pageRequest) {
		return taskRepository.findAllByUsersIdAndByCategoryId(id,PageRequest.of(0, 7));
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<Task> readByDescriptionContains(String contain) {
		return taskRepository.findByDescriptionContains(contain,PageRequest.of(0, 7));
	}

}
