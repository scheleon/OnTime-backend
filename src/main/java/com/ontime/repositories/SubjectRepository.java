package com.ontime.repositories;

import com.ontime.models.SubjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
  SubjectEntity findByUserId(String userId);
}
