package com.ontime.controller;

import com.ontime.exchanges.*;
import com.ontime.models.AttendanceData;
import com.ontime.repositories.AttendanceDataRepository;
import com.ontime.services.ScheduleService;
import com.ontime.services.SubjectsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping(OnTimeController.ONTIME_API_ENDPOINT)
public class OnTimeController {
  public static final String ONTIME_API_ENDPOINT = "/ontime/v1";
  public static final String SUBJECTS_API = "/subjects";
  public static final String SCHEDULE_API = "/schedule";
  public static final String ATTENDANCE = "/attendance";

  @Autowired
  private AttendanceDataRepository attendanceDataRepository;

  @Autowired
  private SubjectsService subjectsService;

  @Autowired
  private ScheduleService scheduleService;

  final Logger log =
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  @GetMapping(SUBJECTS_API)
  public ResponseEntity<GetSubjectsResponse> getSubjects(
      @Valid GetSubjectsRequest getSubjectsRequest) {
    if(getSubjectsRequest.getUserId() == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    GetSubjectsResponse getSubjectsResponse;
    getSubjectsResponse = subjectsService.findAllSubjects(getSubjectsRequest);
    return ResponseEntity.ok().body(getSubjectsResponse);
  }

  @RequestMapping(method = RequestMethod.POST, value = SUBJECTS_API)
  public ResponseEntity<GetSubjectsResponse> addSubject(
      @RequestBody AddOrRemoveSubjectRequest addOrRemoveSubjectRequest) {
    GetSubjectsResponse getSubjectsResponse;
    getSubjectsResponse = subjectsService.addSubject(addOrRemoveSubjectRequest);
    return ResponseEntity.ok().body(getSubjectsResponse);
  }

  @DeleteMapping(SUBJECTS_API)
  public ResponseEntity<GetSubjectsResponse> removeSubject(
      @RequestBody AddOrRemoveSubjectRequest addOrRemoveSubjectRequest) {
    GetSubjectsResponse getSubjectsResponse;
    log.info("Info : Delete request for " + addOrRemoveSubjectRequest);
    getSubjectsResponse = subjectsService.removeSubject(addOrRemoveSubjectRequest);
    log.info("Info : " + getSubjectsResponse);
    return ResponseEntity.ok().body(getSubjectsResponse);
  }

  @GetMapping(SCHEDULE_API)
  public ResponseEntity<ScheduleResponse> getTimeTable(
      @Valid GetDayWiseScheduleRequest getDayWiseScheduleRequest) {
    if(getDayWiseScheduleRequest.getUserId() == null
        ||
        getDayWiseScheduleRequest.getDay() == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    ScheduleResponse scheduleResponse;
    try {
      scheduleResponse = scheduleService.findDayWiseScheduleResponse(getDayWiseScheduleRequest);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok().body(scheduleResponse);
  }

  @PostMapping(SCHEDULE_API)
  public ResponseEntity<ScheduleResponse> updateTimeTable(
      @RequestBody UpdateScheduleRequest updateScheduleRequest) {
    ScheduleResponse scheduleResponse;
    scheduleResponse = scheduleService.updateSchedule(updateScheduleRequest);
    return ResponseEntity.ok().body(scheduleResponse);
  }

  @DeleteMapping(SCHEDULE_API)
  public ResponseEntity<ScheduleResponse> removeLectureFromSchedule(
      @RequestBody UpdateScheduleRequest updateScheduleRequest) {
    ScheduleResponse scheduleResponse;
    scheduleResponse = scheduleService.removeLectureFromSchedule(updateScheduleRequest);
    return ResponseEntity.ok().body(scheduleResponse);
  }

//  @PostMapping(ATTENDANCE)
//  public ResponseEntity<AttendanceInfoResponse> updateAttendanceInfo(
//      @RequestBody AttendanceInfoRequest attendanceInfoRequest) {
//    AttendanceInfoResponse attendanceInfoResponse = new AttendanceInfoResponse();
//
//    return ResponseEntity.ok().body(attendanceInfoResponse);
//  }

  @PostMapping(ATTENDANCE)
  public ResponseEntity<String> updateAttendance(
      @RequestBody AttendanceDataRequest attendanceDataRequest) {
    ModelMapper modelMapper = new ModelMapper();
    AttendanceData attendanceData = new AttendanceData();
    System.out.println(attendanceData.getAttendanceStatus());
    modelMapper.map(attendanceDataRequest, attendanceData);
    attendanceDataRepository.save(attendanceData);
    return ResponseEntity.ok().body("Attendance Added");
  }
}
