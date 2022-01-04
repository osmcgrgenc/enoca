function submitComment(event) {
    event.preventDefault();
    try {

        const customer = {
            firstName: event.target.firstName.value,
            lastName: event.target.lastName.value,
            age: event.target.age.value
        };
        if (customer.firstName.length < 5) {
            alert("First name must be filled.");
            return;
        }
        if (customer.lastName.length < 5) {
            alert("Last name must be filled.");
            return;
        }
        if (customer.age < 1) {
            alert("Age must be filled.");
            return;
        }
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/customer",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(customer),
            dataType: 'json',
            async: true
        });
        alert("Successfully");
        event.target.firstName.value = "";
        event.target.lastName.value = "";
        event.target.age.value = "";
    } catch (error) {
        alert(error.message);
        return;
    }
}
const form = document.getElementById('addCustomer');
form.addEventListener('submit', submitComment);