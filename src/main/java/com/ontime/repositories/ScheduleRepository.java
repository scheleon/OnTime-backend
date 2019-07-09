package com.ontime.repositories;

import com.ontime.models.DayWiseScheduleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ScheduleRepository extends MongoRepository<DayWiseScheduleEntity, String> {
  @Query("{$and: [{'userId' : '?0'},{'day' : '?1'}]}")
  DayWiseScheduleEntity findScheduleByUserIdAndDay(String userId, String day);

}
