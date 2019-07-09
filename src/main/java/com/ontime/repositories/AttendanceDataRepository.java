package com.ontime.repositories;

import com.ontime.models.AttendanceData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttendanceDataRepository extends MongoRepository<AttendanceData, String> {
}
