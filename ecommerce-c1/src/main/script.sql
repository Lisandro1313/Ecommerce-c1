-- Script de creación de tablas

-- Tabla de usuarios
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled BOOLEAN DEFAULT FALSE,
  confirmation_token VARCHAR(100),
  shipping_address VARCHAR(200),
  contact_info VARCHAR(200)
);

-- Tabla de carritos
CREATE TABLE carts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tabla de productos
CREATE TABLE products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

-- Tabla de órdenes
CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  product_id INT,
  order_date DATETIME,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Tabla de calificaciones y reseñas
CREATE TABLE ratings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  product_id INT,
  rating INT,
  review TEXT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Tabla de deseos
CREATE TABLE wishlists (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  product_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Script de creación de índices

-- Índice en la tabla de usuarios para el campo "email"
CREATE INDEX idx_users_email ON users(email);

-- Índice en la tabla de productos para el campo "name"
CREATE INDEX idx_products_name ON products(name);

-- Índice en la tabla de órdenes para el campo "user_id"
CREATE INDEX idx_orders_user_id ON orders(user_id);

-- Índice en la tabla de órdenes para el campo "product_id"
CREATE INDEX idx_orders_product_id ON orders(product_id);

-- Índice en la tabla de calificaciones y reseñas para el campo "user_id"
CREATE INDEX idx_ratings_user_id ON ratings(user_id);

-- Índice en la tabla de calificaciones y reseñas para el campo "product_id"
CREATE INDEX idx_ratings_product_id ON ratings(product_id);

-- Índice en la tabla de deseos para el campo "user_id"
CREATE INDEX idx_wishlists_user_id ON wishlists(user_id);

-- Índice en la tabla de deseos para el campo "product_id"
CREATE INDEX idx_wishlists_product_id ON wishlists(product_id);
