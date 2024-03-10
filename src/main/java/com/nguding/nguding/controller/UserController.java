package com.nguding.nguding.controller;


import com.nguding.nguding.abstraction.AbstractController;
import com.nguding.nguding.entity.User;
import com.nguding.nguding.model.ModelUser;
import com.nguding.nguding.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, ModelUser, String> {

    @Override
    public void afterPropertiesSet() throws Exception {

    }
    private final UserService userService;
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/all")
    public Page<ModelUser> getAllUser(@RequestParam("keyword") String keyword, Pageable pageable) {
        return userService.getUsers(keyword, pageable);
    }
}
