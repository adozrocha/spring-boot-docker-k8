package br.com.java.back.end.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.core.dto.ShopReportDTO;
import br.com.java.back.end.model.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Shop> getShopsByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {
		var sb = new StringBuilder();
		sb.append("select s ");
		sb.append("from Shop s ");
		sb.append("where s.date >= :dataInicio ");

		if (dataFim != null) {
			sb.append("and s.date <= :dataFim ");
		}

		if (valorMinimo != null) {
			sb.append("and s.total <= :valorMinimo");
		}

		TypedQuery<Shop> query = entityManager.createQuery(sb.toString(), Shop.class);
		query.setParameter("dataInicio", dataInicio);

		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);
		}

		if (valorMinimo != null) {
			query.setParameter("valorMinimo", valorMinimo);
		}

		return query.getResultList();
	}

	@Override
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		String sb = "select count(sp.id), sum(sp.total), avg(sp.total) " + "from shopping.shop sp "
				+ "where sp.date >= :dataInicio " + "and sp.date <= :dataFim ";

		var query = entityManager.createNativeQuery(sb);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);

		Object[] result = (Object[]) query.getSingleResult();
		var shopReportDTO = new ShopReportDTO(((BigInteger) result[0]).intValue(), (Double) result[0],(Double) result[0]);
		return shopReportDTO;
	}

}
