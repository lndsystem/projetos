package com.metasolucoes.prodkit.inspire.repository.helper.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.transaction.annotation.Transactional;

import com.metasolucoes.prodkit.inspire.model.Usuario;
import com.metasolucoes.prodkit.inspire.repository.helper.queries.UsuarioQueries;

public class UsuarioRepositoryImpl implements UsuarioQueries {

	@PersistenceContext(unitName = "printnetPersistenceUnitName")
	private EntityManager manager;

	@Transactional(readOnly = true)
	@Override
	public Usuario buscarComGrupo(Long idUsuario) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		criteria.createAlias("grupos", "g", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("idUsuario", idUsuario));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Usuario) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAllFull() {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		criteria.createAlias("grupos", "g", JoinType.LEFT_OUTER_JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Transactional(readOnly = true)
	@Override
	public List<String> permissoes(Usuario usuario) {
		return manager.createQuery("select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u=:usuario", String.class).setParameter("usuario", usuario)
				.getResultList();
	}

}
