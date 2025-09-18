-- ============================
-- Categories
-- ============================
INSERT INTO categories (id, name, created_at, updated_at)
VALUES (1, 'Electronics', NOW(), NOW());

INSERT INTO categories (id, name, created_at, updated_at)
VALUES (2, 'Furniture', NOW(), NOW());

INSERT INTO categories (id, name, created_at, updated_at)
VALUES (3, 'Clothing', NOW(), NOW());

-- ============================
-- Suppliers
-- ============================
INSERT INTO suppliers (id, name, email, phone, created_at, updated_at)
VALUES (1, 'TechWorld', 'contact@techworld.com', '123456789', NOW(), NOW());

INSERT INTO suppliers (id, name, email, phone, created_at, updated_at)
VALUES (2, 'HomeMakers', 'info@homemakers.com', '987654321', NOW(), NOW());

INSERT INTO suppliers (id, name, email, phone, created_at, updated_at)
VALUES (3, 'FashionHub', 'support@fashionhub.com', '555666777', NOW(), NOW());

-- ============================
-- Products
-- ============================
INSERT INTO products (id, name, price, description, category_id, supplier_id, sku, created_at, updated_at)
VALUES (1, 'Laptop', 1200.00, 'High-end gaming laptop', 1, 1, 'SKU-LAPTOP-001', NOW(), NOW());

INSERT INTO products (id, name, price, description, category_id, supplier_id, sku, created_at, updated_at)
VALUES (2, 'Office Chair', 150.00, 'Ergonomic office chair', 2, 2, 'SKU-CHAIR-001', NOW(), NOW());

INSERT INTO products (id, name, price, description, category_id, supplier_id, sku, created_at, updated_at)
VALUES (3, 'T-Shirt', 25.00, 'Cotton t-shirt', 3, 3, 'SKU-TSHIRT-001', NOW(), NOW());
