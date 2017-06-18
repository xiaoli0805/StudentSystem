package com.situ.student.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.situ.student.Dao.IStudentDao;
import com.situ.student.Entity.Student;
import com.situ.student.Util.DBUtil;

public class StudentDaoMysqlImpl implements IStudentDao{

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT * FROM student";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			Student student  = null;
			while (resultSet.next()) {
				int stuId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				student = new Student(stuId, name, age, gender);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	@Override
	public Student findByID(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT * FROM student WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stuId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				student = new Student(stuId, name, age, gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return student;
	}

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "INSERT INTO student(NAME,age,gender) VALUES(?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "DELETE FROM student WHERE id =?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "UPDATE student SET NAME=?,age=?,gender=? WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getId());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean checkStudent(Student student) {
		List<Student> list = findAll();
		boolean isFound = false;
		for (Student student2 : list) {
			if (student2.getName().equalsIgnoreCase(student.getName())) {
				isFound = true;
			}
		}
		return isFound;
	}

}
