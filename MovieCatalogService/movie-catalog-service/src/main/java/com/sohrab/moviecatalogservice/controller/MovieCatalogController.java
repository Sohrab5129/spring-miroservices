package com.sohrab.moviecatalogservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sohrab.moviecatalogservice.model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@GetMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userId) {

		return Collections.singletonList(new CatalogItem("Transformer", "Test", 4));
	}
}
