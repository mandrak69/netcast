package com.example.wheather.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wheather.dao.CityDao;
import com.example.wheather.dao.UserDao;
import com.example.wheather.entity.City;
import com.example.wheather.entity.Subscription;
import com.example.wheather.entity.User;
import com.example.wheather.entity.UserAndCitiesByType;
import com.example.wheather.entity.dto.EmailForecast;
import com.example.wheather.entity.dto.UserDto;
import com.example.wheather.inter.UserIF;
import com.example.wheather.scheduler.MailService;
import com.google.common.collect.Lists;

@Service
public class UserService implements UserIF {
	@Autowired
	UserDao userDao;
	@Autowired
	CityDao cityDao;

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserService(UserDao userDao, CityDao cityDao) {

		this.userDao = userDao;
		this.cityDao = cityDao;
	}

	@Override
	public User register(UserDto userdto) {
		User user = new User();
		user.setFirstname(userdto.getFirstname());
		user.setSurname(userdto.getSurname());
		user.seteMail(userdto.geteMail());
		user.setPassword(userdto.getPassword());
		return userDao.save(user);
	}

	@Override
	public Subscription subscribe(Subscription subscription, String email) {
		User user = userDao.findByEMail(email);
		try {
			List<Subscription> subscriptions = user.getSubsciptions();
			subscriptions.add(subscription);
			user.setSubsciptions(subscriptions);
			userDao.save(user);
			return subscription;
		} catch (NullPointerException npe) {

			List<Subscription> subscriptions = new ArrayList<Subscription>();
			subscriptions.add(subscription);
			user.setSubsciptions(subscriptions);
			userDao.save(user);
			return subscription;

		}

	}

	@Override
	public List<UserAndCitiesByType> getTimeLists(int time) {
		List<UserAndCitiesByType> lista = new ArrayList<>();
		List<User> users = userDao.findAll();
		for (User u : users) {
			UserAndCitiesByType us = new UserAndCitiesByType();
			us.setFirstname(u.getFirstname());
			us.seteMail(u.geteMail());
			List<String> cities = new ArrayList<>();
			try {

				List<Subscription> listasub = u.getSubsciptions();
				if (listasub != null) {
					for (Subscription su : listasub) {
						if (su.getSubscriptionType() == time) {
							cities.add(su.getCity());
						}
					}
				}
			} catch (NullPointerException npe) {

			}

			us.setCities(cities);
			lista.add(us);
		}
		return lista;
	}

	@Override
	public List<EmailForecast> getBody(List<String> cities) {

		List<EmailForecast> lista = new ArrayList<>();
		for (String cit : cities) {
			EmailForecast ema = new EmailForecast();
			City city = cityDao.findByName(cit);
			ema.setCity(cit);
			try {
				// ema.setCurentTemperature((city.getMain().getTemp()-272));
				// ema.setMinTemperature(city.getMain().getTemp_min()-272);
				// ema.setMaxTemperature(city.getMain().getTemp_max()-272);
				lista.add(ema);
			} catch (NullPointerException npe) {

			}
		}
		return lista;
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteById(id);

	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);

	}

	@Override
	public Subscription updateSub(Subscription subscription, String email) {
		User user = userDao.findByEMail(email);
		List<Subscription> lista = user.getSubsciptions();
		String city = subscription.getCity();
		for (Subscription su : lista) {
			if (su.getCity().equals(city)) {
				su.setSubscriptionType(subscription.getSubscriptionType());
				;

			}
		}
		user.setSubsciptions(lista);
		userDao.save(user);
		return subscription;
	}

	@Override
	public List<Subscription> listSubs(String email) {
		User user = userDao.findByEMail(email);
		List<Subscription> lista = user.getSubsciptions();
		return lista;
	}

	@Override
	public void deleteSub(Subscription sub, String email) {

		User user = userDao.findByEMail(email);
		List<Subscription> lista = user.getSubsciptions();
		List<Subscription> lista2 = new ArrayList<>();
		for (Subscription s : lista) {
			if (!s.getCity().equals(sub.getCity()))
				lista2.add(s);

		}
		user.setSubsciptions(lista2);
		userDao.save(user);
	}

	@Override
	public void sendbySub(int time, MailService mailService) {

		List<UserAndCitiesByType> lista = getTimeLists(time);
		for (UserAndCitiesByType us : lista) {
			String recipient = us.geteMail();
			List<String> cities = us.getCities();
			List<EmailForecast> body = getBody(cities);
			mailService.sendEmail(recipient, body.toString());

		}

	}
}
