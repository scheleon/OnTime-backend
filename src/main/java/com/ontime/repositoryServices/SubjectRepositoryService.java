package com.ontime.repositoryServices;

import com.ontime.dto.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectRepositoryService {
  List<Subject> findAllSubjects(String userId);

  List<Subject> addSubject(String userId, Subject subject);

  List<Subject> removeSubject(String userId, Subject subject);
}
