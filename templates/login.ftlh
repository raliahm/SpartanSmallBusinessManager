<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In Page</title>
    <link rel="stylesheet" href="/signup.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div id="content">
    <div id="card">
        <div class="card">
            <div class="card-body">
                <form action="/customers/login" method="post">
                    <h5 class="card-title">Login</h5>

                    <#if error??>
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                    </#if>

                    <input type="text" class="form-control" name="username" placeholder="Username" required>
                    <label class="form-label">Username</label>

                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                    <label class="form-label">Password</label>

                    <button class="login-btn" type="submit">LOGIN</button>
                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>