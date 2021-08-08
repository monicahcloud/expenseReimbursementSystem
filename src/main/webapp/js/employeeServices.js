$(document).ready(function () {

    $('#createReimbursements').click(function () {
        alert('You are about to make a reimbursement request.. Do you wish to continue?')
    })

    const createReim = async () => {
        let empId = $('#employeeId').val();
        let rAmount = $('#amountInput').val();
        let rDesc = $('#descriptionInput').val();
        let role = parseInt($('.radio-group').val())
 		console.log(empId)
        console.log(rAmount)
        console.log(rDesc)
        console.log(role)

        $('#employeeId').val("");
        $('#amountInput').val("");
        $('#descriptionInput').val("");
        $('#employeeID').val("");

        //$(".radio-group").selected === false;


        if (rAmount.length < 1 || rDesc.length < 1 ) {
            alert("Enter the reimbursement information");
            return;
        }
        let rObj = {
            amount: rAmount,
            description: rDesc,
            roleId: role,
            employeeID: empId
        };
        let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/addnewReimbursement', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rObj),
        });
        if (req.status !== 200) {
            alert("Reimbursement not valid");
            return;
        }
        else {
            let res = await req.json();
            console.log(res)
           
        }
    }
    //Setting the event listener for the login button
    document.getElementById('createReimbursements').addEventListener('click', createReim);
   // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});
})



/*console.log("In employee js");


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
*/