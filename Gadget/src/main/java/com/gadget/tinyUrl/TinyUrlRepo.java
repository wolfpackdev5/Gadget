package com.gadget.tinyUrl;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TinyUrlRepo extends JpaRepository<TinyUrl, Long>{
	
	TinyUrl findByTinyUrl(String tinyUrl);
	TinyUrl findByOriginalUrl(String originalUrl);

}
