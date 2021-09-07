package tech.ivery.BowtieStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tech.ivery.BowtieStore.services.BowtieServImpl;

@Controller
public class BowtieController {
	private BowtieServImpl bServ;
	
	@Autowired
	public BowtieController(BowtieServImpl b) {
		this.bServ = b;
	}
}
