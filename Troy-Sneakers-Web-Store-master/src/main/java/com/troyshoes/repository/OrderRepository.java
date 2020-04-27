package com.troyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}