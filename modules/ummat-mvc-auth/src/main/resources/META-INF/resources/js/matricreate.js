	$(document).ready(
			function() {
				$(".files").attr('data-before',
						"Drag file here or click the above button");
				$('input[type="file"]').change(function(e) {
					var fileName = e.target.files[0].name;
					$(".files").attr('data-before', fileName);

				});
			});
	
	document.getElementById('_ummat_users_auth_UmmatMatriAccountPortlet_jamath').addEventListener('change', function() {
	    var selectedJamath = this.value;
	    var shareInput = document.getElementById('jamOthr');

	    if (selectedJamath === 'Others') {
	        // Display additional input field for 'Others'
	        shareInput.classList.remove('hide');
	    } else {
	        // Hide additional input field for other selections
	       shareInput.classList.add('hide');
	    }
	});

	document.getElementById('_ummat_users_auth_UmmatMatriAccountPortlet_maritalStatus').addEventListener('change', function() {
	    var selectedStatus = this.value;
	    var matWidBoy = document.getElementById('matWidBoy');
	    var matWidGrl = document.getElementById('matWidGrl');

	    // Determine which element to show based on selected marital status
	    if (selectedStatus !== 'Single') {
	        matWidBoy.classList.remove('hide');
	        matWidGrl.classList.remove('hide');
	    } else {
	        matWidBoy.classList.add('hide');
	        matWidGrl.classList.add('hide');
	    }
	    if (selectedJamath === 'Others') {
	        var textareaValue = document.getElementById('formControlTextarea2').value;
	        document.getElementsByName('jamath')[0].value = textareaValue;
	    }
	});

	/* Mobile Number Validation  */
	
   /*  function validateMobileNumber(input) {
        var value = input.value.trim();
        var isValid = /^[0-9]{10}$/.test(value);

        if (!isValid) {
            alert('Please enter a valid 10-digit mobile number.');
            input.value = '';
            input.focus();
        }
    } */

	