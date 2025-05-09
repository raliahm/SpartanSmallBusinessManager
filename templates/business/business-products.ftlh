<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/styles.css">
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



</body>
</html>