package edu.iuh.ktpm.controllers;

import edu.iuh.ktpm.entities.Project;
import edu.iuh.ktpm.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping({"/","/home"})
    public ModelAndView getAllProject(){
        ModelAndView view = new ModelAndView();
        view.addObject("projects",projectService.getAllProject());
        view.setViewName("project-home");
        return view;
    }
    @PostMapping("/find")
    public ModelAndView findById(@RequestParam("idProject") String idProject){
        ModelAndView view = new ModelAndView();
        view.addObject("projects",projectService.findProjectById(idProject));
        view.setViewName("project-home");
        return view;
    }

    @GetMapping("/add")
    public ModelAndView saveProject(){
        ModelAndView view = new ModelAndView();
        view.addObject("project",new Project());
        view.setViewName("project-add");
        return view;
    }

    @PostMapping("/add")
    public ModelAndView save(@ModelAttribute Project project){
        ModelAndView view = new ModelAndView();
        projectService.addProject(project);
        view.setViewName("redirect:/project/home");
        return view;
    }

    @GetMapping("/xoa/{idProject}")
    public ModelAndView deleteProject(@PathVariable String idProject){
        ModelAndView view = new ModelAndView();
        Project project = projectService.findProjectById(idProject);
        projectService.deleteProject(project);
        view.setViewName("redirect:/project/home");
        return view;
    }

    @GetMapping("/update/{idProject}")
    public ModelAndView updateProject(@PathVariable String idProject){
        ModelAndView view = new ModelAndView();
        Project project = projectService.findProjectById(idProject);
        view.addObject("project",project);
        view.setViewName("project-add");
        return view;
    }
}
