package by.bsuir.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.entity.City;
import by.bsuir.entity.Crew;
import by.bsuir.entity.Days;
import by.bsuir.entity.Flight;
import by.bsuir.entity.FlightHasCrew;
import by.bsuir.entity.FlightHasPlane;
import by.bsuir.entity.Plane;
import by.bsuir.service.Factory;


@Controller
public class dispatcherController extends functions{

	@RequestMapping(value = "/addData", method = RequestMethod.GET)
	public ModelAndView addFlight(HttpServletRequest request)
			throws SQLException, IOException, ServletException, ParseException {

		ModelAndView model = new ModelAndView(" dispatcherPage");
		SimpleDateFormat timeParse = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateParse.parse(request.getParameter("date1"));
		Date date2 = dateParse.parse(request.getParameter("date2"));

		if( date1.after(date2)){
			model.addObject("error", "Период полётов неректный!");
			model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
			return model;			
		}

		Date time1 = timeParse.parse(request.getParameter("time1"));
		Date time2 = timeParse.parse(request.getParameter("time2"));

		if( time1.after(time2)){
			model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
			model.addObject("error", "Время выбрано неправильно!");
			return model;			
		}

		if( request.getParameter("cityOtpr").equals(request.getParameter("cityPrib"))){
			model.addObject("error", "Совпадение городов");
			model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
			return model;	
		}

		Flight flight = new Flight();
		City cityOtpr = new City();
		City cityPrib = new City();
		Crew crew = new Crew();
		Plane plane = new Plane();
		Days days = new Days();



		flight.setTimeSortie(time1);
		flight.setTimeArrivals(time2);
		cityOtpr = Factory.getInstance().getCityDao()
				.getGenre(Integer.parseInt(request.getParameter("cityOtpr")));
		cityPrib = Factory.getInstance().getCityDao()
				.getGenre(Integer.parseInt(request.getParameter("cityPrib")));
		flight.setCityOtpr(cityOtpr);
		flight.setCityPrib(cityPrib);
		flight.setName(request.getParameter("name"));
		String str = new String("");
		String[] checks = request.getParameterValues("Checkbox");
		days = setDays(checks);
		Factory.getInstance().getDaysDao().addGenre(days);
		flight.setDays(days);

		flight.setDateBegin(date1);
		flight.setDateEnd(date2);
		Factory.getInstance().getFlightDao().addGenre(flight);
		crew = Factory.getInstance().getCrewtDao()
				.getGenre(Integer.parseInt(request.getParameter("crew")));
		plane = Factory.getInstance().getPlaneDao()
				.getGenre(Integer.parseInt(request.getParameter("plane")));
		FlightHasCrew flightHasCrew = new FlightHasCrew();
		flightHasCrew.setCrewId(crew);
		flightHasCrew.setFlightId(flight);
		Factory.getInstance().getgenreDaoF_CDao().addGenre(flightHasCrew);

		FlightHasPlane flightHasPlane = new FlightHasPlane();
		flightHasPlane.setPlaneId(plane);
		flightHasPlane.setFlightId(flight);
		Factory.getInstance().getgenreDaoF_PDao().addGenre(flightHasPlane);
		model.addObject("success", "Рейс Добавлен!");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		return model;
	}

	@RequestMapping(value = "/addFlight", method = RequestMethod.GET)
	public ModelAndView forwardAddFlight(HttpServletRequest request)
			throws SQLException {
		ModelAndView model = new ModelAndView("addFlight");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		model.addObject("allPlane", Factory.getInstance().getPlaneDao()
				.getAll());
		model.addObject("allCrew", Factory.getInstance().getCrewtDao().getAll());
		return model;
	}

	@RequestMapping(value = "/viewFlight", method = RequestMethod.GET)
	public ModelAndView forwarViewFlight(HttpServletRequest request)
			throws SQLException {
		ModelAndView model = new ModelAndView("viewFlight");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		return model;
	}

	@RequestMapping(value = "/view_Flights", method = RequestMethod.GET)
	public ModelAndView ViewFlights(HttpServletRequest request)
			throws SQLException, NumberFormatException, ParseException {
		ModelAndView model = new ModelAndView(" dispatcherPage");

		List<FlightHasPlane> list = getFlight(
				Factory.getInstance()
				.getCityDao()
				.getGenre(
						Integer.parseInt(request
								.getParameter("cityOtpr")))
								.getName(),
								Factory.getInstance()
								.getCityDao()
								.getGenre(
										Integer.parseInt(request
												.getParameter("cityPrib")))
												.getName());
		if (!list.isEmpty()){
			model.addObject("allFlight", list);
			model.addObject("success", " ");
			model.addObject("cityOtpr", Factory.getInstance().getCityDao()
					.getGenre(Integer.parseInt(request.getParameter("cityOtpr")))
					.getName());
			model.addObject("cityPrib", Factory.getInstance().getCityDao()
					.getGenre(Integer.parseInt(request.getParameter("cityPrib")))
					.getName());

		}
		else {
			model.addObject("error_city", "Данного маршрута не существует!");
		}
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		return model;
	}

	@RequestMapping(value = { "/deleteFlight" }, method = RequestMethod.GET)
	public ModelAndView deleteFlight(HttpServletRequest req) throws SQLException,
	IOException, ServletException, NumberFormatException, ParseException {

		ModelAndView modelAndView = new ModelAndView(" dispatcherPage");
		if(req.getParameterValues("idflight")==null){
			modelAndView.addObject("errorDelete", "Рейс не был выбран, попробуйте ещё раз");	
		}
		else{
			Flight flight = new Flight();
			FlightHasPlane flightHasPlane = new FlightHasPlane();
			Days day = new Days();  
			List<FlightHasCrew> flightHasCrews = new ArrayList<FlightHasCrew>();

			flightHasCrews =Factory.getInstance().getgenreDaoF_CDao().getAll();
			String[] checks = req.getParameterValues("idflight");

			for (int i = 0; i <= checks.length-1; i++) {

				flightHasPlane = Factory.getInstance().getgenreDaoF_PDao()
						.getGenre(Integer.valueOf(checks[i]));	

				flight = Factory.getInstance().getFlightDao().getGenre(flightHasPlane.getFlightId().getIdflight());

				for(FlightHasCrew flightHasCrew : flightHasCrews){		
					if (flightHasCrew.getFlightId().getIdflight().equals(flight.getIdflight())){			
						Factory.getInstance().getgenreDaoF_CDao().deleteGenre(flightHasCrew);}
				}			
				day = flight.getDays();
				Factory.getInstance().getDaysDao().deleteGenre(day);
				Factory.getInstance().getgenreDaoF_PDao().deleteGenre(flightHasPlane);
				Factory.getInstance().getFlightDao().deleteGenre(flight);
			}		

			modelAndView.addObject("successDelete","Запись удалена");
		}
		modelAndView.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		return modelAndView;
	}


}
