package com.ontime.services;

import com.ontime.exchanges.AddOrRemoveSubjectRequest;
import com.ontime.exchanges.GetSubjectsRequest;
import com.ontime.exchanges.GetSubjectsResponse;

public interface SubjectsService {
  GetSubjectsResponse findAllSubjects(GetSubjectsRequest getSubjectsRequest);

  GetSubjectsResponse addSubject(AddOrRemoveSubjectRequest addOrRemoveSubjectRequest);

  GetSubjectsResponse removeSubject(AddOrRemoveSubjectRequest addOrRemoveSubjectRequest);
}
