package com.itsm.pub.courses.patients.worker.mapper;

import com.itsm.pub.courses.patients.common.entities.State;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StateMapper {

    @Select("Select * from state where id = #{stateId}")
    State getStateById(@Param("stateId") Integer stateId);
}
