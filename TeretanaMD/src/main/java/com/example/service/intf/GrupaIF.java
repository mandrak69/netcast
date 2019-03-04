package com.example.service.intf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.domain.Grupa;
import com.example.dto.GrupaDTO;

public interface GrupaIF {

	List<Grupa> findAll();

	GrupaDTO save(GrupaDTO grupadto);

	Grupa findById(Long id);

	void delete(Long id);

	GrupaDTO update(Long id, GrupaDTO grupadto);

	Page<Grupa> findAll(Pageable pageable);

}
