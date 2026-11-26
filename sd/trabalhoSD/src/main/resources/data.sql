INSERT INTO products (name, category, price_cents) 
SELECT * FROM (VALUES 
    ('Shampoo', 'cleaning', 1099),
    ('Conditioner', 'cleaning',1299), 
    ('Hair Gel','cleaning' ,899), 
    ('Hair Spray', 'cleaning',999)
) AS v(name, category, price_cents)
WHERE NOT EXISTS (SELECT 1 FROM products);