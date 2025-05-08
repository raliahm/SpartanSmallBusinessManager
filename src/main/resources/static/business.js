var total = 0;
var allBus = {};

let bc = 0, cc = 0, pc = 0;
document.addEventListener('DOMContentLoaded', function (){

    Promise.all([
        fetch('http://localhost:8081/businesses/getBusinessCount').then(res => res.json()),
        fetch('http://localhost:8081/customer/getCustomerCount').then(res => res.json()),
        fetch('http://localhost:8081/providers/getProviderUserCount').then(res => res.json())
    ]).then(([businessCount, customerCount, providerCount]) => {
        bc = businessCount;
        cc = customerCount;
        pc = providerCount;

        total = bc + cc + pc;

        document.getElementById('businessCount').textContent = bc;
        document.getElementById('customerCount').textContent = cc;
        document.getElementById('providerCount').textContent = pc;
        document.getElementById('totalUserCount').textContent = total;

        setRatios(); // now all values are loaded
    }).catch(error => {
        console.error('Error loading counts:', error);
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

let tR = 0, tF = 0, tT = 0;
document.addEventListener('DOMContentLoaded', function () {
    Promise.all([
        fetch('http://localhost:8081/reviews/count/all').then(res => res.json()),
        fetch('http://localhost:8081/reviews/count/false').then(res => res.json()),
        fetch('http://localhost:8081/reviews/count/true').then(res => res.json())
    ])
        .then(([totalReviewCount, falseCount, trueCount]) => {
            tR = totalReviewCount;
            tF = falseCount;
            tT = trueCount;
            document.getElementById('totalReviewCount').textContent = totalReviewCount;
            document.getElementById('totalFalse').textContent = falseCount;
            document.getElementById('totalTrue').textContent = trueCount;

            console.log('Review counts:', { totalReviewCount, falseCount, trueCount });

            setRatios();
        })
        .catch(error => {
            console.error('Fetch error (review counts):', error);
            document.getElementById('totalReviewCount').textContent = 'N/A';
            document.getElementById('totalFalse').textContent = 'N/A';
            document.getElementById('totalTrue').textContent = 'N/A';
        });
});


function setRatios(){

       let ratio = bc/total;
        ratio = Math.round(ratio  * 100);
       document.getElementById('businessDayToDayRatio').textContent = `${ratio}%`;
       ratio = cc/total ;
       ratio = Math.round(ratio  * 100);

       document.getElementById('customerDayToDayRatio').textContent = `${ratio}%` ;

        ratio = total/total;
       document.getElementById('totalU').textContent = `${ratio}%`;

    ratio = pc/total;
    ratio = Math.round(ratio * 100);
       document.getElementById('providerDayToDayRatio').textContent = `${ratio}%`;

    ratio = Math.round((tR / total) * 100);
    document.getElementById('totalR').textContent = `${ratio}%`;

    ratio = Math.round((tF / total) * 100);
    document.getElementById('unflagged').textContent = `${ratio}%`;

    ratio = Math.round((tT / total) * 100);
    document.getElementById('flagged').textContent = `${ratio}%`;
}

