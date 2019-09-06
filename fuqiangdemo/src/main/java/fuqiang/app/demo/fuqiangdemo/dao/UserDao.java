package fuqiang.app.demo.fuqiangdemo.dao;

import java.util.List;

import fuqiang.app.demo.fuqiangdemo.pojo.User;

public interface UserDao {

	// 插入
	public void insertUser(User user);

	// 删除
	public void deleteUser(long id);

	// 查询
	public List<User> findUser();

	// 修改
	public void updateUser(User user);
}
