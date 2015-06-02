package by.bsuir.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.persistence.LockTimeoutException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.engine.internal.TwoPhaseLoad;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.internal.SQLExceptionTypeDelegate;
import org.hibernate.metamodel.relational.IllegalIdentifierException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import by.bsuir.entity.City;
import by.bsuir.entity.Crew;
import by.bsuir.entity.Pilot;
import by.bsuir.entity.Plane;
import by.bsuir.service.Factory;



@Controller
public class adminController extends functions {


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView forwardAdmin(Locale locale) {
		ModelAndView model = new ModelAndView("adminPage");
		return model;

	}

	@RequestMapping(value = "/viewPlanes", method = RequestMethod.GET)
	public ModelAndView allPlane(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("viewPlanes");
		model.addObject("planiys", Factory.getInstance().getPlaneDao().getAll());
		return model;
	}

	@RequestMapping(value = "/addPlane", method = RequestMethod.GET)
	public ModelAndView addPlane(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("addPlane");
		return model;

	}


	@RequestMapping(value = { "/add_plane" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addPlane(
			@RequestParam("name") String name,
			@RequestParam("number") int number,
			@RequestParam("placecol") int places) throws SQLException,
			IOException, ServletException {

		ModelAndView modelAndView = new ModelAndView("viewPlanes");

		Plane plane = new Plane();
		plane.setName(name);
		plane.setNumber(number);
		plane.setPlacecol(places);
		Factory.getInstance().getPlaneDao().addGenre(plane);
		modelAndView.addObject("success", "Самолёт добавлен");
		modelAndView.addObject("planiys", Factory.getInstance().getPlaneDao()
				.getAll());

		return modelAndView;
	}

	@RequestMapping(value = "/viewCity", method = RequestMethod.GET)
	public ModelAndView allCity(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("viewCity");
		model.addObject("citys", Factory.getInstance().getCityDao().getAll());
		return model;
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.GET)
	public ModelAndView addaCity(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("addCity");
		return model;

	}

	@RequestMapping(value = { "/add_city" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addCity(@RequestParam("name") String name)
			throws SQLException, IOException, ServletException {
		ModelAndView modelAndView = new ModelAndView("viewCity");
		if (!Validator.isNumberInString(name)) {
			modelAndView.addObject("error",
					"Вназвании не дожно быть посторонних символов символов!");
			modelAndView.addObject("citys", Factory.getInstance().getCityDao()
					.getAll());
			return modelAndView;}		
		City city = new City();
		city.setName(name);
		Factory.getInstance().getCityDao().addGenre(city);	
		modelAndView.addObject("success", "Город добавлен");
		modelAndView.addObject("citys", Factory.getInstance().getCityDao()
				.getAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/deleteCity" }, method = RequestMethod.GET)
	public ModelAndView deleteCity(HttpServletRequest req) throws 
	IOException, ServletException {	
		ModelAndView modelAndView = new ModelAndView("viewCity");
		try{
			if(req.getParameterValues("cityid")==null){
				modelAndView.addObject("error", "Выберите город, который хотите удалить");			
			}
			else{
				String[] checks = req.getParameterValues("cityid");
				City city = new City();

				for (int i = 0; i <= checks.length - 1; i++) {

					city = Factory.getInstance().getCityDao()
							.getGenre(Integer.valueOf(checks[i]));
					Factory.getInstance().getCityDao().deleteGenre(city);
				}
				modelAndView.addObject("success", "Данные удалены");
			}
			modelAndView.addObject("citys", Factory.getInstance().getCityDao()
					.getAll());
		}catch(SQLException e){
			modelAndView.addObject("error", "запись не может быть удалена");
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/deletePlane" }, method = RequestMethod.GET)
	public ModelAndView deletePlane(HttpServletRequest req) throws 
	IOException, ServletException, NumberFormatException, SQLException {
		ModelAndView modelAndView = new ModelAndView("viewPlanes");
		try{
			if(req.getParameterValues("idplane")==null){
				modelAndView.addObject("error", "Выберите самолёт, который хотите удалить");			
			}
			else{
				Plane plane = new Plane();

				String[] checks = req.getParameterValues("idplane");
				for (int i = 0; i <= checks.length - 1; i++) {

					plane = Factory.getInstance().getPlaneDao()
							.getGenre(Integer.valueOf(checks[i]));
					Factory.getInstance().getPlaneDao().deleteGenre(plane);
				}
				modelAndView.addObject("success", "Данные удалены");
			}		
			modelAndView.addObject("planiys", Factory.getInstance().getPlaneDao()
					.getAll());
		}catch(ConstraintViolationException e ){
			modelAndView.addObject("error", "запись не может быть удалена");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/viewCrew", method = RequestMethod.GET)
	public ModelAndView allCrew(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("viewCrew");
		model.addObject("crews", Factory.getInstance().getCrewtDao().getAll());
		return model;
	}

	@RequestMapping(value = "/addCrew", method = RequestMethod.GET)
	public ModelAndView addaCrew(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("addCrew");
		return model;

	}

	@RequestMapping(value = { "/add_crew" }, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addCew(HttpServletRequest request)
			throws SQLException, IOException, ServletException, ParseException {
		ModelAndView modelAndView = new ModelAndView("viewCrew");
		if (!Validator.isNumberInString(request.getParameter("firstname1"))
				|| !Validator.isNumberInString(request.getParameter("secondname1"))
				|| !Validator.isNumberInString(request.getParameter("middlename1")) 
				|| !Validator.isNumberInString(request.getParameter("firstname2"))
				|| !Validator.isNumberInString(request.getParameter("secondname2"))
				|| !Validator.isNumberInString(request.getParameter("middlename2"))) {

			modelAndView.addObject("error", "В инициалах не дожно быть посторонних символов символов!");
			modelAndView.addObject("crews", Factory.getInstance().getCrewtDao()
					.getAll());
			return modelAndView;}	

		Pilot pilot1 = new Pilot();
		Pilot pilot2 = new Pilot();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		pilot1.setFirstname(request.getParameter("firstname1"));
		pilot1.setSecondname(request.getParameter("secondname1"));
		pilot1.setPatronymic(request.getParameter("middlename1"));
		pilot1.setBirthday(sdf.parse(request.getParameter("date1")));

		Factory.getInstance().getPilotDao().addGenre(pilot1);

		pilot2.setFirstname(request.getParameter("firstname2"));
		pilot2.setSecondname(request.getParameter("secondname2"));
		pilot2.setPatronymic(request.getParameter("middlename2"));
		pilot2.setBirthday(sdf.parse(request.getParameter("date2")));
		Factory.getInstance().getPilotDao().addGenre(pilot2);

		Crew crew = new Crew();
		crew.setNumber(Integer.parseInt(request.getParameter("number")));
		crew.setPilot1(pilot1);
		crew.setPilot2(pilot2);

		Factory.getInstance().getCrewtDao().addGenre(crew);

		modelAndView.addObject("success", "Экипаж добавлен");
		modelAndView.addObject("crews", Factory.getInstance().getCrewtDao()
				.getAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/deleteCrew" }, method = RequestMethod.GET)
	public ModelAndView deleteCrew(HttpServletRequest req) throws 
	IOException, ServletException {
		ModelAndView modelAndView = new ModelAndView("viewCrew");
		try{
			if(req.getParameterValues("crewid")==null){
				modelAndView.addObject("error", "Выберите экипаж, который хотите удалить");			
			}
			else{
				Crew crew = new Crew();
				Pilot pilot1 = new Pilot();
				Pilot pilot2 = new Pilot();

				String[] checks = req.getParameterValues("crewid");
				for (int i = 0; i <= checks.length - 1; i++) {

					crew = Factory.getInstance().getCrewtDao()
							.getGenre(Integer.valueOf(checks[i]));
					pilot1 = crew.getPilot1();
					pilot2 = crew.getPilot2();
					Factory.getInstance().getPilotDao().deleteGenre(pilot1);
					Factory.getInstance().getPilotDao().deleteGenre(pilot2);
					Factory.getInstance().getCrewtDao().deleteGenre(crew);
				}
				modelAndView.addObject("success", "Данные удалены");
			}

			modelAndView.addObject("crews", Factory.getInstance().getCrewtDao()
					.getAll());
		}catch(SQLException e){
			modelAndView.addObject("error", "запись не может быть удалена");
		}
		return modelAndView;
	}

}
