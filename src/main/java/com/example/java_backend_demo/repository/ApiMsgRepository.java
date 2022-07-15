package com.example.java_backend_demo.repository;


import com.example.java_backend_demo.Pojo.ApiMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiMsgRepository extends JpaSpecificationExecutor<ApiMsg>, JpaRepository<ApiMsg, Integer> {
    ApiMsg findByRspCode(Integer code);
}
