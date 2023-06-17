package com.sri.firstproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sri.firstproject.model.StudentModel;
import com.sri.firstproject.repository.StudentRep;

@Service
 
public class StudentService {

	@Autowired
	StudentRep studRep;
	
	public List <StudentModel>getAllStudent()
	{
		List<StudentModel>studList=studRep.findAll();
		return studList;
	}
	public StudentModel saveStudent(StudentModel s)
	{
		StudentModel obj = studRep.save(s);
		return obj;
	}
	public StudentModel updateStudent(StudentModel s)
	{
		StudentModel obj = studRep.save(s);
		return obj;
	}
	public void deleteStudent(int num)
	{
		studRep.deleteById(num);
	}
	public StudentModel getStudent(int num)
	{
		StudentModel s = studRep.findById(num).get();
		return s;
	}
	public List<StudentModel> sortAll(String field)
	{
		return studRep.findAll(Sort.by(field));
	}

	//sorting Descending Order
//	public List<SevenWondersModel> sortAll(String f)
//	{
//		return studRep.findAll(Sort.by(Direction.DESC, f)) ;
//	}
		
	//pagination
	public List<StudentModel>pagingStudentModel(int offset,int  pageSize)
	{
		Page<StudentModel>obj= studRep.findAll(PageRequest.of(offset, pageSize));
		return obj.getContent();
	}
	
	public List<StudentModel> paginate(int offset, int pageSize, String username) 
	{
		Page<StudentModel> obj=studRep.findAll(PageRequest.of(offset, pageSize,Sort.by(username).descending()));
		return obj.getContent();
	}
	
	public List<StudentModel> fetchStudentByNamePrefix(String prefix)
	{
		return studRep.findByNameStartingWith(prefix);
	}
	public List<StudentModel> fetchStudentByNameSuffix(String suffix)
	{
		return studRep.findByNameEndingWith(suffix);
	}
	public List<StudentModel> fetchStudentByDept(String dept)
	{
		return studRep.findByDept(dept);
	}
	public String loginCheckData(String username,String password)
	{
		StudentModel user = studRep.findByusername(username);
		if(user == null)
		{
			return "No User Found/nPlease Try Again!!!!";
		}
		else
		{
			if(user.getPassword().equals(password))
			{
				return "Login Successful";
			}
			else
			{
				return "Login Failed";
			}
		}
	}
}

