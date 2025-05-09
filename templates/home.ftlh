<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
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
                <a href="/customers/new">Sign Up</a>
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
    <h2>Available Businesses</h2>

    <#if businesses?? && (businesses?size > 0)>
    <ul class="business-list">
        <#list businesses as business>
        <li class="business-card">
            <h3>${business.businessName}</h3>
            <p><strong>Category:</strong> ${business.category}</p>
            <p>${business.description}</p>
            <a href="/businesses/details/${business.businessId}">View Business Page</a>
        </li>
    </#list>
    </ul>
    <#else>
    <p>No businesses found.</p>
</#if>
</div>


</body>
</html>