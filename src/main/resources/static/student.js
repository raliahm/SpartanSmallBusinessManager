
// Load all the businesses when the page is ready
document.addEventListener('DOMContentLoaded', function () {
    // Fetch businesses data from API
    fetch('customer/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the JSON response body
        })
        .then(data => {
            // Store businesses data to filter later
            window.customers = data;
            renderCustomer(data); // Render all businesses initially
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });

    // Attach event listeners to buttons
    document.getElementById("delete-btn").addEventListener("click", deleteCustomer);
    document.getElementById("restrict-btn").addEventListener("click", restrictCustomer);
    document.getElementById("unrestrict-btn").addEventListener("click", unrestrictCustomer);
});

function renderCustomer(customers) {
    Handlebars.registerHelper('eq', function(a, b) {
        return a === b;
    });
    const source = document.getElementById('student-template').innerHTML;
    const template = Handlebars.compile(source);
    const html = template({ customers: customers });
    document.getElementById('studentTable').innerHTML = html;
}


// Function to handle search bar input
document.getElementById("search-bar").addEventListener("keyup", function() {
    const searchTerm = this.value.toLowerCase();

    // Filter businesses by name
    const filteredCustomers = window.customers.filter(customer =>
        customers.custName.toLowerCase().includes(searchTerm)
    );

    // Re-render the table with filtered businesses
    renderCustomer(filteredCustomers);
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
            document.getElementById('updatesContainer').innerHTML = html;
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
});


document.getElementById("student-form").addEventListener("submit", async function(event) {
    event.preventDefault(); // Prevent page reload

    // Create a plain object from form data
    const cust_username = document.getElementById('student-username').value;
    const cust_password = document.getElementById('student-password').value;
    const cust_name = document.getElementById('student-name').value;
    const cust_email = document.getElementById('student-email').value;
    const cust_phone = document.getElementById('student-phone').value;
    const cust_address = document.getElementById('student-address').value;
    const cust_city = document.getElementById('student-city').value;
    const cust_zip = document.getElementById('student-zipcode').value;
    const cust_state = document.getElementById('student-state').value;
    const cust_country = document.getElementById('student-country').value;

    if (cust_username === "" || cust_password === "" || cust_name === "" || cust_email === "" || cust_phone === "" || cust_address === "" || cust_city === "" || cust_zip === "") {
        alert("Please fill in all the fields.");
        return;
    } else if (cust_state === "" || cust_country === "") {
        alert("Please fill in all the fields.");
        return;
    }

    const customer = {
        custUsername: cust_username,
        custPassword: cust_password,
        custName: cust_name,
        custEmail: cust_email,
        custPhone: cust_phone,
        custAddress: cust_address,
        custCity: cust_city,
        custZip: cust_zip,
        custState: cust_state,
        custCountry: cust_country
    };
    console.log(JSON.stringify(customer));

    // Send form data using POST method
    fetch('customer/new', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(customer),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

        });





});


document.getElementById('studentTable').addEventListener('click', function(event) {
    const row = event.target.closest('tr');
    if (row && row.parentNode.tagName === 'TBODY') {
        // Remove any previous selection
        const previouslySelected = document.querySelector('.selected');
        if (previouslySelected) {
            previouslySelected.classList.remove('selected');
        }

        // Add selection to clicked row
        row.classList.add('selected');

        // Optional: Show selected in a div
        const custId = row.cells[0].textContent;
        const custName = row.cells[1].textContent;
        document.getElementById('selectedCustomerInfo').textContent = `Selected: [${custId}] ${custName}`;
    }
});




renderCustomer();