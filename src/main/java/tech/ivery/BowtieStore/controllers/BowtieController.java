package tech.ivery.BowtieStore.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.ivery.BowtieStore.models.Bowtie;
import tech.ivery.BowtieStore.services.BowtieServImpl;

@Controller
@RequestMapping("/bowtie")
public class BowtieController {
	private BowtieServImpl bServ;
	
	@Autowired
	public BowtieController(BowtieServImpl b) {
		this.bServ = b;
	}
	
	@GetMapping("/all")
	public ResponseEntity<Set<Bowtie>> getAllBowtie(){
		return ResponseEntity.ok(bServ.getAllBowtie());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bowtie> getBowtieById(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(bServ.getBowtieById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/add-bowtie")
	public ResponseEntity<Bowtie> addBowtie(Bowtie bowtie){
		return ResponseEntity.ok(bServ.addBowtie(bowtie));
	}
	
	@PutMapping("/update-bowtie")
	public ResponseEntity<Void> updateBowtie(Bowtie bowtie){
		bServ.updateBowtie(bowtie);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete-bowtie")
	public ResponseEntity<Void> deleteBowtie(Bowtie bowtie){
		bServ.deleteBowtie(bowtie);
		return ResponseEntity.ok().build();
	}
}
