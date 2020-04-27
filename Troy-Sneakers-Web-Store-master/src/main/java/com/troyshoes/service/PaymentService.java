package com.troyshoes.service;

import com.troyshoes.domain.Payment;
import com.troyshoes.domain.UserPayment;

public interface PaymentService {
	
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
