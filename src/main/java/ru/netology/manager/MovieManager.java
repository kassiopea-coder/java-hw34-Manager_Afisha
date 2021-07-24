package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieManager {

  private Movie[] movies = new Movie[0];


  private int numberOfLast = 10;

  public MovieManager(int numberOfLast) {
    this.numberOfLast = numberOfLast;
  }


  public void add(Movie movie) {
    int length = movies.length + 1;
    Movie[] tmp = new Movie[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = movie;
    movies = tmp;
  }


  public Movie[] getLastAdded() {
    int length;
    if (this.numberOfLast > movies.length) {
      length = movies.length;
    } else {
      length = Math.min(this.numberOfLast, movies.length);
    }
    Movie[] result = new Movie[length];
    //Movie[] result = new Movie[movies.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }

}
