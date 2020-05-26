package cn.glut.service;

import cn.glut.domain.Administrator;
import cn.glut.domain.Page;
import cn.glut.domain.User;

import java.util.Map;

public interface Service {

    /**
     * 通过用户名和密码查询用户信息
     * @param username 账号
     * @param password 密码
     * @return 用户对象
     */
    User login(String username, String password);

    /**
     * 通过用户id查找用户信息
     * @param id 用户id
     * @return 用户对象
     */
    User findUserById(int id);

    /**
     * 修改用户信息
     * @param user 用户对象
     */
    void updataUser(User user);

    /**
     * 根据id修改用户密码
     * @param id 用户id
     * @param np 新密码
     */
    void updataPassword(int id, String np);

    /**
     * 添加新用户
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
     * 根据条件获得分页数据
     * @param pageNumber 当前页码
     * @param rows 每页多少行
     * @param map 参数集合
     * @return 分页对象
     */
    Page userList(int pageNumber, int rows, Map<String, String[]> map);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
