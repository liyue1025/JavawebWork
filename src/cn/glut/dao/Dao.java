package cn.glut.dao;

import cn.glut.domain.Administrator;
import cn.glut.domain.User;

import java.util.List;
import java.util.Map;

public interface Dao {
    /**
     * 通过用户名和密码查询用户信息
     * @param username 账号
     * @param password 密码
     * @return 用户对象
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 修改用户信息
     * @param user 用户对象
     */
    void updataUser(User user);

    /**
     * 通过用户id查找用户信息
     * @param id 用户id
     * @return 用户对象
     */
    User findUserById(int id);

    /**
     * 根据用户id修改用户密码
     * @param id 用户id
     * @param np 新密码
     */
    void updataPasswordById(int id, String np);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 管理员登录
     * @param adminame
     * @param password
     * @return
     */
    Administrator adminLogin(String adminame, String password);


    /**
     * 条件查询用户总数
     * @param map 条件集合
     * @return
     */
    int conditionUserCount(Map<String, String[]> map);

    List<User> conditionUser(int start, int rows, Map<String, String[]> map);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUserById(int id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
