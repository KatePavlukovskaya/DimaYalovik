package by.bsuir.service;


import by.bsuir.entity.*;
import by.bsuir.dao.*;
 
public class Factory{
	public static Factory instance = new Factory();
	public GenreDao<City> genreDaoCity = null;
	public GenreDao<Flight> genreDaoFlight= null;
	public GenreDao<Pilot> genreDaoPilot = null;
	public static GenreDao<Plane> genreDaoPlane = null;
	public GenreDao<Crew>  genreDaoCrew = null;
	public GenreDao<FlightHasCrew> genreDaoF_C = null;
	public GenreDao<FlightHasPlane> genreDaoF_P = null;
	public GenreDao<Days> genreDaoDays = null;

	
	private Factory(){}
	
	public static Factory getInstance(){
		return Factory.instance;
	}
	
	public  GenreDao<Days> getDaysDao() {
		if (genreDaoDays == null)	genreDaoDays = new GenreDaoImpl<Days>(Days.class);
		return genreDaoDays;
	}
	
	public GenreDao<FlightHasCrew> getgenreDaoF_CDao(){
		if(genreDaoF_C == null ) genreDaoF_C =new GenreDaoImpl<FlightHasCrew>(FlightHasCrew.class) ;
		return genreDaoF_C;
	}
	
	public GenreDao<FlightHasPlane> getgenreDaoF_PDao(){
		if(genreDaoF_P == null ) genreDaoF_P =new GenreDaoImpl<FlightHasPlane>(FlightHasPlane.class) ;
		return genreDaoF_P;
	}
	
	public GenreDao<Crew> getCrewtDao(){
		if(genreDaoCrew == null ) genreDaoCrew =new GenreDaoImpl<Crew>(Crew.class) ;
		return genreDaoCrew;
	}
	
	public static GenreDao<Plane> getPlaneDao() {
		if ( genreDaoPlane == null)	genreDaoPlane = new GenreDaoImpl<Plane>(Plane.class);
		return genreDaoPlane;
	}
	
	public GenreDao<Flight> getFlightDao(){
		if(genreDaoFlight == null ) genreDaoFlight =new GenreDaoImpl<Flight>(Flight.class) ;
		return genreDaoFlight;
	}
	
	public GenreDao<City> getCityDao(){
		if(genreDaoCity == null ) genreDaoCity =new GenreDaoImpl<City>(City.class) ;
		return genreDaoCity;
	}
	
	public GenreDao<Pilot> getPilotDao(){
		if(genreDaoPilot== null ) genreDaoPilot =new GenreDaoImpl<Pilot>(Pilot.class) ;
		return genreDaoPilot;
	}
	
}