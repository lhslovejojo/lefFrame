/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo.consumer;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lef.frame.api.PurchaseService;
import com.lef.frame.api.request.PurchaseRequest;
import com.lef.frame.api.result.PaymentResult;

@Component
public class TestMain {

	@Reference(version="1.0.0")
	private PurchaseService purchaseService;
	@PostConstruct
	public void start() throws Exception {
		PurchaseRequest request=new PurchaseRequest("001");
		request.setRequestTime(new Date());
		request.setRequestNo(System.currentTimeMillis()+"");
		request.setCustomerId("0001");
		request.setOrderAmount(new BigDecimal(10));
		request.setSyn(false);
		PaymentResult result=purchaseService.purchase(request);
		System.out.print(result.getCode());
     System.out.println("你哈");
	}

}