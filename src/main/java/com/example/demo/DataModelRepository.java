package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;


public interface DataModelRepository extends CrudRepository<DataModel, Long> {

    @Query("SELECT dm " +
            " FROM DataModel dm " +
            "WHERE (dm.ts1 IS NULL OR :ts1 IS NULL OR dm.ts1 < :ts1) " +
            "  AND (dm.ts2 IS NULL OR :ts2 IS NULL OR dm.ts2 < :ts2)")
    List<DataModel> findByTimestamps(@Param("ts1") Timestamp ts1, @Param("ts2") Timestamp ts2);

}
