package com.project.cinemago;

import com.project.cinemago.cqrs.mediator.Mediator;
import com.project.cinemago.dao.MovieDAO;
import com.project.cinemago.dao.UserDAO;
import com.project.cinemago.models.Movie;
import com.project.cinemago.models.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaGoApplicationTests {

	private static Movie movie1;
	private static Movie movie2;
	private static int noOfTests = 0;
	private static int noOfSuccessfulTests = 0;
	private Mediator mediator = new Mediator();
	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private UserDAO userDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		movie1 = new Movie("Insurgent","sdsd", new Date(System.currentTimeMillis()), "2 h 23 min", 8.35f, "A");
		movie2 = new Movie("Allegiant","sfsg", new Date(System.currentTimeMillis()), "2 h 43 min", 9.99f, "C");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println(noOfTests + " tests have been executed; " + noOfSuccessfulTests + " have been successful");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("A new test begins!");
		noOfTests++;
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Current test finished!");
	}

	@Test
	public void testAddMovie(){
		long noOfMovies = movieDAO.count();
		//ICommand command1 = new InsertMovieCommand(movie1);
		///mediator.mediate(command1);
		movieDAO.save(movie1);
		long newNoOfMovies = movieDAO.count();
		assertTrue(noOfMovies == (newNoOfMovies - 1));
		noOfSuccessfulTests++;
		Movie p = movieDAO.findMovieByName(movie1.getMovieName());
		movieDAO.deleteById(p.getMovieId());
		//ICommand command2 = new DeleteMovieCommand(p.getMovieId());
		//mediator.mediate(command2);
	}

	@Test
	public void testUpdateMovie(){
		//ICommand command1 = new InsertMovieCommand(movie2);
		//mediator.mediate(command1);
		movieDAO.save(movie2);
		Movie p = movieDAO.findMovieByName(movie2.getMovieName());
		p.setMovieName("newName");
		movieDAO.deleteById(p.getMovieId());
		movieDAO.save(p);
		p = movieDAO.findMovieByName("newName");
		assertTrue(p.getMovieImage().equals(movie2.getMovieImage()));
		noOfSuccessfulTests++;
		movieDAO.delete(p);
	}

	@Test
	public void testDeleteMovie(){
			movieDAO.save(movie2);
			long noOfMovies = movieDAO.count();
			Movie p = movieDAO.findMovieByName(movie2.getMovieName());
			movieDAO.delete(p);
			long newNoOfMovies = movieDAO.count();
			assertTrue(noOfMovies == (newNoOfMovies + 1));
			noOfSuccessfulTests++;
	}

	@Test
	public void testRegisterUser(){
		User user = new User("user2", "user2", "user2", "user2", "user2@yahoo.com", "addr");
		long noOfUsers = userDAO.count();
		userDAO.save(user);
		long newNoOfUsers = userDAO.count();
		assertTrue(noOfUsers == (newNoOfUsers - 1));
		userDAO.delete(user);
		noOfSuccessfulTests++;
	}

}
