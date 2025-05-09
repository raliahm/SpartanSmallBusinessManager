<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-wrapper">
        <div class="logo">Spartan Small Business Manager</div>

        <input type="checkbox" id="menu-toggle">
        <label for="menu-toggle" class="menu-icon">&#9776;</label>

        <ul class="nav-links">
            <li><a href="/customers/home">Home</a></li>
            <#if businesses?? && (businesses?size > 0)>
            <#assign featured = businesses[0]>
            <li><a href="/businesses/details/${featured.businessId}">Featured Business</a></li>
            <#else>
            <li><a href="/businesses/details/2">Featured Business</a></li>
        </#if>

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

    <#if customer??>
    <li><a href="/cart/view/${customer.customerId}">My Cart</a></li>
    <#else>
    <li><a href="/login">Login to view Cart</a></li>
</#if>
</ul>

<form class="search-form" action="/businesses/search" method="GET">
    <input type="text" placeholder="Search..." name="q">
    <button type="submit">Search</button>
</form>
</div>
</nav>

<div class="container">
    <h1>My Shopping Cart</h1>

    <#if cart?? && (cart.items?size > 0)>
    <table>
        <thead>
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Unit Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list cart.items as item>
        <tr>
            <td>${item.product.name}</td>
            <td>${item.product.description}</td>
            <td>$${item.product.price?string("0.00")}</td>
            <td>${item.quantity}</td>
            <td>$${(item.product.price * item.quantity)?string("0.00")}</td>
            <td>
                <form action="/cart/addProduct" method="post" style="display:inline;">
                    <input type="hidden" name="customerId" value="${customer.customerId}">
                    <input type="hidden" name="productId" value="${item.product.productId}">
                    <input type="number" name="quantity" min="1" value="${item.quantity}">
                    <button type="submit">Update</button>
                </form>
                <form action="/cart/removeProduct" method="post" style="display:inline;">
                    <input type="hidden" name="customerId" value="${customer.customerId}">
                    <input type="hidden" name="productId" value="${item.product.productId}">
                    <button type="submit" style="background:red; color:white;">Remove</button>
                </form>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

    <div class="cart-summary">
        <h3>Total Items: ${cart.quantity}</h3>
        <h3>Total Price: $${cart.total?string("0.00")}</h3>
    </div>
    <#else>
    <p>Your cart is currently empty.</p>
</#if>

<br>
<a href="/customers/home">← Back to Home</a>
</div>


</body>
</html>