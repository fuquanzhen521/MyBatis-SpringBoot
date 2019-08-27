package com.example.demo.serviceimpl;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.ClassService;
import com.example.demo.service.StudentService;
import com.table.dao.StudentDao;
import com.table.pojo.ClassInfo;
import com.table.pojo.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ClassService classService;

	// 插入
	@Override
	public void insertStudent() throws IOException {
		// 查询班级信息
		List<ClassInfo> classIdList = classService.selectAllClass();
		Student student = new Student();
		// 随机函数
		Random random = new Random();
		// 随机取90到100个学生数
		int studentIndex = random.nextInt(10) + 90;
		// 在数组x里面存入一些姓氏元素
		String x[] = { "孙", "刘", "曹", "关", "张", "赵", "黄", "郭", "吕", "诸葛", "马", "魏", "杨", "付", "王", "吴", "任", "李", "司徒",
				"顾", "易", "万", "马", "谢", "毛", "周" };
		// 在数组m里面存入一些名字元素
		String m[] = { "权", "备", "操", "羽", "飞", "云", "忠", "嘉", "布", "亮", "超", "延", "广", "强", "阳", "广", "静", "龙", "末",
				"未", "川", "可", "珂", "倩", "东", "来" };
		// 获取一个Calendar对象并可以进行时间的计算，时区的指定
		Calendar cal = Calendar.getInstance();
		// 设置时间
		cal.set(1990, 0, 1);
		// 获得时间,并赋值给start
		long start = cal.getTimeInMillis();
		// 设置时间
		cal.set(2002, 12, 12);
		// 获得时间,并赋值给end
		long end = cal.getTimeInMillis();

		for (ClassInfo classInfo : classIdList) {
			for (int i = 0; i <= studentIndex; i++) {
				// 随机取数组x的下标值
				int a = (int) Math.abs(x.length * Math.random());
				// 随机取数组m的下标值
				int b = (int) Math.abs(m.length * Math.random());
				// 生成学生姓名
				String studentName = x[a] + m[b];
				// 生成出生日期
				Date birthday = new Date(start + (long) (random.nextDouble() * (end - start)));
				// 判断性别
				Byte sex = (byte) (random.nextInt(2) + 1);
				// 取得学校id
				long schoolId = classInfo.getSch_id();
				// 取得年级id
				long gradeId = classInfo.getGra_id();
				// 取得班级id
				long classId = classInfo.getId();
				student.setName(studentName);
				student.setBirthday(birthday);
				student.setSex(sex);
				student.setSch_id(schoolId);
				student.setGra_id(gradeId);
				student.setCla_id(classId);
				studentDao.insertStudent(student);
			}
		}
	}

	// 查询student表id
	@Override
	public List<Long> selectStudent(Map<String, Object> map) throws IOException {
		// 调用查询方法
		List<Long> studentIdList = studentDao.selectStudent(map);
		return studentIdList;
	}

	// 查询student数据
	@Override
	public List<Student> selectAllStudent() throws IOException {
		List<Student> studentList = studentDao.selectAllStudent();
		return studentList;
	}

	// 根据id查询student
	@Override
	public Student selectStudentById(long id) throws IOException {
		Student student = studentDao.selectStudentById(id);
		return student;
	}

	// 条件查询
	@Override
	public List<Student> selectForStudent(String name, Byte sex) throws IOException {
		// 创建学生对象
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		// 查询
		List<Student> selectForStudent = studentDao.selectForStudent(student);
		return selectForStudent;
	}

	@Override
	public void delete(long id) throws IOException {
		studentDao.deleteStudent(id);
	}

	@Override
	public void update(long id, String name, java.util.Date birthday, Byte sex, long sch_id, long gra_id, long cla_id)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("birthday", birthday);
		map.put("sex", sex);
		map.put("sch_id", sch_id);
		map.put("gra_id", gra_id);
		map.put("cla_id", cla_id);
		studentDao.updateStudent(map);
	}

	// 插入一条数据
	@Override
	public void insertStudent(Student student) throws IOException {
		studentDao.insertStudent(student);
	}

}
