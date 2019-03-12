/**
 * 
 */
package in.parteek.Dao;

import java.util.*;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.parteek.beans.Movie;

/**
 * Created on : 2019-03-07, 9:14:43 a.m.
 *
 * @author Parteek Dheri
 */
public class Dao {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void addMovie(Movie movie) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(movie);

		session.getTransaction().commit();
		session.close();
	}

	public void editMovieById(int id, Movie movie) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Movie m = (Movie) session.get(Movie.class, id);

		m.setTitle(movie.getTitle());
		m.setGenre(movie.getGenre());
		m.setRunningTime(movie.getRunningTime());
		session.getTransaction().commit();
		session.close();
	}

	public List<Movie> getMovieByGenre(String genre) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Movie> movies;
		Query query = session.createQuery("from Movie where genre=:genre");
		query.setParameter("genre", genre);

		movies = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return movies;

	}

	public List<Movie> getMovies() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Movie> movies;
		Query query = session.createQuery("from Movie");
		movies = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return movies;
	}

	public void deleteMovieById(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Movie m = (Movie) session.get(Movie.class, id);
		session.delete(m);

		session.getTransaction().commit();
		session.close();
	}

	public Movie getMovieById(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Movie> movies;
		Query query = session.createQuery("from Movie where id=:id");
		query.setParameter("id", id);

		movies = query.getResultList();

		session.getTransaction().commit();
		session.close();

		if (movies == null || movies.size() == 0) {
			return null;
		} else {
			return movies.get(0);
		}
	}

	public void genereateDummyRecords() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Random rand = new Random();
		Movie m = new Movie();

		for (int i = 0; i < 10; i++) {

			int randomIndex = rand.nextInt(m.getGenreList().length);
			session.save(new Movie("Movie" + i * 7 + " ", m.getGenreList()[randomIndex], i * 12));

		}

		session.getTransaction().commit();
		session.close();
	}

}
