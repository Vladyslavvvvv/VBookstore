document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('submit');
    const usernameField = document.getElementById('username');
    const passwordField = document.getElementById('password');
    const confirmPasswordField = document.getElementById('confirmPassword');
    const emailField = document.getElementById('email');
    const passwordErrorMessage = document.getElementById('passwordError-message');
    const usernameErrorMessage = document.getElementById('usernameError-message'); // Ensure this element exists in your HTML

    submitButton.addEventListener('click', (event) => {
        // Clear previous error messages
        passwordErrorMessage.innerText = '';
        usernameErrorMessage.innerText = '';

        const username = usernameField.value;
        const password = passwordField.value;
        const confirmPassword = confirmPasswordField.value;
        const email = emailField.value;

        // Prevent default form submission
        event.preventDefault();

        // Check if passwords match
        if (password !== confirmPassword) {
            passwordErrorMessage.innerText = "Passwords do not match.";
            return;
        }

        const data = {
            username,
            password,
            email
        };

        const jsonData = JSON.stringify(data);

        fetch('/registration', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: jsonData
        })
            .then(response => {
                // Handling respons
            })
    })
})