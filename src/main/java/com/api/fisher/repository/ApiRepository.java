package com.api.fisher.repository;

import com.api.fisher.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Domain,Long> {

}
