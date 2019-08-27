package com.table.demotest;

import java.io.IOException;
import java.util.List;

import com.table.dao.SchoolDao;
import com.table.daoimpl.SchoolDaoImpl;
import com.table.pojo.School;

public class SchoolTest {

	public static void main(String args[]) throws IOException {
		SchoolDao schoolDao = new SchoolDaoImpl();
		List<School> schoolList = schoolDao.selectAllSchool();
		for(School school:schoolList){
			System.out.println(school);
		}
	}
}
