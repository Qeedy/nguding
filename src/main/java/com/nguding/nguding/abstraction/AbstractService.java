package com.nguding.nguding.abstraction;

import com.nguding.nguding.interfaces.EntityMapper;
import com.nguding.nguding.mapper.UserMapper;
import com.nguding.nguding.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<E, M, ID> {

    CrudRepository<E, ID> entityRepository;
    EntityMapper<E, M> entityMapper;

    public AbstractService(CrudRepository<E, ID> entityRepository, EntityMapper<E, M> entityMapper) {
        this.entityRepository = entityRepository;
        this.entityMapper = entityMapper;
    }

    public void save(M model) {
        E entity = entityMapper.toEntity(model);
        entityRepository.save(entity);
    }
    public void deleteById(ID id) {
        entityRepository.deleteById(id);
    }
    public M getById(ID id) {
        E entity = Optional.ofNullable((E) entityRepository.findById(id)).orElse(null);
        if(entity != null)
            return (M) entityMapper.toModel(entity);
        else
            return null;
    }

}
