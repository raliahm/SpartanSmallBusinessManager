<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Provider Profile</title>
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/provider.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet"/>
</head>
<body class="bg-light">

<div class="background-blur"></div>

<div class="d-flex dashboard-content">
    <nav class="sidebar bg-white shadow-sm p-3">
        <div class="text-center py-3">
            <img src="/static/images/spartan-logo.png" alt="SSBM Logo" class="sidebar-logo" />
        </div>
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link active" href="/provider">Provider Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/business">Business Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <main class="flex-grow-1 p-5">
        <div class="container" style="max-width: 700px">
            <h2 class="fw-bold mb-4 text-primary">Provider Profile</h2>

            <div id="providerProfile" class="bg-white rounded shadow-sm p-4 mb-4">
                <p><strong>Name:</strong> ${provider.providerName}</p>
                <p><strong>Username:</strong> ${provider.username}</p>
                <p><strong>Email:</strong> ${provider.email}</p>
                <p><strong>Created At:</strong> ${provider.createdAt}</p>
                <div class="d-flex gap-2">
                    <button class="btn btn-outline-primary btn-sm" onclick="editProvider()">Edit</button>
                    <a href="/provider/delete/${provider.providerId}" class="btn btn-outline-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                </div>
            </div>

            <form id="editForm" method="post" action="/provider/update" class="bg-white rounded shadow-sm p-4 d-none">
                <input type="hidden" name="providerId" value="${provider.providerId}">
                <div class="mb-3"><label>Name</label><input name="providerName" class="form-control" value="${provider.providerName}" required></div>
                <div class="mb-3"><label>Username</label><input name="username" class="form-control" value="${provider.username}" required></div>
                <div class="mb-3"><label>Email</label><input name="email" class="form-control" value="${provider.email}" required></div>
                <div class="mb-3"><label>New Password</label><input name="password" type="password" class="form-control" required></div>
                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-primary btn-sm">Save Changes</button>
                    <button type="button" class="btn btn-secondary btn-sm" onclick="cancelEdit()">Cancel</button>
                </div>
            </form>
        </div>
    </main>
</div>

<script>
    function editProvider() {
        document.getElementById("providerProfile").classList.add("d-none");
        document.getElementById("editForm").classList.remove("d-none");
    }
    function cancelEdit() {
        document.getElementById("editForm").classList.add("d-none");
        document.getElementById("providerProfile").classList.remove("d-none");
    }
</script>

</body>
</html>
