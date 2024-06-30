package com.dbh.restapi.repository;

import com.dbh.restapi.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<BranchEntity,Long> {
}
