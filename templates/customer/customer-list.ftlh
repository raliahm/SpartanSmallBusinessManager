<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Profile</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<!--Navbar-->
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
                <a href="login.html">Log In</a>
                <a href="signup.html">Sign Up</a>
            </div>
        </li>
        <li><a href="shopping-cart.html">Shopping Cart</a></li>
    </ul>
    <form class="search-form" action="#" method="GET">
        <input type="text" placeholder="Search..." name="q">
        <button type="submit">Search</button>
    </form>
</nav>

<div class="card-container">
    <#list customerList as customer>
    <div class="card-body">
        <a><h5 class="card-title">${customer.name}</h5></a>
        <p class="card-text">
            <strong>ID:</strong> <a href="/lions/{customerId}">${customer.customerId}</a>
            <strong>Username:</strong><a href="/customers/username/${customer.username}">${customer.username}</a>
            <strong>Grade Level:</strong><a href="/customers/gradeLevel/${customer.gradeLevel}">${customer.gradeLevel}</a>
        </p>
    </div>
    </#list>
</div>

</body>
</html>