package io.jctiru.springbootcrudrest.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "appointment_time")
	private Timestamp appointmentTime;

	@Column(name = "started")
	private boolean started;

	@Column(name = "ended")
	private boolean ended;

	@Column(name = "reason")
	private String reason;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Timestamp appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPatientAndDoctor(Patient patient, Doctor doctor) {
		this.patient = patient;
		patient.getAppointments().add(this);
		this.doctor = doctor;
		doctor.getAppointments().add(this);
	}

	public void removePatientAndDoctor() {
		this.patient.getAppointments().remove(this);
		this.doctor.getAppointments().remove(this);
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentTime=" + appointmentTime + ", started=" + started + ", ended="
				+ ended + ", reason=" + reason + "]";
	}

}
