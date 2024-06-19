package com.techalchemy.security_jwt.service;

import com.techalchemy.security_jwt.config.models.RegisterRequest;
import com.techalchemy.security_jwt.dto.UserDTO;
import com.techalchemy.security_jwt.entity.User;
import com.techalchemy.security_jwt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            User currentUser = user.get();
            return modelMapper.map(currentUser, UserDTO.class);
        }
        return new UserDTO();
    }
}
