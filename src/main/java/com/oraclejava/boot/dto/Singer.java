package com.oraclejava.boot.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SINGER")
public class Singer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "singerGenerator")
	@SequenceGenerator(name = "singerGenerator",sequenceName = "SINGER_SEQ" ,allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	//사진 컬럼
	private byte[] photo;
	
	// Getter & Setter
	
	public String getBirthDateString() {
		if(birthDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			return sdf.format(birthDate);
		} else {
			return null;
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	// 정신건강 상 toString()이 있으면 보기 편하다.
	@Override
	public String toString() {
		return "Singer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + ", birthDate=" + birthDate + "]";
	}
}
