package com.kurowska.master.repository;

import com.kurowska.master.model.RockYou;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RockYouRepository extends JpaRepository<RockYou, Long> {
    RockYou getByMd5(String md5);
    RockYou getBySha1(String sha1);
    RockYou getBySha2(String sha2);
}
