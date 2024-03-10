package com.nguding.nguding.repository;

import com.nguding.nguding.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u Where (:keyword is null or UPPER(u.userName) LIKE CONCAT('%', UPPER(:keyword), '%') )")
    public Page<User> findAllPageable(
            @Param("keyword") String keyword, Pageable pageable);
}
