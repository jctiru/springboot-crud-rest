package io.jctiru.springbootcrudrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jctiru.springbootcrudrest.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
