
 function printPressed(e){
	console.log(`Key pressed in username field: ${e.key}`);
}

let passwordField = document.getElementsByName('password')[0];
console.log(passwordField);

passwordField.addEventListener('keydown', presswordPress);

function presswordPress(e){
	console.log(`Key pressed in password field: ${e.key}`);
	}
	
	let login = document.getElementById('login');
	console.log(login);
	
	login.addEventListener('submit', submitForm);
	
	function submitForm(e){
		e.preventDefault();
		console.log('The login form was submitted.');
		console.log(`The username was ${document.getElementById('username').value}`);
		console.log(`The password was ${document.getElementById('password').value}`);
		
		login.reset();
	}