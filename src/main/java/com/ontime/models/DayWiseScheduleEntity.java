package com.ontime.models;

import com.ontime.dto.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "schedule")
@NoArgsConstructor
@AllArgsConstructor
public class DayWiseScheduleEntity {
  @Id
  private String userId;

  private String day;

  private List<Lecture> lectures;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public List<Lecture> getLectures() {
    return lectures;
  }

  public void setLectures(List<Lecture> lectures) {
    this.lectures = lectures;
  }
}
