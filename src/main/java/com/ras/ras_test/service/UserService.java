package com.ras.ras_test.service;

import com.ras.ras_test.dto.UserDTO;
import com.ras.ras_test.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User create(UserDTO dto);

    User update(Long id, UserDTO dto);

    void delete(Long id);

}
