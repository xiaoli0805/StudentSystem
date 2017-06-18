package com.situ.student.App;

import com.situ.student.View.StudentView;

public class MainApplication {
	public static void main(String[] args) {
		StudentView studentView = new StudentView();
		studentView.init();
		studentView.showView();
	}
}
