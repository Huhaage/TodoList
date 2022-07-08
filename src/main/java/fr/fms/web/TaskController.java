package fr.fms.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.entities.Category;
import fr.fms.entities.Task;
import fr.fms.job.IBusinessImpl;
import javassist.expr.NewArray;
//import fr.fms.services.GlobalException;

@Controller
public class TaskController {
	@Autowired
	IBusinessImpl iBusinessImpl;
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue = "0")int page,Long id){
		Page<Task> tasks = iBusinessImpl.readTasksByUsers(id,PageRequest.of(page, 7));
		model.addAttribute("pageTask",tasks.getContent());
		model.addAttribute("page", new int[tasks.getTotalPages()]);
		model.addAttribute("currentPage",page);
		return "task";
	}
	

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/addTask")
	public String addArticle(Model model, Task task) {
		List<Category> categories = iBusinessImpl.findAllCategories();
		model.addAttribute("listCategories", categories);
		return "addTask";
	}
	
	@PostMapping("/save")
	public String save(Model model, @Valid Task task, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Category> categories = iBusinessImpl.findAllCategories();
			model.addAttribute("listCategories", categories);
			return "addTask";
		}
		iBusinessImpl.addTask(task);
		List<Category> categories = iBusinessImpl.findAllCategories();
		return null;
	}
		
		@GetMapping("/delete")
		public String delete(Long id, int page, String keyword) {
			iBusinessImpl.delTask(id);

			return "redirect:/tasks?page=" + page + "&keyword=" + keyword;
		}
		
		@PostMapping("/updateArticle")
		public String updateArticle(Task task, BindingResult bindingResult) {
			if (bindingResult.hasErrors())
				return "adminListArticles";

			if (task.getId() != null) {
				iBusinessImpl.updateTask(task);
			}

			return "redirect:/tasks";
		}
}
	
