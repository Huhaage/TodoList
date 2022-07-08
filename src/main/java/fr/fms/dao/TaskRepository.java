package fr.fms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	Page<Task> findAllByUsersId(Long id, PageRequest pageRequest);
	Page<Task> findAllByUsersIdAndByCategoryId(Long id, PageRequest pageRequest);
	Page<Task> findByDescriptionContains(String contain,PageRequest pageRequest);
}
