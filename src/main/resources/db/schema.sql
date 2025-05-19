DROP TABLE IF EXISTS PRICE;

CREATE TABLE PRICE (
    id IDENTITY PRIMARY KEY,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    price DECIMAL(10, 2),
    curr VARCHAR(3)
);

CREATE INDEX idx_price_effective
ON PRICE(product_id, brand_id, priority DESC, start_date, end_date);