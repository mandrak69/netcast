package com.example.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.example.domain.Trener;


@Repository

public interface TrenerDAO extends JpaRepository<Trener, Long> {

/*	 @Query("SELECT COUNT(u) FROM Trener u WHERE u.name=:name")
	    Long aMethodNameOrSomething(@Param("name") String name);

	*/

	
    
}
