package by.itsm.patients.worker.mapper;

import by.itsm.patients.common.entity.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ReportsMapper {

    List<Sale> selectSales(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
