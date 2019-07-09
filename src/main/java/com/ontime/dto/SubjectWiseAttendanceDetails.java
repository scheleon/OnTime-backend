package com.ontime.dto;

import java.util.List;

public class SubjectWiseAttendanceDetails {
  String subjectName;
  List<Attendance> attendanceList;

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public List<Attendance> getAttendanceList() {
    return attendanceList;
  }

  public void setAttendanceList(List<Attendance> attendanceList) {
    this.attendanceList = attendanceList;
  }
}
