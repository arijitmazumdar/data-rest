package com.spring.test.datarest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.spring.test.datarest.entity.WebsiteUser;




public interface UserRepository extends CrudRepository<WebsiteUser, Long>, PagingAndSortingRepository<WebsiteUser, Long> {
    @RestResource(rel = "findByName", exported = true)
    List<WebsiteUser> findByName(@Param("name") String name);
}
