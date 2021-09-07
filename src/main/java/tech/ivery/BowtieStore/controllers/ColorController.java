package tech.ivery.BowtieStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tech.ivery.BowtieStore.repositories.ColorServImpl;

@Controller
public class ColorController {
	private ColorServImpl cServ;
	
	@Autowired
	public ColorController(ColorServImpl c) {
		this.cServ = c;
	}
	
}
