INSERT INTO products (name, category, price_cents) VALUES ('Shampoo', 'cleaning', 1099) ON CONFLICT DO NOTHING;
INSERT INTO products (name, category, price_cents) VALUES ('Conditioner', 'cleaning',1299) ON CONFLICT DO NOTHING;
INSERT INTO products (name, category, price_cents) VALUES ('Hair Gel','cleaning' ,899) ON CONFLICT DO NOTHING;
INSERT INTO products (name, category, price_cents) VALUES ('Hair Spray', 'cleaning',999) ON CONFLICT DO NOTHING;