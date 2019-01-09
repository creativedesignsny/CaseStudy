/**
 * 
 */
package com.Casestudy.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Casestudy.DAO.EmployeeDAO;
import com.Casestudy.DAO.ProjectDAO;
import com.Casestudy.DAO.TaskDAO;
import com.Casestudy.Models.Address;
import com.Casestudy.Models.Employee;
import com.Casestudy.Models.Project;
import com.Casestudy.Models.Task;


/**
 * @author amahome
 *
 */

@Controller
@RequestMapping("/")
public class ProjectController {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    dateFormat.setLenient(false);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/project", method=RequestMethod.GET)
	public ModelAndView displayProjectPage(@ModelAttribute("project") Project project) {
		ModelAndView mav = new ModelAndView("project");
		List<Project> projectList = new ArrayList<Project>();
		Project editProject = new Project();
		ProjectDAO projectDAO = new ProjectDAO();
		editProject = projectDAO.getProjectByName(project.getProjectName());
		projectList = projectDAO.getAllProjects();
		mav.addObject("projects", projectList);
		mav.addObject("editprojects", editProject);
		return mav;
	}
	
	@RequestMapping(value = "/addProject", method=RequestMethod.GET)
	public ModelAndView displayAddTask() {
		ModelAndView mav = new ModelAndView("addProject");
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		mav.addObject("listEmp", empList);
		return mav;
	}
	
	
	@RequestMapping(value = "/editProject", method=RequestMethod.GET)
	public ModelAndView displayEditTask() {
		ModelAndView mav = new ModelAndView("editProject");
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		List<Project> projectList = new ArrayList<Project>();
		ProjectDAO projectDAO = new ProjectDAO();
		projectList = projectDAO.getAllProjects();
		mav.addObject("projects", projectList);
		mav.addObject("listEmp", empList);
		return mav;
	}
	
	
	@RequestMapping(value = "/edit-project", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView displayHomePage(@ModelAttribute("project") Project project) {
		ModelAndView mav = new ModelAndView("editProject");
		ProjectDAO projectDAO = new ProjectDAO();
		boolean update = false;
		boolean updateDate = false;
		boolean addUpdate = false;
		System.out.println(project.getEmpFullName());
		if (project.getEndDate() == null || (project.getEndDate()).isEmpty()) {
			update = projectDAO.updateProjectAll(project.getStartDate(), project.getStatus(), project.getDescription(),
			project.getClientFullName(), project.getEmpFullName(), project.getVenFullName(), project.getProjectName());
			System.out.println(update);
		}else {
			updateDate = projectDAO.updateProjectDate(project.getStartDate(), project.getEndDate(), project.getStatus(), project.getDescription(),
			project.getClientFullName(), project.getEmpFullName(), project.getVenFullName(), project.getProjectName());
			System.out.println(updateDate);
		}
		addUpdate = projectDAO.updateProjectAddress(project.getProjectAddress().getHomeAptno(), project.getProjectAddress().getStreetName(),
					project.getProjectAddress().getCity(), project.getProjectAddress().getState(), project.getProjectAddress().getZipcode(), project.getProjectName());
		System.out.println(addUpdate);
		if ((update || updateDate) && addUpdate) {
			mav.addObject("message", "Project Updated Successfully");
		}else {
			mav.addObject("message", "Project Not Updated");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/ajax-call", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Project getProject(@RequestParam("projectName") String name, HttpSession request) {
		String projectname;
		Project editProject = new Project();
		ProjectDAO projectDAO = new ProjectDAO();
		editProject = projectDAO.getProjectByName(name);
		projectname = editProject.getStatus();
		System.out.println(projectname);
		return editProject;
	}
	
	

	
	@RequestMapping(value = "/add-project", method=RequestMethod.POST)
	public ModelAndView addProject(@ModelAttribute("project") Project project, BindingResult errors) {
		if(errors.hasErrors()) {
			ModelAndView mav = new ModelAndView("addProject");
			return mav;
		}
		ModelAndView mav = new ModelAndView("addProject");
		ProjectDAO projectDAO = new ProjectDAO();
		boolean addProject;
		boolean addAddress;
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = new ArrayList<Employee>();
		empList = empDAO.getAllEmployee();
		addProject = projectDAO.addProject(project.getProjectName(), project.getStartDate(), project.getStatus(), project.getDescription(),
				project.getClientFullName(), project.getEmpFullName(), project.getVenFullName());
		if (addProject) {
			addAddress = projectDAO.addProjectAddress(project.getProjectAddress().getHomeAptno(), project.getProjectAddress().getStreetName(),
					project.getProjectAddress().getCity(), project.getProjectAddress().getState(), project.getProjectAddress().getZipcode());
			if (addAddress) {
				mav.addObject("message", "Project address is added");
				mav.addObject("listEmp", empList);
			}else {
				mav.addObject("message", "Failed to add project");
				mav.addObject("listEmp", empList);
			}
			
		}
		mav.addObject("message", "Project is added");
					
		return mav;
	}
	
	@RequestMapping(value = "/project-detail", method=RequestMethod.GET)
	public ModelAndView projectDetail() {
		ModelAndView mav = new ModelAndView("projectDetail");
		List<Project> projectList = new ArrayList<Project>();
		ProjectDAO projectDAO = new ProjectDAO();
		projectList = projectDAO.getAllProjects();
		mav.addObject("projects", projectList);
		mav.addObject("comma", ",");
		mav.addObject("hyphen", "-");
		return mav;
	}
	
	
	@RequestMapping(value = "/{projectId}", method=RequestMethod.GET)
	public ModelAndView details(@PathVariable("projectId") BigDecimal projectId, HttpSession session) {
		System.out.println("project id = " + projectId);
		ModelAndView mav = new ModelAndView("projectDetail");
		session.setAttribute("projectID", projectId);
		List<Project> projectList = new ArrayList<Project>();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = new Project();
		project = projectDAO.getProjectById(projectId);
		projectList = projectDAO.getAllProjects();
		mav.addObject("projects", projectList);
		mav.addObject("projectById", project);
		return mav;
	}
	
	@RequestMapping(value = "/edit-status", method=RequestMethod.POST)
	public ModelAndView details(@RequestParam("status") String projectStatus, HttpSession session) {
		ModelAndView mav = new ModelAndView("projectDetail");
		List<Project> projectList = new ArrayList<Project>();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = new Project();
		boolean update = projectDAO.updateProjectStatus(projectStatus, (BigDecimal) session.getAttribute("projectID"));
		String message;
		if (update) {
			message = "Status updated";
		}else {
			message = "Status not updated";
		}
		projectList = projectDAO.getAllProjects();
		project = projectDAO.getProjectById((BigDecimal) session.getAttribute("projectID"));
		mav.addObject("updateMessage", message);
		mav.addObject("projects", projectList);
		mav.addObject("projectById", project);
		return mav;
	}
	
	@RequestMapping(value = "/{projectId}", method=RequestMethod.POST)
	public ModelAndView deleteDetails(@PathVariable("projectId") BigDecimal projectId, HttpSession session) {
		System.out.println("project id = " + projectId);
		ModelAndView mav = new ModelAndView("editProject");
		session.setAttribute("projectID", projectId);
		List<Project> projectList = new ArrayList<Project>();
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = new Project();
		boolean delete;
		String message;
		projectList = projectDAO.getAllProjects();
		delete = projectDAO.deleteProject(projectId);
		project = projectDAO.getProjectById(projectId);
		if (delete) {
			message = "Deleted the project";
		}else {
			message = "Project couldn't be deleted";
		}
		mav.addObject("projects", projectList);
		mav.addObject("projectById", project);
		mav.addObject("errorMsg", message);
		return mav;
	}
	
	
//	@RequestMapping(value = "/ex/foos/{id}", method = GET)
//	@ResponseBody
//	public String getFoosBySimplePathWithPathVariable(
//	  @PathVariable("id") long id) {
//	    return "Get a specific Foo with id=" + id;
//	}
	
	
	@ModelAttribute("project")
	public Project setupUserModel(BigDecimal projectId, String projectName, String startDate, String endDate, String status, String description,
	Address projectAddress, String clientFullName, String empFullName, String venFullName) {
		return new Project(projectId, projectName, startDate, endDate, status, description, projectAddress, clientFullName, empFullName, venFullName);
	}
	
}
