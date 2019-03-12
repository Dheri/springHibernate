
package in.parteek.beans;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * Created on : 2019-03-07, 8:55:18 a.m.
 *
 * @author Parteek Dheri
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String genre;
	// Won't store the field in the DB
	@Transient
	private String[] genreList = { "SciFi", "Horror", "Thriller", "Comedy", "Action" };
	private int runningTime;

	public Movie(String title, String genre, int runningTime) {
		this.title = title;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
