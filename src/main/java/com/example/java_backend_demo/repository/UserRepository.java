package com.example.java_backend_demo.repository;


import com.example.java_backend_demo.Pojo.UserPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<UserPersonalInfo>, JpaRepository<UserPersonalInfo, Integer> {
    @Modifying
    @Transactional
    @Query(value = "" + "INSERT INTO USER_PERSONAL_INFO(ID, EMAIL_ADDRESS, PASSWORD, NAME, AGE, IMAGE,USER_NAME) "
            + "VALUES (:#{#userPersonalInfo.getId()}, :#{#userPersonalInfo.getEmail()}," +
            ":#{#userPersonalInfo.getPassword()}, :#{#userPersonalInfo.getName()}, " +
            ":#{#userPersonalInfo.getAge()}, :#{#userPersonalInfo.getImage()}, :#{#userPersonalInfo.getUserName()})", nativeQuery = true)
    Integer createUser(@Param("userPersonalInfo") UserPersonalInfo userPersonalInfo);

    @Query(value = "SELECT * FROM USER_PERSONAL_INFO WHERE USER_NAME=?1", nativeQuery = true)
    ArrayList<UserPersonalInfo> findByUserName(String userName);

}
