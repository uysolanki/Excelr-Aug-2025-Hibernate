package com.excelr.ExcelrAugHibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Builder
public class State {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int sno;
		
		private String sname;
		private String capital;
		
		@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		@JoinColumn(name = "cmno",referencedColumnName = "cmno")
		ChiefMinister chiefMinister;
		
}
