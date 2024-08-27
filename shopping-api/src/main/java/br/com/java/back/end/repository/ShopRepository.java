package br.com.java.back.end.repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.back.end.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
	
    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);
        
    List<Shop> findAllByDateGreaterThan(LocalDateTime date);
		
}

