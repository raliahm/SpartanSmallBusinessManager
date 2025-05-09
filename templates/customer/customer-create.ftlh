<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="/signup.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div id="navbar-container"></div>
<div id="content">
    <div id="card">
        <div class="card" >
            <div class="card-body">
                <form id="new-customer" action="/customers/new" method="post" class="card-body">
                    <h5 class="card-title">Create Account</h5>

                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                    <label class="form-label">Full Name</label>

                    <input type="text" class="form-control" id="email" name="email" placeholder="Email">
                    <label class="form-label">Email</label>

                    <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                    <label class="form-label">Username</label>

                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    <label class="form-label">Password</label>

                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                    <label class="form-label">Confirm Password</label>

                    <input type="text" class="form-control" id="gradeLevel" name="gradeLevel" placeholder="e.g. Freshman, Sophomore...">
                    <label class="form-label">Grade Level</label>

                    <button class="login-btn" type="submit">SIGN UP</button>
                </form>
            </div>
            <div class="alternate-signup">
                <p>Already a member? <a href="/login">Log In</a></p>

            </div>
        </div>
    </div>
</div>

</body>
</html>