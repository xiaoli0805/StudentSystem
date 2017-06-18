package com.situ.student.Dao;

import java.util.List;

import com.situ.student.Entity.Student;

public interface IStudentDao {
	/**
	 * 查询所有学生信息
	 * @return 返回所有学生信息的集合
	 */
	public abstract List<Student> findAll();
	/**
	 * 根据指定的ID查询学生信息
	 * @param id
	 * @return 返回学生信息
	 */
	public abstract Student findByID(int id);
	/**
	 * 添加学生信息
	 * @param student
	 * @return true:添加成功  false：添加失败
	 */
	public abstract boolean add(Student student);
	/**
	 * 删除学生
	 * @param id
	 * @return true：删除成功  false：删除失败
	 */
	public abstract boolean delete(int id);
	/**
	 * 修改学生信息
	 * @param student
	 * @return true：修改成功  false：修改失败
	 */
	public abstract boolean update(Student student);
	/**
	 * 查看指定的学生姓名存不存在
	 * @param student
	 * @return true：学生姓名存在 false：学生姓名不存在
	 */
	public abstract boolean checkStudent(Student student);
}
