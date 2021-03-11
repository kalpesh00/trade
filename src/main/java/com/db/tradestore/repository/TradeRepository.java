package com.db.tradestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.tradestore.model.TradeStore;

public interface TradeRepository extends JpaRepository<TradeStore, Integer>{
	
	List<TradeStore> findByTradeId(String tradeId);
	
}
