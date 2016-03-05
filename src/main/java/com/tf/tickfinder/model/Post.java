package com.tf.tickfinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	@Column(name = "source", nullable=false)
	private String source;

	@Column(name = "polarity", nullable=false)
	private int polarity;

	@Column(name = "content")
	private String content;

	public Post() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getPolarity() {
		return polarity;
	}

	public void setPolarity(int polarity) {
		this.polarity = polarity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
