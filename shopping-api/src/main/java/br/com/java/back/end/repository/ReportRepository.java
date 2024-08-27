package br.com.java.back.end.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.java.back.end.dto.ShopReportDTO;
import br.com.java.back.end.model.Shop;

@Repository
public interface ReportRepository {
	
	List<Shop> getShopsByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
    ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
