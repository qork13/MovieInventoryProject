package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="DATE_RELEASED")
	private LocalDate dateReleased;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="DIRECTOR_ID")
	private Director director;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, LocalDate dateReleased) {
		super();
		this.title = title;
		this.dateReleased = dateReleased;
	}
	
	public Movie(String title, LocalDate dateReleased, Director director) {
		super();
		this.title = title;
		this.dateReleased = dateReleased;
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", dateReleased=" + dateReleased + "director=" + director.getName() + "]";
	}
}
