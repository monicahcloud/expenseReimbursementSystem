const login = async (e) => {
	e.preventDefault();
	let username = document.getElementById('username').value;
	let password = document.getElementById('password').value;
	document.getElementById('login-form').reset();
	if (username.length < 1 || password.length < 1) {
		alert("Enter the credentials");
		return;
	}

	let uObj = {
		username: username,
		password: password,
	};

	let req = await fetch('http://localhost:8080/ExpensiveReimbursementSystem/api/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(uObj),
	});

	if (req.status !== 200) {
		alert("Username or password are incorrect");
		return;
	}
	else {
		let res = await req.json();
	if (res.userRole == 1) { 
		
			location.href = '../html/employeeServices.html';
		} else {
			location.href = '../html/managerServices.html';
		}
	}

}

//Setting the event listener for the login button
document.getElementById('login').addEventListener('click', login);

