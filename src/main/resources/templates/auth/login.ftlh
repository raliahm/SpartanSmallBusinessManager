<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Spartan SSBM Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/login.css">
</head>
<body class="bg-light">

<div class="background-blur"></div>

<header class="d-flex align-items-center p-3 position-absolute top-0 start-0">
    <img src="/static/images/spartan-logo.png" alt="SSBM Logo" class="logo-img me-2">
    <h4 class="fw-bold text-primary m-0">Spartan Small Business Manager</h4>
</header>

<div class="container d-flex align-items-center justify-content-center min-vh-100">
    <div class="card login-card shadow p-4 w-100" style="max-width: 500px;">
        <div id="welcomeView">
            <h3 class="text-center text-primary fw-bold">Welcome to Spartan Small Business Manager</h3>
            <p class="text-center text-muted">Make a login selection</p>
            <div class="d-flex justify-content-center gap-3 mt-4">
                <button class="btn btn-outline-secondary" disabled>Customer</button>
                <button class="btn btn-primary" onclick="showView('loginView')">Provider</button>
            </div>
        </div>

        <div id="loginView" class="d-none">
            <h4 class="text-center text-primary mb-3">Provider Login</h4>
            <form method="post" action="/login">
                <input name="username" type="text" class="form-control mb-3" placeholder="Username" required>
                <input name="password" type="password" class="form-control mb-3" placeholder="Password" required>
                <button class="btn btn-primary w-100 mb-3" type="submit">Login</button>
            </form>
            <#if loginError??>
            <p class="text-danger text-center">Invalid username or password.</p>
        </#if>
        <div class="d-flex justify-content-between mb-2">
            <button class="btn btn-link p-0" onclick="showView('forgotUsernameView')">Forgot Username?</button>
            <button class="btn btn-link p-0" onclick="showView('forgotPasswordView')">Forgot Password?</button>
        </div>
        <button class="btn btn-outline-secondary w-100 mb-2" onclick="showView('signupView')">Sign Up</button>
        <button class="btn btn-link w-100" onclick="showView('welcomeView')">← Go Back</button>
    </div>

    <div id="signupView" class="d-none">
        <h4 class="text-center text-primary mb-3">Provider Sign Up</h4>
        <form method="post" action="/signup">
            <input name="providerName" type="text" class="form-control mb-2" placeholder="Provider Name" required>
            <input name="username" type="text" class="form-control mb-2" placeholder="Username" required>
            <input name="email" type="email" class="form-control mb-2" placeholder="Email" required>
            <input name="password" type="password" class="form-control mb-3" placeholder="Password" required>
            <button class="btn btn-primary w-100 mb-3" type="submit">Create Account</button>
        </form>
        <button class="btn btn-link w-100" onclick="showView('loginView')">← Go Back</button>
    </div>

    <div id="forgotUsernameView" class="d-none">
        <h4 class="text-center text-primary mb-3">Recover Username</h4>
        <input type="email" class="form-control mb-3" placeholder="Email (not implemented)">
        <button class="btn btn-primary w-100 mb-3">Submit</button>
        <button class="btn btn-link w-100" onclick="showView('loginView')">← Go Back</button>
    </div>

    <div id="forgotPasswordView" class="d-none">
        <h4 class="text-center text-primary mb-3">Reset Password</h4>
        <input type="email" class="form-control mb-3" placeholder="Email (not implemented)">
        <button class="btn btn-primary w-100 mb-3">Submit</button>
        <button class="btn btn-link w-100" onclick="showView('loginView')">← Go Back</button>
    </div>
</div>
</div>

<script>
    function showView(id) {
        document.querySelectorAll(".card > div").forEach(div => div.classList.add("d-none"));
        document.getElementById(id).classList.remove("d-none");
    }
</script>

</body>
</html>
