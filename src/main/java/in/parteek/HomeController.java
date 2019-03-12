/**
 * 
 */
package in.parteek;

import java.util.List;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.parteek.Dao.Dao;
import in.parteek.beans.Movie;

/**
 * Created on : 2019-03-07, 8:30:51 a.m.
 *
 * @author Parteek Dheri
 */
@Controller
public class HomeController {
	Dao dao = new Dao();

	@RequestMapping("/")
	public String goHome(Model model) {
		// required if there's a form binding in this jsp
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "addMovie";
	}

	@RequestMapping("/SearchGenre")
	public String searchGenre(Model model, @ModelAttribute Movie movie) {

		List<Movie> movies = dao.getMovieByGenre(movie.getGenre());
		model.addAttribute("movies", movies);

		movie = new Movie();
		model.addAttribute("movie", movie);
		return "searchByGenre";
	}

	@RequestMapping("/DoSearch")
	public String doSearch(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "searchByGenre";
	}

	@RequestMapping("/Delete/{id}")
	public String deleteMovie(Model model, @PathVariable int id) {

		Movie movie = dao.getMovieById(id);
		if (movie != null) {
			dao.deleteMovieById(id);
		} else {
			movie = new Movie();
		}

		List<Movie> movies = dao.getMovies();
		model.addAttribute("movies", movies);
		return "listMovies";
	}
//	EditMovie

	@RequestMapping("/EditMovie")
	public String editMovie2(@ModelAttribute Movie movie, Model model, @RequestParam int id) {

//		System.out.println("-> " + movie.toString());
//		System.out.println("Id -> " + id);

		dao.editMovieById(id, movie);
		
		List<Movie> movies = dao.getMovies();
		model.addAttribute("movies", movies);

		return "listMovies";

	}

	@RequestMapping("/Edit/{id}")
	public String editMovie(Model model, @PathVariable int id) {

		Movie movie = dao.getMovieById(id);

		model.addAttribute("movie", movie);
		return "editMovie";
	}

//	@RequestMapping("/Edit/{id}")
//	public String editMovie(Model model, @PathVariable int id) {
//
//		Movie movie = dao.getMovieById(id);
//		if (movie != null) {
//			dao.deleteMovieById(id);
//		} else {
//			movie = new Movie();
//		}
//		model.addAttribute("movie", movie);
//		return "addMovie";
//	}

	@RequestMapping("/ListMovies")
	public String getMovies(Model model) {
		List<Movie> movies = dao.getMovies();
		model.addAttribute("movies", movies);

		return "listMovies";
	}

	@RequestMapping("/AddMovie")
	public String addMove(@ModelAttribute Movie movie, Model model) {

		synchronized (Movie.class) {
			Dao dao = new Dao();
			dao.addMovie(movie);
		}

		Movie myMovie = new Movie();
//		System.out.println("-> " + movie.toString());
		model.addAttribute("movie", myMovie);
		return "addMovie";
	}

	@RequestMapping("/generateDummyRecords")
	public String generateDummyRecords(Model model) {
		Dao dao = new Dao();
		dao.genereateDummyRecords();
		return "home";
	}

}
