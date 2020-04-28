package com.troyshoes.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoesToCartItem;


@Transactional
public interface ShoesToCartItemRepository extends CrudRepository<ShoesToCartItem, Long> {
	void deleteByCartItem(CartItem cartItem);
}

