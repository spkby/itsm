package com.training.mapper;

import com.training.State;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StateMapper {

    @Select("Select * from states where id = #{id}")
    State getStateById(@Param("id") Integer stateId);
}
