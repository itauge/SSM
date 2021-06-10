package com.fung.dao;

import com.fung.common.PageResult;
import com.fung.domain.User;

import java.util.List;


public interface UserDao {
    /**
     * 根據id查詢用戶
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查詢所有用戶
     * @return
     */
    List<User> findAll();

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * delete user
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * update user
     * @param user
     */
    void updateUser(User user);
}
