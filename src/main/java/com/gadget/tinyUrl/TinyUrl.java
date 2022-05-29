package com.gadget.tinyUrl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.hash.Hashing;
import com.nimbusds.jose.util.StandardCharset;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table
public class TinyUrl {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String originalUrl;
	@Column
	private String tinyUrl;
	@Column
	private String user;
	
	public TinyUrl(String originalUrl, String user) {
		this.originalUrl = originalUrl;
		this.user = user;
		this.tinyUrl = Hashing.murmur3_32().hashString(originalUrl, StandardCharset.UTF_8).toString();
		this.user = user;
	}
	
	public TinyUrl() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	

}
