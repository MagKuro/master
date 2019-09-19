package com.kurowska.master.repository;

import com.kurowska.master.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
    List<Password> getByMd5(String md5);
    List<Password> getBySha1(String sha1);
    List<Password> getBySha2(String sha2);
}
