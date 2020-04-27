package com.troyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
