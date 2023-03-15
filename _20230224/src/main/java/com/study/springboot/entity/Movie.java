package com.study.springboot.entity;


import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Movie implements Serializable {
	@EmbeddedId
	MoviePK moviePK;
	
	@MapsId("type")
	@ManyToOne(targetEntity = MovieCategory.class)
	@JoinColumn(name="movieCategory_type")
	public MovieCategory movieCategory;
	
	private String title;
	private String content;
}
