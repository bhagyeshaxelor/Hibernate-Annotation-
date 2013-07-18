package com.bhagyesh;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "cell_phone")
	private String cell_phone;

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}