package tech.ivery.BowtieStore.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ivery.BowtieStore.models.Color;
import tech.ivery.BowtieStore.repositories.ColorRepo;
@Service
public class ColorServImpl implements ColorService {
	private ColorRepo cRepo;
	
	@Autowired
	public ColorServImpl(ColorRepo c) {
		this.cRepo = c;
	}
	
	@Override
	public Color getColorById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cRepo.getColorById(id);
	}

	@Override
	public Set<Color> getAllColors() {
		// TODO Auto-generated method stub
		List<Color> color = cRepo.findAll();
		Set<Color> set = new HashSet<>();
		set.addAll(color);
		return set;
	}

	@Override
	public Color addColor(Color color) throws Exception {
		// TODO Auto-generated method stub
		return cRepo.save(color);
	}

	@Override
	public void updateColor(Color color) {
		// TODO Auto-generated method stub
		try {
			if(getColorById(color.getId())!= null) {
				cRepo.save(color);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteColor(Color color) {
		// TODO Auto-generated method stub
		try {
			if(getColorById(color.getId())!= null) {
				cRepo.delete(color);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
