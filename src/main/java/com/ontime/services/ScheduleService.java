package com.ontime.services;

import com.ontime.exchanges.GetDayWiseScheduleRequest;
import com.ontime.exchanges.ScheduleResponse;
import com.ontime.exchanges.UpdateScheduleRequest;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {
  ScheduleResponse findDayWiseScheduleResponse(GetDayWiseScheduleRequest getDayWiseScheduleRequest);

  ScheduleResponse updateSchedule(UpdateScheduleRequest updateScheduleRequest);

  ScheduleResponse removeLectureFromSchedule(UpdateScheduleRequest updateScheduleRequest);
}
