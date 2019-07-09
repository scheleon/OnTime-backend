package com.ontime.services;

import com.ontime.dto.Subject;
import com.ontime.exchanges.AddOrRemoveSubjectRequest;
import com.ontime.exchanges.GetSubjectsRequest;
import com.ontime.exchanges.GetSubjectsResponse;
import com.ontime.repositoryServices.SubjectRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectsServiceImpl implements SubjectsService {

  @Autowired
  private SubjectRepositoryService subjectRepositoryService;

  @Override
  public GetSubjectsResponse findAllSubjects(GetSubjectsRequest getSubjectsRequest) {
    GetSubjectsResponse getSubjectsResponse = new GetSubjectsResponse();
    getSubjectsResponse.setSubjects(subjectRepositoryService
        .findAllSubjects(getSubjectsRequest.getUserId()));
    return getSubjectsResponse;
  }

  @Override
  public GetSubjectsResponse addSubject(AddOrRemoveSubjectRequest addOrRemoveSubjectRequest) {
    GetSubjectsResponse getSubjectsResponse =  new GetSubjectsResponse();
    Subject subject = new Subject();
    subject.setSubjectName(addOrRemoveSubjectRequest.getSubjectName());
    getSubjectsResponse.setSubjects(
        subjectRepositoryService.addSubject(addOrRemoveSubjectRequest.getUserId(), subject));
    return getSubjectsResponse;
  }

  @Override
  public GetSubjectsResponse removeSubject(AddOrRemoveSubjectRequest addOrRemoveSubjectRequest) {
    GetSubjectsResponse getSubjectsResponse = new GetSubjectsResponse();
    Subject subject = new Subject();
    subject.setSubjectName(addOrRemoveSubjectRequest.getSubjectName());
    getSubjectsResponse.setSubjects(
        subjectRepositoryService.removeSubject(addOrRemoveSubjectRequest.getUserId(), subject));
    return getSubjectsResponse;
  }
}
