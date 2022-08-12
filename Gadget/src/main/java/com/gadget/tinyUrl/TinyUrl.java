package com.gadget.TinyUrl;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.hash.Hashing;
import com.nimbusds.jose.util.StandardCharset;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class TinyUrl {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String originalUrl;
	@Column
	private String tinyUrl;
	@Column
	private String user;
	
	public TinyUrl(String originalUrl) {
		this.originalUrl = originalUrl;
		//still need to find a way to make the resulting hash unique even if its already been entered before 
		this.tinyUrl = Hashing.murmur3_32().hashString(originalUrl, StandardCharset.UTF_8).toString();
				
		this.user = "Devin";
	}
	
	public TinyUrl() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
