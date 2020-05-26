package cn.glut.dao;

import cn.glut.domain.Administrator;
import cn.glut.domain.User;
import cn.glut.util.JDBCUtils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过用户名和密码查询用户信息
     * @param username 账号
     * @param password 密码
     * @return 用户对象
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try { //抓异常，防止 EmptyResultDataAccessException:Incorrect result size: expected 1, actual 0
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改用户信息
     * @param user 用户对象
     */
    @Override
    public void updataUser(User user) {
        if(user.getUsername()==null) {
//          // 用户修改本身的信息
            String sql = "update user set name = ? , age = ? , gender = ? , email = ? , address = ? where id = ? ";
            template.update(sql, user.getName(), user.getAge(), user.getGender(), user.getEmail(), user.getAddress(), user.getId());
        }else{
            // 管理员修改用户信息
            String sql = "update user set username = ? , password = ? , name = ? , age = ? , gender = ? , email = ? , address = ? where id = ? ";
            template.update(sql,user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getGender(), user.getEmail(), user.getAddress(), user.getId());
        }
    }

    /**
     * 通过用户id查找用户信息
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    public User findUserById(int id) {
        try {
            String sql = "select * from user where id=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据用户id修改用户密码
     * @param id 用户id
     * @param np 新密码
     */
    @Override
    public void updataPasswordById(int id, String np) {
        String sql = "update user set password = ? where id = ? ";
        template.update(sql,np,id);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getAge(),user.getGender(),user.getEmail(),user.getAddress());
    }

    /**
     * 管理员登录
     * @param adminame
     * @param password
     * @return
     */
    @Override
    public Administrator adminLogin(String adminame, String password) {
        try {
            String sql = "select * from administrator where adminame=? and password=?";
            Administrator administrator = template.queryForObject(sql, new BeanPropertyRowMapper<Administrator>(Administrator.class), adminame, password);
            return administrator;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 条件查询用户总数
     * @param map 条件集合
     * @return
     */
    @Override
    public int conditionUserCount(Map<String, String[]> map) {

        // 定义初始化sql
        StringBuilder sql = new StringBuilder("select count(*) from user where 1 = 1");

        // 定义参数集合
        List<Object> params = new ArrayList<Object>();

        // 遍历Map
        for (String s : map.keySet()) {

//            System.out.println(s);

            //排除分页条件参数
            if(s.equals("rows") || s.equals("pageNumber")){
                continue;
            }

            // 获取value
            String value = map.get(s)[0];
            // 判断
            if(value != null && !"".equals(value)){
                sql.append(" and "+s+" like ? ");
                params.add("%"+value+"%"); // ?条件的值
            }
        }

        return template.queryForObject(sql.toString(),Integer.class,params.toArray());

    }

    /**
     * 条件查询用户
     * @param start
     * @param rows
     * @param map
     * @return
     */
    @Override
    public List<User> conditionUser(int start, int rows, Map<String, String[]> map) {

        // 定义sql
        StringBuilder sql = new StringBuilder("select * from user where 1 = 1");

        List<Object> params = new ArrayList<Object>();

        // 遍历map
        for (String s : map.keySet()) {

            // 排除分页条件
            if(s.equals("rows") || s.equals("pageNumber")) {
                continue;
            }

            // 获取value
            String value = map.get(s)[0];

            // 判断value是否为null或""
            if(value!=null && !"".equals(value)){
                sql.append(" and "+s+" like ? ");
                params.add("%"+value+"%");
            }

        }

        sql.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);

        List<User> list = template.query(sql.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());

        return list;
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        try{
            String sql = "select * from user where username = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
