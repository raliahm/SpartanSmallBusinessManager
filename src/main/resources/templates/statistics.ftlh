<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Business Statistics</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="/css/dashboard.css" />
    <link rel="stylesheet" href="/css/statistics.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body class="bg-light">

<div class="d-flex dashboard-content">
    <!-- Sidebar -->
    <nav class="sidebar bg-white shadow-sm p-3">
        <div class="text-center py-3">
            <img src="/static/images/spartan-logo.png" alt="SSBM Logo" class="sidebar-logo" />
        </div>
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link" href="/provider">Provider Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/business">Business Profile</a></li>
            <li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link active" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="flex-grow-1 p-5">
        <div class="container text-center">
            <h2 class="fw-bold text-primary mb-4">Business Statistics</h2>
            <canvas id="statsChart" width="400" height="400"></canvas>
        </div>
    </main>
</div>

<script>
    const totalSales = ${statistics.totalSales?c};
    const totalReviews = ${statistics.totalReviews};

    const ctx = document.getElementById("statsChart").getContext("2d");

    new Chart(ctx, {
        type: "pie",
        data: {
            labels: ["Total Sales ($)", "Total Reviews"],
            datasets: [{
                data: [totalSales, totalReviews],
                backgroundColor: ["#4e79a7", "#f28e2b"],
                borderColor: "#fff",
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: "bottom",
                    labels: {
                        font: {
                            size: 14,
                            family: "Inter"
                        }
                    }
                },
                title: {
                    display: true,
                    text: "Sales vs. Reviews",
                    font: {
                        size: 18,
                        weight: "bold",
                        family: "Inter"
                    }
                }
            }
        }
    });
</script>

</body>
</html>
