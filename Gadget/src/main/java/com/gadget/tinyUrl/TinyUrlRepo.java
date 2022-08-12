package com.gadget.TinyUrl;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TinyUrlRepo extends JpaRepository<TinyUrl, Long>{
	
	TinyUrl findByTinyUrl(String tinyUrl);
	TinyUrl findByOriginalUrl(String originalUrl);

}
