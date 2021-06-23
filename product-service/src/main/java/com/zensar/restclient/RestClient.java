package com.zensar.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;

@FeignClient("COUPON-SERVICE")
public interface RestClient {

	@GetMapping("/api/v1/coupons/{couponCode}")
	Coupon getCoupon(@PathVariable("couponCode")String couponCode);
}
