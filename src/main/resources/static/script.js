// Load all the businesses when the page is ready
document.addEventListener('DOMContentLoaded', function () {

    fetchBusinesses();
    // Attach event listeners to buttons

    document.getElementById("delete-btn").addEventListener("click", deleteBusiness);
     document.getElementById("restrict-btn").addEventListener("click", function () {
        restrictBusiness();
    });

    document.getElementById("unrestrict-btn").addEventListener("click", function () {

        unrestrictBusiness();
    });

});

function fetchBusinesses(){
    // Fetch businesses data from API
    fetch('/businesses/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the JSON response body
        })
        .then(data => {
            // Store businesses data to filter later
            window.businesses = data;
            renderBusinesses(data); // Render all businesses initially
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}

// Function to handle search bar input
document.getElementById("search-bar").addEventListener("keyup", function() {
    const searchTerm = this.value.toLowerCase();

    // Filter businesses by name
    const filteredBusinesses = window.businesses.filter(business =>
        business.businessName.toLowerCase().includes(searchTerm)
    );

    // Re-render the table with filtered businesses
    renderBusinesses(filteredBusinesses);
    // Hide or show the form based on search term
    const formContainer = document.querySelector('.custom-form-container');
    if (searchTerm.trim() !== '') {
        formContainer.style.display = 'none';  // Hide form when searching
    } else {
        formContainer.style.display = 'block';  // Show form when search bar is empty
    }
});








//loading the events
document.addEventListener('DOMContentLoaded', function () {
    fetch('events/recent')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parses the JSON response body
        })
        .then(data => {
            // `data` is now the JavaScript object/array parsed from the JSON response
            console.log(data);

            // If you want to use it with Handlebars:
            const source = document.getElementById('event-template').innerHTML;
            const template = Handlebars.compile(source);
            const html = template({ events: data });
            document.getElementById('eventsContainer').innerHTML = html;
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
});

document.getElementById("business-form").addEventListener("submit", async function(event) {
    event.preventDefault(); // Prevent page reload

    // Create a plain object from form data

    const business_name = document.getElementById("business-name").value;  // Update field name to match backend
    const business_address = document.getElementById("business-address").value;  // Update field name
    const business_description = document.getElementById("business-description").value;  // Update field name
    const category = document.getElementById("business-category").value;
    const provider_id = parseInt(document.getElementById("business-providerID").value, 10);  // Update field name and ensure it's an integer


    // BASIC VALIDATION
    if (business_name == "" || provider_id == "" || category == "" || business_description == "" || business_address == "") {
        alert("Please fill in all the fields.");
        console.log(business_description + " " + business_name + " " + business_address + " " + provider_id + " " + category)
        return; // 🔥 Don’t continue
    }
    const business = {business_name, business_address, category, business_description, provider_id};

    console.log(business.business_name);
    console.log(business.provider_id);
    console.log(business);
    console.log(JSON.stringify(business));

    // Send form data using POST method
    fetch('http://localhost:8081/businesses/new', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(business),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            addRecentUpdate(`Added new business: ${business_name}`);
            fetchBusinesses();
        });





});
document.getElementById('businessTable').addEventListener('click', function(event) {
    const row = event.target.closest('tr');
    if (row && row.parentNode.tagName === 'TBODY') {
        // Remove any previous selection
        const previouslySelected = document.querySelector('.selected');
        if (previouslySelected) {
            previouslySelected.classList.remove('selected');
        }

        // Add selection to clicked row
        row.classList.add('selected');

        const businessId = row.dataset.businessId;
        loadAndShowBusinessUpdateForm(businessId);
    }


});

