package javakamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javakamp.hrms.business.abstracts.EmployersService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Employer;
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployersService emloyersService;

	@Autowired
	public EmployersController(EmployersService emloyersService) {
		super();
		this.emloyersService = emloyersService;
	}
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.emloyersService.getAll();
	}
	@PostMapping("/record")
	public Result record (@RequestBody Employer employer) {
		return this.emloyersService.record(employer);
	}
}
