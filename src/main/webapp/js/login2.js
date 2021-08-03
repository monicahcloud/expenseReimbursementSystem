let form = document.getElementById('login').addEventListener('submit', login);

async function login(e){
	e.preventDefault();
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	console.log(username, password);
	
	let user = {
		username,
		password,
		
	}
	
	console.log(user);
	
	try{
		let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		let res = await req.json();
		console.log(res);
	}catch(e){
		alert('Username or password was incorrect');
		return;
	}
location.href = './landing.html';
}
if(role = "MANAGER"){
	location.href = '.landing.html';
}else ()

	