package com.mahindra.dao;

import com.mahindra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select * from m_user u where mobile_number=?",nativeQuery = true)
    List<User> findBymobileNumber(String no);

}
