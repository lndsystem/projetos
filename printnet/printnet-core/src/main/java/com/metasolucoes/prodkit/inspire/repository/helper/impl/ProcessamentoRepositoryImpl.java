package com.metasolucoes.prodkit.inspire.repository.helper.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.metasolucoes.prodkit.inspire.model.Processamento;
import com.metasolucoes.prodkit.inspire.model.Status;
import com.metasolucoes.prodkit.inspire.repository.helper.queries.ProcessamentoQueries;

public class ProcessamentoRepositoryImpl implements ProcessamentoQueries {

	@PersistenceContext(unitName = "printnetPersistenceUnitName")
	private EntityManager manager;

	@Override
	public Processamento findProcessamento() {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Processamento.class);
		criteria.add(Restrictions.eq("status.idStatus", 7));
		criteria.add(Restrictions.eq("status.idStatus", 6));
		criteria.add(Restrictions.eq("status.idStatus", 5));
		criteria.add(Restrictions.eq("status.idStatus", 4));
		criteria.add(Restrictions.eq("status.idStatus", 3));
		criteria.add(Restrictions.eq("status.idStatus", 2));
		criteria.setLockMode(LockMode.PESSIMISTIC_WRITE);

		Processamento processamento = (Processamento) criteria.uniqueResult();
		if (processamento != null) {
			processamento.setStatus(new Status(8l));
		}

		return processamento;
	}

}
