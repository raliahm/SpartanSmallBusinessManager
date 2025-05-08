<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Customer Profile</title>
    <link rel="stylesheet" href="/profile.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

</head>
<body>
<!--Navbar-->
<#-- shared-navbar.ftlh -->
<nav class="navbar">
    <div class="logo">Spartan Small Business Manager</div>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">&#9776;</label>
    <ul class="nav-links">
        <li><a href="/customers/home">Home</a></li>
        <li><a href="/business_review.html">Featured Business</a></li>
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
        <li><a href="/shopping-cart.html">My Cart</a></li>
    </ul>
</nav>
<div class="container">
    <h3>Account Information</h3>
    <div class="row">
        <div class="card">
            <div class="text-center">
                <img src="/vecteezy_profile-icon-design-vector_5544718.jpg" alt="Profile Picture">
                <h4><strong>${customer.username}</strong></h4>
            </div>
        </div>
        <div class="card">
            <form id="new-customer" action="/customers/update/${customer.customerId}" method="post">
                <input type="text" id="name" name="name" value="${customer.name}" placeholder="Name">
                <label for="name">Name</label>

                <input type="text" id="username" name="username" value="${customer.username}" placeholder="Username">
                <label for="username">Username</label>

                <input type="text" id="email" name="email" value="${customer.email}" placeholder="Email">
                <label for="email">Email</label>

                <input type="text" id="gradeLevel" name="gradeLevel" value="${customer.gradeLevel}" placeholder="Grade Level">
                <label for="gradeLevel">Grade Level</label>

                <button type="submit" class="btn btn-primary">Save Changes</button>
                <a href="/customers/${customer.customerId}" class="btn btn-outline-danger">Discard Changes</a>

            </form>
        </div>
    </div>
</div>

</body>
</html>