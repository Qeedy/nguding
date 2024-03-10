package com.nguding.nguding.mapper;

import com.nguding.nguding.entity.User;
import com.nguding.nguding.interfaces.EntityMapper;
import com.nguding.nguding.model.ModelUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<User, ModelUser> {
    @Override
    public User toEntity(ModelUser model) {
        User user = new User();
        user.setUserName(model.getUserName());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setAlamat(model.getAlamat());
        return user;
    }

    @Override
    public ModelUser toModel(User user) {
        ModelUser model = new ModelUser();
        model.setUserName(user.getUserName());
        model.setFirstName(user.getFirstName());
        model.setLastName(user.getLastName());
        model.setAlamat(user.getAlamat());
        return model;
    }
}
