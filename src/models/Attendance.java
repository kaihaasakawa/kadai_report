package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "attendances")
@NamedQueries({
	@NamedQuery(
			name = "getAllAttendance",
			query = "SEKECT a FROM Attendance AS a ORDER BY a.id DESC"
			),

	@NamedQuery(
			name = "getAttendanceCount",
			query = "SELECT COUNT(a) FROM Attendance AS a"
			),
})
@Entity
public class Attendance {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@Column(name = "attendance_date", nullable = false)
	private Date attendance_date;

	@Column(name = "attendance", length = 50, nullable = false)
	private String attendance;

