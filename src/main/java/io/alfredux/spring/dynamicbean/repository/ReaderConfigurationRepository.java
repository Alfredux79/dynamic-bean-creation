package io.alfredux.spring.dynamicbean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.alfredux.spring.dynamicbean.domain.ReaderConfiguration;

@Repository
public interface ReaderConfigurationRepository extends JpaRepository<ReaderConfiguration, Long> {

}
