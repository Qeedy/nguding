package com.nguding.nguding.abstraction;

import com.nguding.nguding.interfaces.EntityMapper;
import com.nguding.nguding.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class AbstractController<E, M, ID> implements InitializingBean {

    /**
     * E stands for class Entity
     * M stand for class Model
     * ID stand for class ID
     * example UserController extends AbstractController<User, ModelUser, String>
     *     why String ? because User has Id with type class String
     * **/
    AbstractService<E, M, ID> service;

    public AbstractController(AbstractService<E, M, ID> service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody M model) {
        service.save(model);
    }

    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable("id") ID id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public M getById(@PathVariable("id") ID id) {
        return (M) service.getById(id);
    }
}
