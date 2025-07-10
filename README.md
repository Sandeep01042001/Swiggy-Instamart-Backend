# 🛒 Swiggy InstaMart – Backend Database Design

This project simulates a hyperlocal grocery delivery platform, with a focus on scalable and modular backend database design. The system supports role-based features for shoppers, warehouse admins, delivery partners, and app administrators.

---

## 📑 Entity Schema Overview

### 🧍 1. User Table
**Purpose**:
Stores all user accounts including shoppers, warehouse admins, delivery partners, and app admins.

**Key Fields**:
- `id`: Primary key
- `name`, `email`, `phone`: User contact details
- `password`: Encrypted password
- `role`: Enum → (`SHOPPER`, `WAREHOUSE_ADMIN`, `DELIVERY_PARTNER`, `APP_ADMIN`)
- `location`: FK → `Location`

---

### 📍 2. Location Table
**Purpose**:
Centralized address table used by users, warehouses, and orders.

**Key Fields**:
- `id`: Primary key
- `addressLine`, `area`, `city`, `state`, `pincode`
- `latitude`, `longitude`: For geolocation and tracking

---

### 🏬 3. Warehouse Table
**Purpose**:
Holds warehouse details for order fulfillment.

**Key Fields**:
- `id`: Primary key
- `name`, `address`
- `location`: FK → `Location`
- `manager`: FK → `User` (role = `WAREHOUSE_ADMIN`)
- `products`: List of available products
- `deliveryPartners`: List of assigned delivery partners

---

### 📦 4. Product Table
**Purpose**:
Master data for all grocery items available on the platform.

**Key Fields**:
- `id`, `name`, `brand`, `description`, `category`, `imageUrl`

🔗 Linked with `WarehouseProduct` for stock and price per warehouse.

---

### 🏪 5. WarehouseProduct Table
**Purpose**:
Maintains inventory and pricing per product per warehouse.

**Key Fields**:
- `id`
- `warehouse`: FK → `Warehouse`
- `product`: FK → `Product`
- `quantity`, `price`

---

### 🛒 6. Cart Table
**Purpose**:
Stores each shopper’s active cart.

**Key Fields**:
- `id`, `user`: FK → `User` (role = `SHOPPER`)
- `cartItems`: List of products
- `createdAt`, `updatedAt`

---

### 🧺 7. CartItem Table
**Purpose**:
Tracks individual product entries in a shopper's cart.

**Key Fields**:
- `id`
- `cart`: FK → `Cart`
- `product`: FK → `Product`
- `quantity`

---

### 📦 8. Order Table
**Purpose**:
Final orders placed by users.

**Key Fields**:
- `id`, `user`: FK → `User`
- `warehouse`: FK → `Warehouse`
- `deliveryLocation`: FK → `Location`
- `orderItems`: List of products
- `totalAmount`, `paymentMethod` (e.g., `COD`, `UPI`)
- `status`: Enum → See [OrderStatus](#-orderstatus-enum)
- `createdAt`

---

### 🧾 9. OrderItem Table
**Purpose**:
Details individual product entries in an order.

**Key Fields**:
- `id`
- `order`: FK → `Order`
- `product`: FK → `Product`
- `quantity`, `price`

---

### 🚴 10. DeliveryPartner Table
**Purpose**:
Extra information for delivery agents.

**Key Fields**:
- `id`: Same as `User.id`
- `user`: FK → `User`
- `warehouse`: FK → `Warehouse`
- `isAvailable`: Boolean flag

---

### 🚚 11. Delivery Table *(Optional - For Future Use)*
**Purpose**:
Tracks the delivery lifecycle of an order.

**Key Fields**:
- `id`
- `order`: FK → `Order`
- `deliveryPartner`: FK → `DeliveryPartner`
- `status`: Enum → (`ASSIGNED`, `IN_PROGRESS`, `DELIVERED`)
- `updatedAt`

---

### 📦 12. ProductRequest Table
**Purpose**:
Allows warehouse admins to raise stock requests.

**Key Fields**:
- `id`
- `warehouse`: FK → `Warehouse`
- `productName`, `brand`, `quantityRequested`
- `status`: Enum → (`PENDING`, `APPROVED`, `REJECTED`)
- `approvedBy`: FK → `User` (role = `APP_ADMIN`)

---

## 🔁 OrderStatus Enum

```java
public enum OrderStatus {
    PLACED,
    CONFIRMED,
    PACKED,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED,
    FAILED
}
