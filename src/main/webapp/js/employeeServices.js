console.log("In employee js");


window.onload = getReimbursement();

let container = document.getElementById('employee-container');

async function getReimbursement(){
	let res = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/reimbursements');
	let data = await res.json();
	populateReimbursement(data);

}


function populate(data) {
	for (postObj of data) {
		let post = document.createElement('div');
		
		post.innerHTML = `
		<p>Reimbursement ID: ${postObj.reimb_id} </p>
		<p>Reimbursement Amount: ${postObj.amount} </p>
		<p>Reason: ${postObj.description}</p>
		<p>Date submitted: ${postObj.date}</p>
		<p>Date Employee ID: ${postObj.reimb_author}</p>
        <p>Type: ${postObj.type}</p><br>`;
		console.log(postObj);
		container.append(post);
	}
}

/*document.getElementById('submitReimb').addEventListener('click', submitReimb);

async function newReq(e) {
	e.preventDefault();
	let amount = document.getElementById("amount").value;
	let type = document.getElementById("type").value;
	let description = document.getElementById("description").value;

	let out = {
		amount,
		type,
		description
	}

	console.log(out);


	try {
		let req = await fetch('http://localhost:8080/ExpenseSystem/api/reimbursements', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(out)
		});
		let res = await req.text();
		console.log(res);
	} catch (e) {
	console.log (e.stack);
		alert('Something went Wrong');
		return;
	}
		function logout() {
			location.href = '/';
		}
*/

	