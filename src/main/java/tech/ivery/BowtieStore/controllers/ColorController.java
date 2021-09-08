package tech.ivery.BowtieStore.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.ivery.BowtieStore.models.Color;
import tech.ivery.BowtieStore.repositories.ColorServImpl;

@Controller
@RequestMapping("/color")
public class ColorController {
	private ColorServImpl cServ;
	
	@Autowired
	public ColorController(ColorServImpl c) {
		this.cServ = c;
	}
	
	@GetMapping("/all")
	public ResponseEntity<Set<Color>> getAllColors(){
		return ResponseEntity.ok(cServ.getAllColors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Color> getColorById(@PathVariable("id") Integer id){
		try {
			return ResponseEntity.ok(cServ.getColorById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/add-color")
	public ResponseEntity<Color> addColor(Color color){
		try {
			return ResponseEntity.ok(cServ.addColor(color));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/update-color")
	public ResponseEntity<Void> updateColor(Color color){
		cServ.updateColor(color);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> deleteColor(Color color){
		cServ.deleteColor(color);
		return ResponseEntity.ok().build();
	}
}
