package com.nguding.nguding.service;

import com.nguding.nguding.abstraction.AbstractService;
import com.nguding.nguding.entity.User;
import com.nguding.nguding.mapper.UserMapper;
import com.nguding.nguding.model.ModelUser;
import com.nguding.nguding.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService<User, ModelUser, String> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Page<ModelUser> getUsers(String keyword, Pageable pageable) {
        return userRepository.findAllPageable(keyword, pageable).map(userMapper::toModel);
    }
}
