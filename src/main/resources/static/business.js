var total = 0;
var allBus = {};


document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/businesses/getBusinessCount')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // This returns a promise with parsed JSON
        })
        .then(data => {
            // Assuming the response is just a number like: 10
            // OR an object like { count: 10 }, adapt accordingly

            // If your response is a raw number like 10:
            console.log(data);
            document.getElementById('businessCount').textContent = data;
            total = total + data;
            document.getElementById('totalUserCount').textContent = total;

            // If it's { count: 10 }:
            // document.getElementById('businessCount').textContent = data.count;
        })
        .catch(error => {
            console.error('Fetch error:', error);
            document.getElementById('businessCount').textContent = 'N/A';
        });
});
document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/customer/getCustomerCount')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // This returns a promise with parsed JSON
        })
        .then(data => {
            // Assuming the response is just a number like: 10
            // OR an object like { count: 10 }, adapt accordingly

            console.log(data);
            document.getElementById('customerCount').textContent = data;
            total = total + data;
            document.getElementById('totalUserCount').textContent = total;
            // If it's { count: 10 }:
            // document.getElementById('businessCount').textContent = data.count;
        })
        .catch(error => {
            console.error('Fetch error:', error);
            document.getElementById('customerCount').textContent = 'N/A';
        });
});
document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/providers/getProviderUserCount')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // This returns a promise with parsed JSON
        })
        .then(data => {
            // Assuming the response is just a number like: 10
            // OR an object like { count: 10 }, adapt accordingly

            // If your response is a raw number like 10:
            console.log(data);
            document.getElementById('providerCount').textContent = data;
            total = total + data;
            document.getElementById('totalUserCount').textContent = total;
            // If it's { count: 10 }:
            // document.getElementById('businessCount').textContent = data.count;
        })
        .catch(error => {
            console.error('Fetch error:', error);
            document.getElementById('customerCount').textContent = 'N/A';
        });
});

document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/businesses/all')
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
            const source = document.getElementById('business-template').innerHTML;
            const template = Handlebars.compile(source);
            const html = template({ businesses: data });
            document.getElementById('businessTable').innerHTML = html;
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
});




document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8081/events/recent')
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