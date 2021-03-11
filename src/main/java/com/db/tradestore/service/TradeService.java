package com.db.tradestore.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.tradestore.model.TradeStore;
import com.db.tradestore.repository.TradeRepository;

@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	public List<TradeStore> getAllTradeData() {
		
		return tradeRepository.findAll();
		
	}

	public void saveOrUpdate(TradeStore trade) throws Exception {
		// TODO Auto-generated method stub	

		SimpleDateFormat  sdfo  = new SimpleDateFormat("yyyy-MM-dd"); 

		Date todaysDate = new Date();
		System.out.println("Todays Date:"+todaysDate);
		System.out.println("maturity Date:"+trade.getMaturityDate());
		
		String today= sdfo.format(todaysDate);  
		String maturityDate =  sdfo.format(trade.getMaturityDate()); 
		
	 	Date d1 = sdfo.parse(today); 
        Date d2 = sdfo.parse(maturityDate); 
		
        if (d1.compareTo(d2) > 0) { 
        	  
            System.out.println("Should not insert");
            throw new Exception("Maturity Date is less than todays Date");
        } 

		List<TradeStore> tradeStoreData = tradeRepository.findByTradeId(trade.getTradeId());
		
		if(tradeStoreData.size()!=0)
		{
			Iterator<TradeStore> iter = tradeStoreData.iterator();
			
			int maxVersion=0;
			while(iter.hasNext())
			{
				TradeStore t = iter.next();
				if(maxVersion<t.getVersion())
				{
					maxVersion=t.getVersion();
				}
			}
			
			System.out.println(maxVersion);
			
			if(maxVersion<trade.getVersion())
			{
				tradeRepository.save(trade);
			}
			else if(maxVersion>trade.getVersion())
			{
				throw new Exception("Lower version of trade");
			}
			else
			{
				TradeStore t = new TradeStore();
				Iterator<TradeStore> iter1 = tradeStoreData.iterator();
				while(iter1.hasNext())
				{
						t = iter1.next();
						System.out.println("trade version:"+t.getVersion());
					if(t.getVersion()==trade.getVersion())
					{
						t.setBookId(trade.getBookId());
						t.setCounterpartyId(trade.getCounterpartyId());
						t.setCreatedDate(trade.getCreatedDate());
						t.setMaturityDate(trade.getMaturityDate());
						
					}
				}
				System.out.println("Book id:"+t.getBookId());
				tradeRepository.save(t);
			}

		}
		else
		{
			tradeRepository.save(trade);
		}

	}
	
	
	
}
