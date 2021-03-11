package com.db.tradestore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trade_store")
public class TradeStore {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	
		//@Column(name="trade_id")
	 	private String tradeId;
	 	
	 	private int version;
	 	//@Column(name="counterparty_id")
	 	private String counterpartyId;
	 	
	 	private String bookId;
	 	
	 	//@Column(name="maturity_date")
	 	private Date maturityDate;
	 	
	 	//@Column(name="created_date")
	 	private Date createdDate;
	 	
	 	//@Column(name="trade_id")
	 	private String expired;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTradeId() {
			return tradeId;
		}

		public void setTradeId(String tradeId) {
			this.tradeId = tradeId;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}



		public String getCounterpartyId() {
			return counterpartyId;
		}

		public void setCounterpartyId(String counterpartyId) {
			this.counterpartyId = counterpartyId;
		}

		public Date getMaturityDate() {
			return maturityDate;
		}

		public void setMaturityDate(Date maturityDate) {
			this.maturityDate = maturityDate;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getExpired() {
			return expired;
		}

		public void setExpired(String expired) {
			this.expired = expired;
		}

		
		
		
		public String getBookId() {
			return bookId;
		}

		public void setBookId(String bookId) {
			this.bookId = bookId;
		}

		@Override
		public String toString() {
			return "TradeStore [id=" + id + ", tradeId=" + tradeId + ", version=" + version + ", counterpartyId="
					+ counterpartyId + ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate="
					+ createdDate + ", expired=" + expired + "]";
		}


	 	
}
