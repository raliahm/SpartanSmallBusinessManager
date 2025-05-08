<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Business Profile</title>
    <link rel="stylesheet" href="/css/dashboard.css">
    <link rel="stylesheet" href="/css/business.css">
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
            <li class="nav-item"><a class="nav-link" href="/provider">Provider Profile</a></li>
            <li class="nav-item"><a class="nav-link active" href="/business">Business Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <main class="flex-grow-1 p-5">
        <div class="container">
            <h2 class="fw-bold mb-4 text-primary">Business Profile</h2>

            <#if business.businessName??>
            <div id="businessProfile" class="card p-4 shadow-sm text-center" style="max-width: 700px;">
                <img id="displayLogo" class="profile-logo mb-3" alt="Business Logo"
                     src="${business.logoUrl!'/images/default-logo.png'}" />
                <h3 class="fw-bold text-primary mb-2">${business.businessName}</h3>
                <p class="text-muted mb-3">${business.businessDescription}</p>
                <div class="d-flex justify-content-center gap-2">
                    <button class="btn btn-outline-primary btn-sm" onclick="toggleEdit()">Edit</button>
                    <a href="/business/delete/${business.businessId}" class="btn btn-outline-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete your business?')">Delete</a>
                </div>
            </div>

            <form id="editForm" class="bg-white p-4 rounded shadow-sm mt-4 d-none" style="max-width: 700px;"
                  method="post" enctype="multipart/form-data" action="/business/update/${business.businessId}">
                <div class="text-center mb-3">
                    <img id="logoPreviewEdit" class="profile-logo mb-3" alt="Logo Preview"
                         src="${business.logoUrl!'/images/default-logo.png'}" />
                </div>
                <div class="mb-3">
                    <label for="businessName" class="form-label">Business Name</label>
                    <input type="text" class="form-control" id="businessName" name="businessName"
                           value="${business.businessName}" required />
                </div>
                <div class="mb-3">
                    <label for="businessDescription" class="form-label">Business Description</label>
                    <textarea class="form-control" id="businessDescription" name="businessDescription"
                              rows="4" required>${business.businessDescription}</textarea>
                </div>
                <div class="mb-3">
                    <label for="logoFile" class="form-label">Upload New Logo (optional)</label>
                    <input type="file" class="form-control" id="logoFile" name="logoFile" accept="image/*" />
                </div>
                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary w-50">Save</button>
                    <button type="button" class="btn btn-secondary w-25" onclick="cancelEdit()">Cancel</button>
                </div>
            </form>

            <#else>
            <form class="bg-white p-4 rounded shadow-sm mb-5" style="max-width: 700px;"
                  method="post" action="/business/create" enctype="multipart/form-data">
                <div class="text-center mb-3">
                    <img id="logoPreviewEdit" class="profile-logo d-none" alt="Preview Logo" />
                </div>
                <div class="mb-3">
                    <label for="businessName" class="form-label">Business Name</label>
                    <input type="text" class="form-control" id="businessName" name="businessName" required>
                </div>
                <div class="mb-3">
                    <label for="businessDescription" class="form-label">Business Description</label>
                    <textarea class="form-control" id="businessDescription" name="businessDescription" rows="4" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="logoFile" class="form-label">Upload Logo</label>
                    <input type="file" class="form-control" id="logoFile" name="logoFile" accept="image/*">
                </div>
                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary w-50">Save</button>
                </div>
            </form>
        </#if>
</div>
</main>
</div>

<script>
    const fileInput = document.getElementById("logoFile");
    const preview = document.getElementById("logoPreviewEdit");
    const editForm = document.getElementById("editForm");
    const profileView = document.getElementById("businessProfile");

    if (fileInput) {
        fileInput.addEventListener("change", function () {
            const file = fileInput.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    preview.src = e.target.result;
                    preview.classList.remove("d-none");
                };
                reader.readAsDataURL(file);
            }
        });
    }

    function toggleEdit() {
        if (editForm && profileView) {
            editForm.classList.remove("d-none");
            profileView.classList.add("d-none");
        }
    }

    function cancelEdit() {
        if (editForm && profileView) {
            editForm.classList.add("d-none");
            profileView.classList.remove("d-none");
        }
    }
</script>
</body>
</html>
