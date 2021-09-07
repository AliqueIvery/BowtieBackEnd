package tech.ivery.BowtieStore.services;

import java.util.Set;

import tech.ivery.BowtieStore.models.Bowtie;

public interface BowtieService {
	public Bowtie getBowtieById(Integer id) throws Exception;
	public Set<Bowtie> getAllBowtie();
	public Bowtie addBowtie(Bowtie bowtie);
	public void updateBowtie(Bowtie bowtie);
	public void deleteBowtie(Bowtie bowtie);
}
