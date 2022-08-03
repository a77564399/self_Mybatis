package com.class04.day01.dao;

import com.class04.day01.domain.User;


import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
