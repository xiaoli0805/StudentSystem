package com.situ.student.Controllor;

import java.util.List;

import com.situ.student.Entity.Student;
import com.situ.student.Exception.NameRepeatException;
import com.situ.student.Service.IStudentService;
import com.situ.student.Service.Impl.StudentServiceImpl;

public class StudentControllor {
	IStudentService studentService = new StudentServiceImpl();
	public List<Student> findAll() {
		return studentService.findAll();
	}
	public Student findById(int id) {
		return studentService.findById(id);
	}
	public boolean add(Student student) throws NameRepeatException{
		return studentService.add(student);
	}
	public boolean delete(int id) {
		return studentService.delete(id);
	}
	public boolean update(Student student) {
		return studentService.update(student);
	}
}
