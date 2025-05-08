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

function addRecentUpdate() {
    fetch('/updates/table/bad-words')  // Replace with your actual backend endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch update');
            }
            return response.json();
        })
        .then(data => {
            const updatesContainer = document.getElementById('salesContainer');

            // Assuming data is an array of updates
            data.forEach(update => {
                const updateElement = document.createElement('div');
                updateElement.className = 'update-entry';
                updateElement.textContent = `${update.updateType} on ${update.table_name} - ${update.updateDetail}`;
                updatesContainer.prepend(updateElement);
            });
        })
        .catch(error => {
            console.error('Error fetching update:', error);
        });
}
