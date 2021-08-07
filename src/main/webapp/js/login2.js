let form = document.getElementById('login').addEventListener('submit', login);

async function login(e){
	e.preventDefault();
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	/*console.log(username, password);	*/
	let user = {
		username,
		password,
			}
	
	/*console.log(user);*/
	
	try{
		let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		//let res = await req.json();
		let res = await req.text();
		/*console.log(res);*/
	}catch(e){
		alert('Username or password was incorrect');
		return;
	}
	
	//need to figure out how to get the user-role to switch pages
	
if(role = "MANAGER"){
	location.href = './employeeServices.html';
}else (location.href = './employeeServices.html');
}