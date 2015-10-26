package de.herbstmensch.enigma.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("e2movielist")
public class MovieList {

	@XStreamImplicit(itemFieldName = "e2movie")
	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "MovieList [movies=" + movies + "]";
	}

}
