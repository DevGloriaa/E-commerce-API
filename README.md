# 🛒 E-Commerce API  

A RESTful API for powering an e-commerce platform. It provides endpoints for managing users, products, orders, authentication, carts, and payments.  

---

## 🚀 Features  
- User authentication & authorization (JWT-based)  
- Product & category management (CRUD operations)  
- Shopping cart & checkout flow  
- Order tracking & history  
- Wishlist/favorites management  
- Secure payment integration (Stripe/PayPal/etc.)  
- Admin endpoints for managing inventory and users  

---

## 🛠️ Tech Stack  
- **Backend:** Spring framework
- **Database:** MongoDB 
- **Authentication:** JWT / OAuth2  
- **Payments:** Paystack


---

## 📦 Installation  

```bash
# Clone repository
git clone https://github.com/your-username/ecommerce-api.git

# Navigate into project
cd ecommerce-api

# Install dependencies
npm install   # or yarn install

# Create a .env file and add your environment variables (DB, JWT_SECRET, payment keys, etc.)

# Start development server
npm run dev
