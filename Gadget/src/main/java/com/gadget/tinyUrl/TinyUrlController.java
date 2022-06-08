package com.gadget.tinyUrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
@RestController
@CrossOrigin
@RequestMapping("/")
public class TinyUrlController {
	@Autowired
	private final TinyUrlService tus;
	
	public TinyUrlController(TinyUrlService tus) {
		this.tus = tus;
	}
	
	/**
	 * get method that returns all urls
	 */
	@GetMapping("all")
	public ResponseEntity<List<TinyUrl>> getTinys() {
		List<TinyUrl> listOfTinys = tus.getTinyUrls();
		return new ResponseEntity<>(listOfTinys, HttpStatus.OK);
	}
	
	/**
	 * post method that creates the TinyUrl objects
	 */
	@PostMapping("create")
	public ResponseEntity<TinyUrl> createTiny(@RequestBody String originalUrl) {
		TinyUrl tiny = tus.createTinyUrl(originalUrl);
		return new ResponseEntity<>(tiny, HttpStatus.OK);
	}
	
	/**
	 * get method that redirects to the originalUrl by 
	 * finding the TinyUrl object with a matching tinyurl
	 */
	@GetMapping("{tinyUrl}")
	public ResponseEntity<?> redirectToUrl(@PathVariable("tinyUrl") String tinyUrl, HttpServletResponse response) throws IOException {
		TinyUrl redirect = tus.findTinyUrl(tinyUrl);
		response.sendRedirect(redirect.getOriginalUrl());
		
		return null;
	}
	

}
