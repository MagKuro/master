package com.kurowska.master.repository;

import com.kurowska.master.model.GeneratedPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedPasswordRepository extends JpaRepository<GeneratedPassword, Long> {
    GeneratedPassword getByMd5(String md5);
    GeneratedPassword getBySha1(String sha1);
    GeneratedPassword getBySha2(String sha2);
}
