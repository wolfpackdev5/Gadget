package com.gadget.tinyUrl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TinyUrlService {
	
	private final TinyUrlRepo tur;
	@Autowired
	public TinyUrlService(TinyUrlRepo tur) {
		this.tur = tur;
	}
	/**
	 * returns all TinyUrl objects created
	 * @return
	 */
	public List<TinyUrl> getTinyUrls() {
		return this.tur.findAll();
	}
	
	/**
	 * creates a TinyUrl object with all values initialized and then 
	 * saved to the repo
	 * 
	 * @param originalUrl
	 * @return TinyUrl object created from the constructor method 
	 */
	public TinyUrl createTinyUrl(String originalUrl) {
		TinyUrl tiny = new TinyUrl(originalUrl);
		tur.save(tiny);
		return tiny;
	}
	
	public TinyUrl findTinyUrl(String tinyUrl) {
		TinyUrl thisOne = this.tur.findByTinyUrl(tinyUrl);
		return thisOne;
	}

}
