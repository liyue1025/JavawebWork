package cn.glut.service;

import cn.glut.dao.Dao;
import cn.glut.dao.DaoImpl;
import cn.glut.domain.Administrator;
import cn.glut.domain.Page;
import cn.glut.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    // 创建DaoImpl对象
    Dao daoImpl = new DaoImpl();

    /**
     * 通过用户名和密码查询用户信息
     * @param username 账号
     * @param password 密码
     * @return 用户对象
     */
    @Override
    public User login(String username, String password) {
        // 调用userdao
        User user = daoImpl.findUserByUsernameAndPassword(username, password);
        return user;
    }

    /**
     * 通过用户id查找用户信息
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    public User findUserById(int id) {
        return daoImpl.findUserById(id);
    }

    /**
     * 修改用户信息
     * @param user 用户对象
     */
    @Override
    public void updataUser(User user) {
       daoImpl.updataUser(user);
    }

    /**
     * 根据id修改用户密码
     * @param id 用户id
     * @param np 新密码
     */
    @Override
    public void updataPassword(int id, String np) {
        daoImpl.updataPasswordById(id,np);
    }

    /**
     * 添加新用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        daoImpl.addUser(user);
    }

    /**
     * 管理员登录
     * @param adminame
     * @param password
     * @return
     */
    @Override
    public Administrator adminLogin(String adminame, String password) {
        return daoImpl.adminLogin(adminame,password);
    }

    /**
     * 根据条件获得分页数据
     * @param pageNumber 当前页码
     * @param rows 每页多少行
     * @param map 参数集合
     * @return 分页对象
     */
    @Override
    public Page userList(int pageNumber, int rows, Map<String, String[]> map) {

        // 1.创建Page对象
        Page<User> page = new Page<>();

        // 2.条件查询用户总数
        int userCount = daoImpl.conditionUserCount(map);
        page.setUserCount(userCount);

        // 3.条件查询用户List集合
        int start = (pageNumber-1)*rows;
        List<User> list = new ArrayList<User>();
        list = daoImpl.conditionUser(start,rows,map);
        page.setList(list);

        // 4.计算总页数
        int pageCount = userCount % rows == 0 ? userCount / rows : userCount / rows + 1;
        page.setPageCount(pageCount);

        // 5.设置参数
        page.setRows(rows);
        page.setPageNumber(pageNumber);

        return page;
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        daoImpl.deleteUserById(id);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        return daoImpl.findUserByUsername(username);
    }

}
