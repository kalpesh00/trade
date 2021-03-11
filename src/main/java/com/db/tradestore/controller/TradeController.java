package com.db.tradestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.tradestore.model.TradeStore;
import com.db.tradestore.repository.TradeRepository;
import com.db.tradestore.service.TradeService;

@RestController
public class TradeController {


	@Autowired
	TradeService tradeService;
	
	@GetMapping("/tradeDetails")
	public List<TradeStore> retrieveAllTradeData() {
			
		return tradeService.getAllTradeData();
	}
	
	@PostMapping("/trade")
	private String saveBook(@RequestBody TradeStore trade) throws Exception   
	{  
		
		tradeService.saveOrUpdate(trade);
		
		return trade.getTradeId();
	}  
	
	
}
