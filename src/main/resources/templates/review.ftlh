<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Customer Reviews</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="/css/dashboard.css" />
    <link rel="stylesheet" href="/css/review.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">

<div class="d-flex dashboard-content">
    <!-- Sidebar -->
    <nav class="sidebar bg-white shadow-sm p-3">
        <div class="text-center py-3">
            <img src="/static/images/spartan-logo.png" alt="Logo" class="sidebar-logo" />
        </div>
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link" href="/provider">Provider Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/business">Business Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link active" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="flex-grow-1 p-5">
        <div class="container">
            <h2 class="fw-bold text-primary mb-4">Customer Reviews</h2>

            <#list reviews as review>
            <div class="bg-white shadow-sm rounded p-4 mb-4">
                <h5 class="text-primary">Product: ${review.product.productName}</h5>
                <p><strong>Customer Review:</strong> ${review.reviewContent}</p>

                <form method="post" action="/reviews/reply/${review.reviewId}" class="review-form">
                    <div class="mb-3">
                        <label class="form-label">Your Response:</label>
                        <textarea class="form-control" name="replyContent" rows="3" id="reply-${review.reviewId}">${review.replyContent!""}</textarea>
                    </div>
                    <div class="d-flex gap-2">
                        <button class="btn btn-success btn-sm" type="submit">Save Reply</button>
                        <button class="btn btn-outline-danger btn-sm" type="button" onclick="deleteReply(${review.reviewId})">Delete Reply</button>
                    </div>
                </form>
            </div>
        </#list>

        <#if reviews?size == 0>
        <p class="text-muted">No customer reviews yet for your products.</p>
    </#if>
</div>
</main>
</div>

<script>
    function deleteReply(reviewId) {
        if (confirm("Are you sure you want to delete your reply?")) {
            window.location.href = "/reviews/reply/delete/" + reviewId;
        }
    }
</script>

</body>
</html>
