package com.ontime.exchanges;

import com.ontime.dto.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
  private List<Lecture> lectures = new ArrayList<>();

  public List<Lecture> getLectures() {
    return lectures;
  }

  public void setLectures(List<Lecture> lectures) {
    this.lectures = lectures;
  }
}
