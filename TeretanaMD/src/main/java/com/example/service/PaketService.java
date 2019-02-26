package com.example.service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
	import com.example.dao.PaketDAO;
	import com.example.domain.Paket;

	import java.net.URI;
	import java.util.Optional;



	@Service
	public class PaketService {
		
		@Autowired
		PaketDAO paketDAO;
		
		

		public Paket save(Paket paket) {
			
			paketDAO.save(paket);
			
		return paket;

		}
		
		public Paket findById(Long id) {
			Optional<Paket> oc = paketDAO.findById(id);
			Paket paket = oc.get();
			
		  return paket ;
		}
		
		public void delete(Long  id) {
			paketDAO.deleteById(id);

		}
		public ResponseEntity<Object> create(Paket paket) {
			Paket savedPaket = paketDAO.save(paket);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedPaket.getId()).toUri();

			return ResponseEntity.created(location).build();
			}
		
		
		
		
		public ResponseEntity<Object> update( Paket paket) {

		/*	Optional<Paket> cl = PaketDAO.findById(paket.getId());

			if (!cl.isPresent())
				return ResponseEntity.notFound().build();

			paket.setId(id);
		*/
			
			paketDAO.save(paket);

			return ResponseEntity.noContent().build();
		}
	}


