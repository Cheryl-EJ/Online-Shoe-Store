package com.troyshoes.service;

import com.troyshoes.domain.BillingAddress;
import com.troyshoes.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
