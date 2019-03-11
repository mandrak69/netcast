package mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.City;

public interface CityRepository extends MongoRepository<City, String> {

	public City findByName(String Name);

	public City findByCod(String cod);
	public City findByCityId(long cityId);

}