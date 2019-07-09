package com.ontime.repositoryServices;

import com.ontime.dto.Lecture;
import com.ontime.models.DayWiseScheduleEntity;
import com.ontime.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleRepositoryServiceImpl implements ScheduleRepositoryService {

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Override
  public List<Lecture> findScheduleByUserIdAndDay(String userId, String day) {
    DayWiseScheduleEntity scheduleByDay = scheduleRepository
        .findScheduleByUserIdAndDay(userId, day);
    if (scheduleByDay != null && scheduleByDay.getLectures().size() > 0) {
      return scheduleByDay.getLectures();
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Lecture> updateSchedule(String userId, String day, Lecture lecture) {
    DayWiseScheduleEntity scheduleByDay = new DayWiseScheduleEntity();
    List<Lecture> lectures = new ArrayList<>();
    try {
      scheduleByDay = scheduleRepository
          .findScheduleByUserIdAndDay(userId, day);
      boolean exists = false;
      for (Lecture lectureFromList : scheduleByDay.getLectures()) {
        if (lecture.getStartTime().equals(lectureFromList.getStartTime())
            &&
            lecture.getSubject().getSubjectName().equals(lectureFromList.getSubject().getSubjectName())
            &&
            lecture.getDuration().equals(lectureFromList.getDuration())) {
          exists = true;
          break;
        }
      }
      if (!exists) {
        scheduleByDay.getLectures().add(lecture);
      }
      lectures = scheduleByDay.getLectures();
    } catch (Exception e) {
      scheduleByDay.setUserId(userId);
      scheduleByDay.setDay(day);
      lectures.add(lecture);
      scheduleByDay.setLectures(lectures);
    }
    scheduleRepository.save(scheduleByDay);
    return lectures;
  }

  @Override
  public List<Lecture> removeLectureFromSchedule(String userId, String day, Lecture lecture) {
    DayWiseScheduleEntity scheduleByDay = new DayWiseScheduleEntity();
    List<Lecture> lectures = new ArrayList<>();
    try {
      scheduleByDay = scheduleRepository
          .findScheduleByUserIdAndDay(userId, day);
      boolean exists = false;
      int index = -1;
      for (Lecture lectureFromList : scheduleByDay.getLectures()) {
        if (lecture.getStartTime().equals(lectureFromList.getStartTime())
            &&
            lecture.getSubject().getSubjectName().equals(lectureFromList.getSubject().getSubjectName())
            &&
            lecture.getDuration().equals(lectureFromList.getDuration())) {
          exists = true;
          break;
        }
        index++;
      }
      if (exists) {
        scheduleByDay.getLectures().remove(index);
      }
      scheduleRepository.save(scheduleByDay);
      lectures = scheduleByDay.getLectures();
    } catch (Exception e) {
      // Do Nothing
    }
    return lectures;
  }
}
