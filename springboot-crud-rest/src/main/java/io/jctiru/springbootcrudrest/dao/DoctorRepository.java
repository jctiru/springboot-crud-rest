package io.jctiru.springbootcrudrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jctiru.springbootcrudrest.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
