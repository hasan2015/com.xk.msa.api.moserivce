package com.xk.msa.api.mo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xk.msa.api.mo.entity.User;
/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:29:29
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u left join fetch u.userroles r where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
