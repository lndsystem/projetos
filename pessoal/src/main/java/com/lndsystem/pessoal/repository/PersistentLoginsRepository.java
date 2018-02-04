package com.lndsystem.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lndsystem.pessoal.model.PersistentLogins;

public interface PersistentLoginsRepository extends JpaRepository<PersistentLogins, Long> {

}
