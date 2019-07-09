package com.ontime.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Lecture {
  private Subject subject;
  private String startTime;
  private String duration;

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }
}
