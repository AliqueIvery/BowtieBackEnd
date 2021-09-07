package tech.ivery.BowtieStore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Color {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="color")
	private String color;
	@ManyToOne
	@JoinColumn(name="bowtie_id")
	private Bowtie bowtie;
	
	public Color() {
		this.id = 0;
		this.bowtie = new Bowtie();
		this.color = "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Bowtie getBowtie() {
		return bowtie;
	}

	public void setBowtie(Bowtie bowtie) {
		this.bowtie = bowtie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bowtie == null) ? 0 : bowtie.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (bowtie == null) {
			if (other.bowtie != null)
				return false;
		} else if (!bowtie.equals(other.bowtie))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + ", bowtie=" + bowtie + "]";
	}
}
