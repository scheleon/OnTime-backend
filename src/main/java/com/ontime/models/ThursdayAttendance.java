package com.ontime.models;

import com.ontime.dto.SubjectWiseAttendanceDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "thursday-attendance")
@NoArgsConstructor
@AllArgsConstructor
public class ThursdayAttendance {
  @Id
  String userId;
  List<SubjectWiseAttendanceDetails> subjectWiseList;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public List<SubjectWiseAttendanceDetails> getSubjectWiseList() {
    return subjectWiseList;
  }

  public void setSubjectWiseList(List<SubjectWiseAttendanceDetails> subjectWiseList) {
    this.subjectWiseList = subjectWiseList;
  }
}
