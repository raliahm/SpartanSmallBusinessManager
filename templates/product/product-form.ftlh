<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<nav class="navbar">
    <div class="logo">Spartan Small Business Manager</div>
    <input type="checkbox" id="menu-toggle">
    <label for="menu-toggle" class="menu-icon">&#9776;</label>
    <ul class="nav-links">
        <li><a href="/customers/home">Home</a></li>
        <li><a href="/products/all">All Products</a></li>
        <li><a href="/businesses/all">Businesses</a></li>
    </ul>
</nav>

<div class="container">
    <div class="card">
        <h2>Add New Product</h2>

        <form action="/products/new" method="post">
            <div class="form-group">
                <label for="name"><strong>Product Name:</strong></label><br>
                <input type="text" id="name" name="name" required><br><br>
            </div>

            <div class="form-group">
                <label for="description"><strong>Description:</strong></label><br>
                <textarea id="description" name="description" rows="3" required></textarea><br><br>
            </div>

            <div class="form-group">
                <label for="price"><strong>Price ($):</strong></label><br>
                <input type="number" id="price" name="price" step="0.01" min="0" required><br><br>
            </div>

            <div class="form-group">
                <label for="businessId"><strong>Associated Business:</strong></label><br>
                <select name="businessId" id="businessId" required>
                    <option value="">-- Select Business --</option>
                    <#list businesses as business>
                    <option value="${business.businessId}">${business.businessName}</option>
                </#list>
                </select><br>
                <input type="hidden" name="quantity" value="0">
            </div>


            <button type="submit">Add Product</button>
        </form>
    </div>
</div>

</body>
</html>