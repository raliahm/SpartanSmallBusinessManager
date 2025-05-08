<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Profile</title>
    <link rel="stylesheet" href="/profile.css">
</head>
<body>
<nav class="navbar">
    <div class="logo">Spartan Small Business Manager</div>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">&#9776;</label>
    <ul class="nav-links">
        <li><a href="/customers/home">Home</a></li>
        <li><a href="/businesses/details/2">Featured Business</a></li>
        <li class="dropdown">
            <a href="#" class="drop-btn">Account</a>
            <div class="dropdown-content">
                <a href="/customers/${customer.customerId}">My Profile</a>
            </div>
        </li>
        <li><a href="/cart/view/${customer.customerId}">My Cart</a></li>
    </ul>
</nav>
<div class="container">
    <h3>Account Information</h3>
    <div class="row">
        <div class="card">
            <#if customer??>
            <div class="text-center">
                <img src="/vecteezy_profile-icon-design-vector_5544718.jpg"
                     height="1920" width="1920"/>
                <h4><strong>${customer.username}</strong></h4>
            </div>
        </div>
        <div class="card">
            <h5 class="card-title">Name: ${customer.name}</h5>
            <p class="card-text">Username: ${customer.username}</p>
            <p class="card-text">Email: ${customer.email}</p>
            <p class="card-text">Grade Level: ${customer.gradeLevel}</p>
            <div style="display: flex;">
                <a href="/customers/update/${customer.customerId}" class="btn btn-primary">Edit Profile</a>
            </div>
        </div>
        <#else>
        <p class="error">Error: customer not found.</p>
    </#if>
    </div>
</div>




</body>
</html>