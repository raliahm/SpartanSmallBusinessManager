let providers;
document.addEventListener('DOMContentLoaded', function () {
    fetchProviders();
    document.getElementById("delete-btn").addEventListener("click", function(){
        deleteProvider();
    });
    document.getElementById("restrict-btn").addEventListener("click", function () {
        restrictProvider();
    });

    document.getElementById("unrestrict-btn").addEventListener("click", function () {

        unrestrictProvider();

    });
});

function fetchProviders(){
    fetch('providers/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parses the JSON response body
        })
        .then(data => {
            // `data` is now the JavaScript object/array parsed from the JSON response
            console.log(data);

            window.providers = data;
            renderProviders(data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}

function renderProviders(data) {
    
}

document.getElementById('providerTable').addEventListener('click', function(event) {
    const row = event.target.closest('tr');
    if (row && row.parentNode.tagName === 'TBODY') {
        // Remove any previous selection
        const previouslySelected = document.querySelector('.selected');
        if (previouslySelected) {
            previouslySelected.classList.remove('selected');
        }

        // Add selection to clicked row
        row.classList.add('selected');

        console.log("row" + JSON.stringify(row));
        const providerId = row.dataset.providerId;
        loadAndShowProviderUpdateForm(providerId);
    }


});


document.getElementById("search-bar").addEventListener("keyup", function() {
    const searchTerm = this.value.toLowerCase();

    // Filter providers by name
    const filteredProvider = window.providers.filter(provider =>
        provider.providerName.toLowerCase().includes(searchTerm)
    );

    // Re-render the table with filtered products
    renderProviders(filteredProvider);

    // Hide or show the form based on search term
    const formContainer = document.querySelector('.custom-form-container');
    if (searchTerm.trim() !== '') {
        formContainer.style.display = 'none';  // Hide form when searching
    } else {
        formContainer.style.display = 'block';  // Show form when search bar is empty
    }
});


document.getElementById("provider-form").addEventListener("submit", async function(event) {
    event.preventDefault(); // Prevent form default behavior

    // Collect form input values
    const providerName = document.getElementById("provider_name").value;
    const username = document.getElementById("username").value;
    const password = document.getElementById("provider_password").value;  // Assuming this field still exists in the form
    const email = document.getElementById("provider_email").value;
    const phoneNumber = document.getElementById("provider_phone").value;  // Assuming this field still exists in the form
    const address = document.getElementById("provider_address").value;
    const state = document.getElementById("provider_state").value;

// Collect restricted value
    const restricted = document.getElementById("restricted").value === "true";  // This handles the select dropdown

// Basic validation
    if (!providerName || !username || !password || !email || !phoneNumber || !address || !state) {
        alert("Please fill in all the fields.");
        return;
    }

// Build provider object for backend
    const provider = {
        providerName,
        username,
        password,
        email,
        phoneNumber,
        providerUserAddress: address,
        providerUserState: state,
        restricted,  // Now correctly set
        state: "Pending"  // Assuming the state is set to "Pending" as a default
    };


    try {
        const response = await fetch("providers/new", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(provider)
        });

        if (!response.ok) {
            throw new Error("Failed to create provider.");
        }

        alert("Provider successfully added.");
        addRecentUpdate();
        fetchProviders();

        // Optionally clear form
        document.getElementById("provider-form").reset();

    } catch (error) {
        console.error("Error adding provider:", error);
        alert("There was an error submitting the form.");
    }
});
