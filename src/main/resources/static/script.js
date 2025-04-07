const sideMenu = document.querySelector('aside');
const menuBtn = document.querySelector('#menu_bar');
const closeBtn = document.querySelector('#close_btn');
const sidebar = document.querySelector('.sidebar');

menuBtn.addEventListener('click', () => {
    sidebar.classList.remove('hidden'); // Show the sidebar
    menuBtn.style.display = 'none'; // Hide the menu button
    closeBtn.style.display = 'inline-flex'; // Show the close button
});

closeBtn.addEventListener('click', () => {
    sidebar.classList.add('hidden'); // Hide the sidebar content
    menuBtn.style.display = 'inline-flex'; // Show the menu button
    closeBtn.style.display = 'none'; // Hide the close button
});
