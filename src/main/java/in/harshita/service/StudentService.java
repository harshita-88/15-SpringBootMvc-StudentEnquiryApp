package in.harshita.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.harshita.binding.Student;
import in.harshita.entity.StudentEntity;
import in.harshita.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) {
		System.out.println(student);
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		entity.setTimings(Arrays.toString(student.getTimings()));
		repo.save(entity);
		return true;		
	}
	public List<String> getCourses(){
		return Arrays.asList("aws","python","java","c");
	}
	public List<String> getTimings(){
		return Arrays.asList("morning","afternoon","evening");
	}

}
