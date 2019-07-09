package com.ontime.models;

import com.ontime.dto.SubjectWiseAttendanceInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "attendance-info")
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceInfo {

  @Id
  String userId;
  List<SubjectWiseAttendanceInfo> subjectWiseAttendances;
}
