package com.study.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "slaveList")
@Entity
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	
	private String code;
	private String comment;
	
	@OneToMany(fetch = FetchType.EAGER,
			mappedBy = "master",
			cascade = CascadeType.ALL)
	private List<Slave> slaveList = new ArrayList<>();
	
	public void addSlave(Slave slave) {
		slave.setIdx(this.slaveList.size());
		slave.setMaster(this);
		slaveList.add(slave);
	}
}
