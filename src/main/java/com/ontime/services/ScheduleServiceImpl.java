package com.ontime.services;

import com.ontime.dto.Lecture;
import com.ontime.dto.Subject;
import com.ontime.exchanges.GetDayWiseScheduleRequest;
import com.ontime.exchanges.ScheduleResponse;
import com.ontime.exchanges.UpdateScheduleRequest;
import com.ontime.repositoryServices.ScheduleRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  @Autowired
  private ScheduleRepositoryService scheduleRepositoryService;

  @Override
  public ScheduleResponse findDayWiseScheduleResponse(GetDayWiseScheduleRequest getDayWiseScheduleRequest) {
    ScheduleResponse scheduleResponse = new ScheduleResponse();

    scheduleResponse.setLectures(scheduleRepositoryService
        .findScheduleByUserIdAndDay(getDayWiseScheduleRequest.getUserId(),
            getDayWiseScheduleRequest.getDay()));
    return scheduleResponse;
  }

  @Override
  public ScheduleResponse updateSchedule(UpdateScheduleRequest updateScheduleRequest) {
    ScheduleResponse scheduleResponse = new ScheduleResponse();
    Subject subject = new Subject();
    subject.setSubjectName(updateScheduleRequest.getSubjectName());
    Lecture lecture = new Lecture();
    lecture.setDuration(updateScheduleRequest.getDuration());
    lecture.setSubject(subject);
    lecture.setStartTime(updateScheduleRequest.getStartTime());
    scheduleResponse.setLectures(scheduleRepositoryService
        .updateSchedule(updateScheduleRequest.getUserId(),
                        updateScheduleRequest.getDay(),
                        lecture));
    return scheduleResponse;
  }

  @Override
  public ScheduleResponse removeLectureFromSchedule(UpdateScheduleRequest updateScheduleRequest) {
    ScheduleResponse scheduleResponse = new ScheduleResponse();
    Subject subject = new Subject();
    subject.setSubjectName(updateScheduleRequest.getSubjectName());
    Lecture lectureToBeRemoved = new Lecture();
    lectureToBeRemoved.setDuration(updateScheduleRequest.getDuration());
    lectureToBeRemoved.setSubject(subject);
    lectureToBeRemoved.setStartTime(updateScheduleRequest.getStartTime());
    scheduleResponse.setLectures(scheduleRepositoryService
        .removeLectureFromSchedule(updateScheduleRequest.getUserId(),
            updateScheduleRequest.getDay(),
            lectureToBeRemoved));

    return scheduleResponse;
  }
}
