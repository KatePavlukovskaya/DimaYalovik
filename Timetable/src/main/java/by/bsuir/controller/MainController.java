package by.bsuir.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import by.bsuir.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.FkSecondPass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.service.Factory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController extends functions {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainpage(Locale locale) throws SQLException {
		ModelAndView model = new ModelAndView("index");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());		
		model.addObject("date", getDateToday());
		return model;
	}


	@RequestMapping(value = "/dispatcher", method = RequestMethod.GET)
	public ModelAndView forwardDispatcher(HttpServletRequest request) throws SQLException {
		ModelAndView model = new ModelAndView(" dispatcherPage");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		return model;

	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("adminPage");

		if (request.getParameter("login").equals("admin")
				&& request.getParameter("password").equals("admin")) {
				HttpSession session = request.getSession() ; 
				session.setAttribute("authorized", "admin");
				model.addObject("success", "Успешная авторизация, admin");
		}else {
			model.addObject("error", "Неверный логин или пароль");
		}

		return model;

	}
	
	@RequestMapping(value = "/loginDispatcher", method = RequestMethod.GET)
	public ModelAndView loginDispatcher(HttpServletRequest request) throws SQLException {
		
		ModelAndView model = new ModelAndView(" dispatcherPage");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		if (request.getParameter("login").equals("dispatcher")
				&& request.getParameter("password").equals("dispatcher")) {
				HttpSession session = request.getSession() ; 
				session.setAttribute("authorized", "dispatcher");
				model.addObject("success", "Успешная авторизация, dispatcher");
		}else {
			model.addObject("error", "Неверный логин или пароль");
		}

		return model;

	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws SQLException {
		ModelAndView model = new ModelAndView("index");
		model.addObject("allCity", Factory.getInstance().getCityDao().getAll());
		HttpSession session = request.getSession() ; 
		session.setAttribute("authorized", "false");
		return model;
	}	



}
