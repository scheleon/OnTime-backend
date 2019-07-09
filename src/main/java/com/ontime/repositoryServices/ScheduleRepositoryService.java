package com.ontime.repositoryServices;

import com.ontime.dto.Lecture;

import java.util.List;

public interface ScheduleRepositoryService {
  List<Lecture> findScheduleByUserIdAndDay(String userId, String day);

  List<Lecture> updateSchedule(String userId, String day, Lecture lecture);

  List<Lecture> removeLectureFromSchedule(String userId, String day, Lecture lecture);
}
