package com.ontime.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SubjectWiseAttendanceInfo {
  String subjectName;
  int totalClass;
  int classesAttended;
  Double percentage;

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public int getTotalClass() {
    return totalClass;
  }

  public void setTotalClass(int totalClass) {
    this.totalClass = totalClass;
  }

  public int getClassesAttended() {
    return classesAttended;
  }

  public void setClassesAttended(int classesAttended) {
    this.classesAttended = classesAttended;
  }

  public Double getPercentage() {
    return percentage;
  }

  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }
}
