package com.ontime.repositoryServices;

import com.ontime.dto.Subject;
import com.ontime.models.SubjectEntity;
import com.ontime.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectRepositoryServiceImpl implements SubjectRepositoryService {

  @Autowired
  private Provider<ModelMapper> modelMapperProvider;

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public List<Subject> findAllSubjects(String userId) {
    SubjectEntity subjectEntity;
    try {
      subjectEntity = subjectRepository.findByUserId(userId);
    } catch (Exception e) {
      subjectEntity = new SubjectEntity();
      subjectEntity.setUserId(userId);
      subjectEntity.setSubjects(new ArrayList<>());
      subjectRepository.save(subjectEntity);
    }
    if(subjectEntity.getSubjects().size() > 0) {
      return subjectEntity.getSubjects();
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Subject> addSubject(String userId, Subject subject) {
    SubjectEntity subjectEntity;
    try {
      subjectEntity =  subjectRepository
          .findByUserId(userId);
      // Added subject to the set
      boolean exists = false;
      for (Subject subjectInList : subjectEntity.getSubjects()) {
        if(subjectInList.getSubjectName().equals(subject.getSubjectName())) {
          exists = true;
          break;
        }
      }
      if(!exists) {
        subjectEntity.getSubjects().add(subject);
      }
      subjectRepository.save(subjectEntity);
      return subjectEntity.getSubjects();
    } catch (Exception e) {
      List<Subject> subjects = new ArrayList<>();
      subjects.add(subject);
      subjectEntity =  new SubjectEntity();
      subjectEntity.setUserId(userId);
      subjectEntity.setSubjects(subjects);
      subjectRepository.save(subjectEntity);
      if(subjects.size() > 0) {
        return subjectEntity.getSubjects();
      } else {
        return new ArrayList<>();
      }
    }
  }

  @Override
  public List<Subject> removeSubject(String userId, Subject subject) {
    SubjectEntity subjectEntity;
    try {
      subjectEntity =  subjectRepository
          .findByUserId(userId);
      boolean exists = false;
      int index = -1;
      for (Subject subjectInList : subjectEntity.getSubjects()) {
        if(subjectInList.getSubjectName().equals(subject.getSubjectName())) {
          exists = true;
          break;
        }
        index++;
      }
      if (exists) {
        subjectEntity.getSubjects().remove(index);
      }
      subjectRepository.save(subjectEntity);
      return new ArrayList<>(subjectEntity.getSubjects());
    } catch (Exception e) {
        return new ArrayList<>();
    }
  }
}
