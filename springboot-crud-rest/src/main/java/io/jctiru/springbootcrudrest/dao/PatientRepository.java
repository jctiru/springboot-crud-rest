package io.jctiru.springbootcrudrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jctiru.springbootcrudrest.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
