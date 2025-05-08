<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/dashboard.css"/>
    <link rel="stylesheet" href="/css/products.css"/>
</head>
<body class="bg-light">

<div class="d-flex dashboard-content">
    <!-- Sidebar -->
    <nav class="sidebar bg-white shadow-sm p-3">
        <div class="text-center py-3">
            <img src="/static/images/spartan-logo.png" alt="Logo" class="sidebar-logo"/>
        </div>
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link" href="/provider">Provider Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/business">Business Profile</a></li>
            <li class="nav-item"><a class="nav-link active" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="flex-grow-1 p-5">
        <div class="container">
            <h2 class="fw-bold text-primary mb-4">Manage Products</h2>

            <!-- Product Form -->
            <form id="productForm" class="bg-white p-4 rounded shadow-sm mb-4" method="post" enctype="multipart/form-data"
                  action="/products/create">
                <input type="hidden" id="productId" name="productId"/>

                <div class="mb-3">
                    <label for="productName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="productName" name="productName" required/>
                </div>

                <div class="mb-3">
                    <label for="productDescription" class="form-label">Description</label>
                    <textarea class="form-control" id="productDescription" name="productDescription"
                              rows="3" required></textarea>
                </div>

                <div class="mb-3">
                    <label for="productPrice" class="form-label">Price</label>
                    <input type="number" step="0.01" class="form-control" id="productPrice" name="productPrice" required/>
                </div>

                <div class="mb-3">
                    <label for="productQuantity" class="form-label">Quantity</label>
                    <input type="number" class="form-control" id="productQuantity" name="productQuantity" required/>
                </div>

                <div class="mb-3">
                    <label for="productCategory" class="form-label">Category</label>
                    <select class="form-select" id="productCategory" name="productCategory" required>
                        <option value="">Select a category</option>
                        <option value="Toys">Toys</option>
                        <option value="Clothing">Clothing</option>
                        <option value="Home Decor">Home Decor</option>
                        <option value="Education">Education</option>
                        <option value="Technology">Technology</option>
                        <option value="Automobile">Automobile</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="productImageFile" class="form-label">Product Image</label>
                    <input type="file" class="form-control" id="productImageFile" name="productImageFile" accept="image/*"/>
                    <img id="previewImage" class="img-thumbnail mt-2 d-none" style="max-width: 200px;"/>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Save Product</button>
                    <button type="reset" class="btn btn-secondary" onclick="resetForm()">Cancel</button>
                </div>
            </form>

            <!-- Product Cards -->
            <div class="row">
                <#list products as product>
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <#if product.productImage??>
                        <img src="${product.productImage}" class="card-img-top" style="height: 200px; object-fit: cover;">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${product.productName}</h5>
                        <p class="card-text">${product.productDescription}</p>
                        <p><strong>$${product.productPrice}</strong> | ${product.productQuantity} pcs</p>
                        <p><em>${product.productCategory}</em></p>
                        <div class="d-flex gap-2">
                            <button class="btn btn-outline-primary btn-sm" onclick='editProduct(
                                            ${product.productId},
                                            "${product.productName?js_string}",
                                            "${product.productDescription?js_string}",
                                            ${product.productPrice},
                                            ${product.productQuantity},
                                            "${product.productCategory?js_string}",
                                            "${product.productImage?js_string}")'>Edit</button>
                            <a href="/products/delete/${product.productId}" class="btn btn-outline-danger btn-sm">Delete</a>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
</div>
</div>
</main>
</div>

<script>
    const previewImage = document.getElementById("previewImage");
    const imageFileInput = document.getElementById("productImageFile");

    imageFileInput.addEventListener("change", () => {
        const file = imageFileInput.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = () => {
                previewImage.src = reader.result;
                previewImage.classList.remove("d-none");
            };
            reader.readAsDataURL(file);
        }
    });

    function resetForm() {
        document.getElementById("productForm").reset();
        previewImage.classList.add("d-none");
        previewImage.src = "";
        document.getElementById("productForm").action = "/products/create";
    }

    function editProduct(id, name, desc, price, qty, category, imageUrl) {
        document.getElementById("productId").value = id;
        document.getElementById("productName").value = name;
        document.getElementById("productDescription").value = desc;
        document.getElementById("productPrice").value = price;
        document.getElementById("productQuantity").value = qty;
        document.getElementById("productCategory").value = category;

        if (imageUrl && imageUrl !== "null") {
            previewImage.src = imageUrl;
            previewImage.classList.remove("d-none");
        } else {
            previewImage.classList.add("d-none");
        }

        document.getElementById("productForm").action = "/products/update/" + id;
    }
</script>
</body>
</html>
