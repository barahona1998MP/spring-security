package com.techalchemy.security_jwt.service;


import com.techalchemy.security_jwt.dto.UserDTO;


import java.util.List;



public interface UserService {

    List<UserDTO> findAll();


    UserDTO findById(Long id);
}
