package tech.ivery.BowtieStore.services;

import java.util.Set;

import tech.ivery.BowtieStore.models.Color;

public interface ColorService {
	public Color getColorById(Integer id) throws Exception;
	public Set<Color> getAllColors();
	public Color addColor(Color color) throws Exception;
	public void updateColor(Color color);
	public void deleteColor(Color color);
}
