package com.laisc.finalwork_server.mapper;

import com.laisc.finalwork_server.entity.ChangePw;
import com.laisc.finalwork_server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAllUser();
    public List<User> checkUser(User user);
    public User checkUserOne(User user);
    public User findUserById(int id);
    public int insertUser(User user);
    public User findUserWithNoPassword(int id);
    public List<User> findAllUserWithNoPassword();
    public int updateUser(User user);
    public int changeUserPassword(ChangePw changePw);
    public int delUser(int id);

}
