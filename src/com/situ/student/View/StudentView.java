package com.situ.student.View;

import java.util.List;
import java.util.Scanner;

import com.situ.student.Controllor.StudentControllor;
import com.situ.student.Entity.Student;
import com.situ.student.Exception.NameRepeatException;

public class StudentView {
	private Scanner scanner = null;
	private  StudentControllor studentControllor = null;
	
	public void init() {
		scanner = new Scanner(System.in);
		studentControllor = new StudentControllor();
	}
	
	public void showView() {
		while (true) {
			System.out.println("-------学生信息管理系统----------");
			System.out.println("1、查询所有");
			System.out.println("2、添加");
			System.out.println("3、修改");
			System.out.println("4、删除");
			System.out.println("0、退出");
			System.out.println("请选择");
			int type = scanner.nextInt();
			if (type == 0) {
				break;
			}
			switch (type) {
			case 1://查询所有学生信息
				showStduentInfos();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				updateStudent();
			case 4:
				deleteStudent();
			default:
				break;
			}
		}
	}

	private void showStduentInfos() {
		System.out.println("----所有学生信息----");
		List<Student> list  = studentControllor.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	private void addStudent() {
		System.out.println("---添加学生信息---");
		System.out.println("学生姓名");
		String name = scanner.next();
		System.out.println("学生年龄");
		int age = scanner.nextInt();
		System.out.println("学生性别");
		String gender = scanner.next();
		Student student = new Student(name, age, gender);
		boolean result = false;
		try {
			result = studentControllor.add(student);
		} catch (NameRepeatException e) {
			System.out.println("名字重复了");
			e.printStackTrace();
		}
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	private void updateStudent() {
		showStduentInfos();
		System.out.println("请输入要更新的学生的id");
		int id = scanner.nextInt();
		Student student = studentControllor.findById(id);
		System.out.println("1.修改姓名 2.修改年龄 3.修改性别");
		int type = scanner.nextInt();
		switch (type) {
		case 1:
			System.out.println("请输入姓名");
			String name = scanner.next();
			student.setName(name);
			break;
		case 2:
			System.out.println("请输入年龄");
			int age = scanner.nextInt();
			student.setAge(age);
			break;
		case 3:
			System.out.println("请输入性别");
			String gender = scanner.next();
			student.setGender(gender);
			break;
		default:
			break;
		}
		boolean result = studentControllor.update(student);
		if (result) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}
	private void deleteStudent() {
		showStduentInfos();
		System.out.println("请属于要删除的学生的id");
		int id = scanner.nextInt();
		boolean result = studentControllor.delete(id);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}
