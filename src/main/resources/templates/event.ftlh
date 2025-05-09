<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Manage Events</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/css/dashboard.css" rel="stylesheet"/>
    <link href="/css/event.css" rel="stylesheet"/>
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
            <li class="nav-item"><a class="nav-link" href="/products">Products</a></li>
            <li class="nav-item"><a class="nav-link active" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/reviews">Reviews</a></li>
            <li class="nav-item"><a class="nav-link" href="/statistics">Statistics</a></li>
            <li class="nav-item mt-auto"><a class="nav-link text-danger" href="/logout">Logout</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="flex-grow-1 p-5">
        <div class="container">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2 class="fw-bold text-primary">Manage Events</h2>
                <button class="btn btn-primary" onclick="toggleForm()">➕ Add Event</button>
            </div>

            <!-- Event Form -->
            <div id="eventFormContainer" class="bg-white p-4 rounded shadow-sm mb-5 d-none" style="max-width: 700px;">
                <form id="eventForm" method="post" action="/events/create">
                    <input type="hidden" id="eventId" name="eventId" />
                    <div class="mb-3">
                        <label for="eventName" class="form-label">Event Name</label>
                        <input type="text" class="form-control" id="eventName" name="eventName" required />
                    </div>
                    <div class="mb-3">
                        <label for="eventDescription" class="form-label">Description</label>
                        <textarea class="form-control" id="eventDescription" name="eventDescription" rows="3" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="eventLocation" class="form-label">Location</label>
                        <input type="text" class="form-control" id="eventLocation" name="eventLocation" required />
                    </div>
                    <div class="mb-3">
                        <label for="eventDate" class="form-label">Date</label>
                        <input type="date" class="form-control" id="eventDate" name="eventDate" required />
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type="submit" class="btn btn-success">Save Event</button>
                        <button type="button" class="btn btn-outline-secondary" onclick="cancelForm()">Cancel</button>
                    </div>
                </form>
            </div>

            <!-- Event Cards -->
            <div class="row">
                <#list events as event>
                <div class="col-md-6">
                    <div class="card shadow-sm mb-4">
                        <div class="card-body">
                            <h5 class="card-title text-primary">${event.eventName}</h5>
                            <p><strong>Description:</strong> ${event.eventDescription}</p>
                            <p><strong>Location:</strong> ${event.eventLocation}</p>
                            <p><strong>Date:</strong> ${event.eventDate}</p>
                            <div class="d-flex gap-2">
                                <button class="btn btn-outline-primary btn-sm" onclick='editEvent(${event.eventId}, "${event.eventName?js_string}", "${event.eventDescription?js_string}", "${event.eventLocation?js_string}", "${event.eventDate}")'>Edit</button>
                                <a href="/events/delete/${event.eventId}" class="btn btn-outline-danger btn-sm">Delete</a>
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
    function toggleForm() {
        document.getElementById("eventFormContainer").classList.remove("d-none");
        window.scrollTo({ top: 0, behavior: "smooth" });
    }

    function cancelForm() {
        document.getElementById("eventForm").reset();
        document.getElementById("eventId").value = "";
        document.getElementById("eventForm").action = "/events/create";
        document.getElementById("eventFormContainer").classList.add("d-none");
    }

    function editEvent(id, name, desc, location, date) {
        document.getElementById("eventId").value = id;
        document.getElementById("eventName").value = name;
        document.getElementById("eventDescription").value = desc;
        document.getElementById("eventLocation").value = location;
        document.getElementById("eventDate").value = date;
        document.getElementById("eventForm").action = "/events/update/" + id;
        toggleForm();
    }
</script>
</body>
</html>
