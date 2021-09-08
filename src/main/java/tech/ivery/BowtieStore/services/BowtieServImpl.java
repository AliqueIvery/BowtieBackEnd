package tech.ivery.BowtieStore.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ivery.BowtieStore.models.Bowtie;
import tech.ivery.BowtieStore.repositories.BowtieRepo;

@Service
public class BowtieServImpl implements BowtieService {
	private BowtieRepo bRepo;
	
	@Autowired
	public BowtieServImpl(BowtieRepo b) {
		this.bRepo = b;
	}

	@Override
	public Bowtie getBowtieById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return bRepo.getBowtieById(id);
	}

	@Override
	public Set<Bowtie> getAllBowtie() {
		// TODO Auto-generated method stub
		List<Bowtie> list = bRepo.findAll();
		Set<Bowtie> set = new HashSet<>();
		set.addAll(list);
		return set;
	}

	@Override
	public Bowtie addBowtie(Bowtie bowtie) {
		// TODO Auto-generated method stub
		return bRepo.save(bowtie);
	}

	@Override
	public void updateBowtie(Bowtie bowtie) {
		// TODO Auto-generated method stub
		try {
			if(getBowtieById(bowtie.getId()) != null) {
				bRepo.save(bowtie);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBowtie(Bowtie bowtie) {
		// TODO Auto-generated method stub
		try {
			if(getBowtieById(bowtie.getId()) != null) {
				bRepo.delete(bowtie);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
