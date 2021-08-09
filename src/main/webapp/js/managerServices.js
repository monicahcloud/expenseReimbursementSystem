
let container = document.getElementById('post-container');

async function getReimbursements(){

    alert("here");
    let res = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements')
    let data = await res.json();
    populateReimb(data);
    console.log(data);
}
function popluateReimb(data){
		for (postObj of data) {
			let reimb = document.createElement('div');
			reimb.innerHTML = `<h2>${postbj.empId}</h2>
			<p>${postObj.firstName}</p>;
			<p>${postObj.lastName}</p>;
			<p>${postObj.email}</p>;
			<p>${postObj.role}</p>;
			`;
			console.log(postObj);
			container.append(reimb);
		}
		}
		
document.getElementById('all').addEventListener('click', viewReim);

async function viewReim(e){
	e.preventDefault();
	let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/session');
	let res = await re.json();
	let empId = res.empNumber;
	let firstName = res.firstName;
	let lastName = res.lastName;
	let email = res.email;
	let password = res.password;
	let role = res.role;
	
}

let employee = {
	empId : empId,
	firstName : firstName,
	lastName : lastName,
	email : email,
	password : password,
	role : role
	}
	
	await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements', {
		method: "POST",
		contentType: "application/json",
		body: JSON.stringify(employee)
	});
	
	req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements');
	let data = await req.json();
	container.innerHTML = '';
	content.value='';
	populateReimb(data);
	
	


