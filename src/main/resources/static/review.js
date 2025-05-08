document.addEventListener('DOMContentLoaded', () => {
    fetchFlaggedReviews();

    document.getElementById('delete-btn').addEventListener('click', deleteSelectedReview);


    document.getElementById('search-bar').addEventListener('input', handleSearch);
});

function fetchFlaggedReviews() {
    fetch('/reviews/flagged')
        .then(res => res.json())
        .then(data => {
            console.log(data);
            renderReviews(data); })
        .catch(err => {
            console.error("Failed to fetch flagged reviews", err);
            alert("Could not load reviews.");
        });
}

function renderReviews(reviews) {
    const source = document.getElementById('review-template').innerHTML;
    const template = Handlebars.compile(source);
    const html = template({ reviews: reviews });
    document.getElementById('reviewTable').innerHTML = html;

    // Enable row selection
    document.querySelectorAll('#reviewTable tbody tr').forEach(row => {
        row.addEventListener('click', () => {
            document.querySelectorAll('#reviewTable tbody tr').forEach(r => r.classList.remove('selected'));
            row.classList.add('selected');
        });
    });
}


// Handle search functionality
function handleSearch(event) {
    const searchTerm = event.target.value.toLowerCase();

    const rows = document.querySelectorAll('#reviewTable table tbody tr');
    rows.forEach(row => {
        const customerName = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
        if (customerName.includes(searchTerm)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

function getSelectedReviewId() {
    const selectedRow = document.querySelector('#reviewTable .selected');
    if (!selectedRow) return null;
    return selectedRow.dataset.reviewId;
}

async function deleteSelectedReview() {
    const reviewId = getSelectedReviewId();
    if (!reviewId) {
        alert("Please select a review to delete.");
        return;
    }

    if (!confirm(`Are you sure you want to delete review ID #${reviewId}?`)) {
        return;
    }
    fetch(`/reviews/get/${reviewId}`)
        .then(response => response.json())  // Parse the response as JSON
        .then(review => {
            console.log('Review:', review);  // Log the entire review object to inspect it
            const customerId = review.customer.custId; // Assuming the response contains a 'customerId'
            console.log('Customer ID:', customerId);

            restrictCustomer(customerId);

        })
        .catch(err => {
            console.error('Error fetching review:', err);
        });

    await fetch(`/reviews/delete/${reviewId}`, {
        method: 'DELETE'
    })
        .then(res => {
            if (!res.ok) throw new Error('Delete failed');
            alert('Review deleted successfully.');
            fetchFlaggedReviews();
            addRecentUpdate();

        })
        .catch(err => {
            console.error("Delete error:", err);
            alert("Error deleting review.");
        });
}

function addRecentUpdate() {
    fetch('/updates/table/reviews')  // Replace with your actual backend endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch update');
            }
            return response.json();
        })
        .then(data => {
            const updatesContainer = document.getElementById('salesContainer');
            updatesContainer.innerHTML = '';

            const recentUpdates = data.slice(0, 10); // Only take the first 10 entries

            // Assuming data is an array of updates
            recentUpdates.forEach(update => {
                const updateElement = document.createElement('div');
                updateElement.className = 'update-entry';
                updateElement.innerHTML = `<span class="material-symbols-outlined">check_circle</span>${update.updateType} on ${update.tableName} ${update.entityId} - ${update.updateDetail}`;
                updatesContainer.prepend(updateElement);
            });
        })
        .catch(error => {
            console.error('Error fetching update:', error);
        });
}

async function restrictCustomer(customerId) {
    await fetch(`/customer/restrict/${customerId}`, {
        method: 'PUT', // Assuming PUT is used for updating a customer status
        body: JSON.stringify({ restricted: true }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(data => {
            alert('Customer restricted successfully');
        })
        .catch(err => {
            console.error('Error restricting customer:', err);
            alert('Failed to restrict the customer');
        });
}