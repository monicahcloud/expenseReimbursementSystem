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
     	 $('.radio-group').val("");

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
             alert("Reimbursement Submitted!!!");
            console.log(res)
           
        }
    }
    //Setting the event listener for the login button
    document.getElementById('createReimbursements').addEventListener('click', createReim);
   // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});
})



