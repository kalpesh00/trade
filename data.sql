DROP TABLE IF EXISTS trade_store;

CREATE TABLE trade_store (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  trade_id VARCHAR(250) NOT NULL,
  version INT NOT NULL,
  counterparty_id VARCHAR(250) DEFAULT NULL,
  book_id VARCHAR(250) DEFAULT NULL,
  maturity_date DATE,
  created_date DATE,
  expired VARCHAR(10)
);
