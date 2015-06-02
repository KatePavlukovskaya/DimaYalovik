package by.bsuir.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.bsuir.entity.Days;
import by.bsuir.entity.Flight;
import by.bsuir.entity.FlightHasPlane;
import by.bsuir.service.Factory;

public class functions {
	
	public List<FlightHasPlane> getFlightByDate(String cityOtpr, String cityPrib, String tempDate)
			throws SQLException, ParseException {

		SimpleDateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateParse.parse(tempDate);
		
		List<FlightHasPlane> flightHasPlanes = Factory.getInstance()
				.getgenreDaoF_PDao().getAll();
		List<FlightHasPlane> result = new ArrayList<FlightHasPlane>();

		Flight flight = new Flight();

		for (FlightHasPlane flightHasPlane : flightHasPlanes) {
			flight = flightHasPlane.getFlightId();

			if (flight.getCityOtpr().getName().equals(cityOtpr)
					&& flight.getCityPrib().getName().equals(cityPrib) && (flight.getDateEnd().after(date) || flight.getDateEnd().equals(date)) && (flight.getDateBegin().before(date) || flight.getDateBegin().equals(date)))
				result.add(flightHasPlane);
		}
		return result;
	}
	
	public List<FlightHasPlane> getFlight(String cityOtpr, String cityPrib)
			throws SQLException, ParseException {

		
		List<FlightHasPlane> flightHasPlanes = Factory.getInstance()
				.getgenreDaoF_PDao().getAll();
		List<FlightHasPlane> result = new ArrayList<FlightHasPlane>();

		Flight flight = new Flight();

		for (FlightHasPlane flightHasPlane : flightHasPlanes) {
			flight = flightHasPlane.getFlightId();

			if (flight.getCityOtpr().getName().equals(cityOtpr)
					&& flight.getCityPrib().getName().equals(cityPrib))
				result.add(flightHasPlane);
		}
		return result;
	}
	
	public Days setDays(String[] str) {

		Days days = new Days();
		for (int i = 0; i < str.length; i++)
			switch (str[i]) {
			case "1":
				days.setMon(true);
				break;
			case "2":
				days.setTue(true);
				break;
			case "3":
				days.setWen(true);
				break;
			case "4":
				days.setThu(true);
				break;
			case "5":
				days.setFri(true);
				break;
			case "6":
				days.setSat(true);
				break;
			case "7":
				days.setSun(true);
				break;

			default:
				break;
			}
		return days;
	}
	
	public String getDateToday(){
		SimpleDateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");
		String s = dateParse.format(new Date());
	return s;
	}
	


}
