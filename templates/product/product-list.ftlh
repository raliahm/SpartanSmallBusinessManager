<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product</title>
    <link rel="stylesheet" href="/product.css">
</head>
<body>
<nav class="navbar">
    <div class="logo">Spartan Small Business Manager</div>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">&#9776;</label>
    <ul class="nav-links">
        <li><a href="home.html">Home</a></li>
        <li><a href="business_review.html">Featured Business</a></li>
        <li class="dropdown">
            <a href="#" class="drop-btn">Account</a>
            <div class="dropdown-content">
                <#if customer??>
                <a href="/customers/${customer.customerId}">My Profile</a>
                <a href="/customers/logout">Logout</a>
                <#else>
                <a href="/login">Login</a>
                <a href="/customers/createForm">Sign Up</a>
            </#if>
            </div>
        </li>
        <li><a href="shopping-cart.html">Shopping Cart</a></li>
    </ul>
    <form class="search-form" action="/businesses/search" method="GET">
        <input type="text" placeholder="Search..." name="q">
        <button type="submit">Search</button>
    </form>
</nav>

<div class="container">
    <h1>Products</h1>

    <#if products?? && products?size > 0>
    <div class="product-list">
        <#list products as product>
        <div class="product-card">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <p><strong>Price:</strong> $${product.price}</p>

            <form action="/cart/addProduct" method="post">
                <input type="hidden" name="customerId" value="${customer.customerId}">
                <input type="hidden" name="productId" value="${product.productId}">
                <label>Quantity:</label>
                <input type="number" name="quantity" value="1" min="1" required>
                <button type="submit">Add to Cart</button>
            </form>
        </div>
    </#list>
</div>
<#else>
<p>No products found for this business.</p>
</#if>

<a href="/customers/home">← Back to Businesses</a>
</div>

</body>
</html>