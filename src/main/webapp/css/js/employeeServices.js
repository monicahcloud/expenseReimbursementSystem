/*$(document).ready(function(){
$('#submitReimb').click(function(event){
	
	$("#submitTable").append(`<div class="table-responsive">
  <table class="table"><caption>Submit Reimbursement</caption>
    <thead>
    <tr>
      <th scope="col">Reimbursement Amount</th>
      <th scope="col">Employee Number</th>
      <th scope="col">Description</th>
      <th scope="col">Type of Reimbursement</th>
    </tr>
  </thead>
  </table>
	
	</div>`)
}))*/

let container = document.getElementById('post-container');
window.onload = getReimbursement();

async function getReimbursement(){
	let res = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/employeeServices');
	let data = await res.json();
	console.log(data);
	populateReimbursement(data);
}

function populateReimbursement(data){
	for (postObj of data) {
        let reimb = document.createElement('div');
        reimb.innerHTML = `<h2>${postObj.username}</h2>
                      <p>${postObj.content}</p>`;
        console.log(postObj);
        container.append(reimb);
    }
}

/*document.getElementById('submitReimb').addEventListener('click', submitRequest);

async function submitRequest(e){
	e.preventDefault();
	let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements');
	let res = await req.json();
	let id = res.employee_number;
	
	let content = document.getElementById("reimbursement-request").value;
	if(!content){
		alert("You must have enter a request!");
		return;
		}
		var time = new Date().getTime()
		
	let reimbursement = {
		reimb_amount: reimbAmount,
		reimb_description: reimbDescription,
		reimb_submitted: time,
		reimb_author: reimbAuthor,
		reimb_type: reimbType
	}
	
	await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements', {
		method: "POST",
		contentType: "application/json",
		body: JSON.stringify(reimbursement)
	});
	
	req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements');
	let data = await req.json();
	container.innerHTML = '';
	content.value='';
	populatePosts(data);
}	

let logoutbtn = document.getElementById("logout").addEventListener("click", logout);

async function logout(){
	let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/logout');
	let res = await req.text();
	console.log(res);
	req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/logout');
	res = await req.text();
	console.log(res);
	location.href = '../html/login.html';

	
}*/
getReimbursement();



