package com.troyshoes.repository;


import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoesToCartItem;



public interface ShoesToCartItemRepository extends CrudRepository<ShoesToCartItem, Long>{


}
