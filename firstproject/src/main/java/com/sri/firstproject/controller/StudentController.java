 package com.sri.firstproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sri.firstproject.model.StudentModel;
import com.sri.firstproject.service.StudentService;

@RestController

public class StudentController {
  
	@Autowired
	StudentService sri;
	@GetMapping ("/display")
	public List<StudentModel> getAllStudents()
	{
		List<StudentModel> studList=sri.getAllStudent();
		return studList;
	}
	@PostMapping("/add")
	public StudentModel saveStudent(@RequestBody StudentModel s)
	{
		return sri.saveStudent(s);
	}
	@PutMapping("/update")
	public StudentModel updateStudent(@RequestBody StudentModel s)
	{
		return sri.updateStudent(s);
	}
	@DeleteMapping(value="/deleteStudent/{rno}")
	public void  deleteStudent(@PathVariable("rno") int num)
	{
		sri.deleteStudent(num);
	}
	@GetMapping ("/sortStudent/{field}")
	public List<StudentModel> sortStudentModel(@PathVariable String field)
	{
		return sri.sortAll(field);
	}
	@GetMapping(value="/pageStudents/{field}/{size}")
	public List<StudentModel> pagingStudentModel(@PathVariable("field") int offset,@PathVariable("size") int  pageSize)
	
	{
	 return sri.pagingStudentModel(offset, pageSize);	
	}
	@GetMapping("/pagination/{nm}/{sp}/{inr}")
	public List<StudentModel> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
	{
		return sri.paginate(num,size,name);
	}//sp ---how many page split,inr - column name
	@GetMapping("/fetchPrefix")
	public List<StudentModel> fetchStudentByNamePrefix(@RequestParam String prefix)
	{
		return sri.fetchStudentByNamePrefix(prefix);
	}
	@GetMapping("/fetchSuffix")
	public List<StudentModel> fetchStudentByNameSuffix(@RequestParam String suffix)
	{
		return sri.fetchStudentByNameSuffix(suffix);
	}
	@GetMapping("/fetchByDept")
	public List<StudentModel> fetchStudentByDept(@RequestParam String dept)
	{
		return sri.fetchStudentByDept(dept);
	}
	@PostMapping("/login")
	public String login(@RequestBody Map<String,String> loginDataMap)
	{
		String username = loginDataMap.get("username");
		String password = loginDataMap.get("password");
		String result = sri.loginCheckData(username, password);
		return result;
	}
}
