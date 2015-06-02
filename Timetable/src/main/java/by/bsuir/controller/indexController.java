package by.bsuir.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.entity.FlightHasPlane;
import by.bsuir.service.Factory;


@Controller
public class indexController extends functions {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView mainPage(Locale locale) throws SQLException {

		ModelAndView model = new ModelAndView("index");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		model.addObject("date", getDateToday());
		return model;
	}	
	
	@RequestMapping(value = "/view_Flights_index", method = RequestMethod.GET)
	public ModelAndView ViewFlightsIndex(HttpServletRequest request)
			throws  NumberFormatException, ParseException {
		ModelAndView model = new ModelAndView("index");
		try{		
		if(request.getParameter("date").equals(""))	{
			model.addObject("error", "введите дату вылета");
		}
		else{
		
		model.addObject("cityOtpr", Factory.getInstance().getCityDao()
				.getGenre(Integer.parseInt(request.getParameter("cityOtpr")))
				.getName());
		model.addObject("cityPrib", Factory.getInstance().getCityDao()
				.getGenre(Integer.parseInt(request.getParameter("cityPrib")))
				.getName());
		model.addObject("success", " ");
		List<FlightHasPlane> list = getFlightByDate(
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
				.getName(), request.getParameter("date"));
	
		if(!list.isEmpty()){
			model.addObject("allFlight",list);
		}
		else {			
			model.addObject("error", "Рейсов на данный день нет. Мы можем предложить рейсы в другие дни");
			list = getFlight(
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
									.getParameter("cityPrib"))).getName());
			if(!list.isEmpty())
			model.addObject("allFlight",list);
			else model.addObject("error", "Данного маршрута не существует");
		}
		}
		}catch (SQLException e){
			
		}
		finally{
			try {
				model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
				model.addObject("date", getDateToday());
			} catch (SQLException e) {
				model.addObject("error","ошибка базы данных");
				
			}
		}
		return model;
	}


}
