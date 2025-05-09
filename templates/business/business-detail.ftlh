<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${business.businessName} - Details</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<nav class="navbar">
    <div class="logo">Spartan Small Business Manager</div>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">&#9776;</label>
    <ul class="nav-links">
        <li><a href="/customers/home">Home</a></li>
        <li><a href="/businesses/details/${business.businessId}">Featured Business</a></li>
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
</nav>
<#if message??>
<div class="alert alert-success">${message}</div>
</#if>
<#if error??>
<div class="alert alert-danger">${error}</div>
</#if>
<div class="container">
    <div class="card">
        <h2>${business.businessName}</h2>
        <p><strong>Category: </strong> ${business.category}</p>
        <p><strong>Description: </strong> ${business.description}</p>
    </div>

    <h3>Products</h3>
    <#if products?? && (products?size > 0)>
    <div class="product-list">
        <#list products as product>
        <div class="card">
            <h4>${product.name}</h4>
            <p>${product.description}</p>
            <p><strong>Price: </strong>${product.price}</p>

            <#if customer??>
            <form action="/cart/addProduct" method="post">
                <input type="hidden" name="customerId" value="${customer.customerId}">
                <input type="hidden" name="productId" value="${product.productId}">
                <label>Quantity:</label>
                <input type="number" name="quantity" value="1" min="1">
                <button type="submit">Add to Cart</button>
            </form>
            <#else>
            <p><a href="/login">Login to add to cart.</a></p>
            </#if>
        </div>
    </#list>
    </div>
<#else>
<p>This business has no products listed yet.</p>
</#if>

<h3>Reviews</h3>
<#if reviews?? && (reviews?size > 0)>
<ul>
    <#list reviews as review>
    <li>
        <p><strong>${review.customer.username}: </strong>${review.reviewText}</p>
    </li>
    </#list>
</ul>
<#elseif reviews??>
<p>No reviews yet.</p>
</#if>

<!-- Leave a Review -->
<h3>Leave a Review</h3>
<#if customer??>
<form action="/reviews/new" method="post">

    <input type="hidden" name="customerId" value="${customer.customerId}">
    <input type="hidden" name="businessId" value="${business.businessId}">

    <label for="reviewText">Your Review:</label><br>
    <textarea name="comment" id="reviewText" rows="4" cols="50" required></textarea><br>

    <button type="submit">Submit Review</button>
</form>
<#else>
<p><a href="/login">Login to leave a review</a></p>
</#if>
</div>

</body>
</html>