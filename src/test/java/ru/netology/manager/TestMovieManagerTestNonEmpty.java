package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;


public class TestMovieManagerTestNonEmpty {
    Movie first = new Movie(1, "1111", "Forest Gamp", "drama", false);
    Movie second = new Movie(2, "2222", "TBV", "comedy", false);
    Movie third = new Movie(3, "3333", "Aquaman", "action", true);
    Movie forth = new Movie(4, "4444", "Notebook", "drama", false);
    Movie fifth = new Movie(5, "5555", "Dumb & Damber", "comedy", false);
    Movie sixth = new Movie(6, "6666", "Captain America", "action", true);
    Movie seventh = new Movie(7, "7777", "Ray", "drama", false);
    Movie eighth = new Movie(8, "8888", "American pie", "comedy", false);
    Movie nineth = new Movie(9, "9999", "Spiderman", "action", true);
    Movie tenth = new Movie(10, "1010", "Pearl Harbor", "drama", false);
    Movie eleventh = new Movie(11, "1111.11", "Eurotrip", "comedy", false);
    Movie twelvth = new Movie(12, "1212.12", "Batman", "action", true);

    @Test
    public void shouldGiveLastAddIfTen() {
        MovieManager manager = new MovieManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelvth);

        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{twelvth, eleventh, tenth, nineth, eighth, seventh, sixth, fifth, forth, third};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGiveLastAddIfLessTen() {
        MovieManager manager = new MovieManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);


        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{fifth, forth, third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGiveLastAddedSettedUpOfNumbers() {
        MovieManager manager = new MovieManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelvth);

        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{twelvth, eleventh, tenth, nineth, eighth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastAddedWithAllAgsConstr() {
        MovieManager manager = new MovieManager(new Movie[]{first, second, third}, 2);

        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{eleventh, tenth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveLastAddedWithoutMovieInInitial() {
        MovieManager manager = new MovieManager();
        manager.getNumberOfLast();
        manager.getMovies();

        manager.add(tenth);

        Movie[] actual = manager.getLastAdded();
        Movie[] expected = new Movie[]{tenth};

        Assertions.assertArrayEquals(expected, actual);
    }
}