function validateForm(evt) {
    var firstname = document.querySelector('#firstname').value;
    var lastname = document.querySelector('#lastname').value;
    const phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    const password =document.getElementById("password").value;

    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    var today = new Date();
    var birthdate = new Date(document.getElementById("birthdate").value);
    var age = today.getFullYear() - birthdate.getFullYear();
    var m = today.getMonth() - birthdate.getMonth();
    var gender = document.querySelector('input[name="gender"]:checked');
    var Diploma = document.querySelector('input[name="Diploma"]:checked');
    var degree = document.querySelector('#degree').value;
    if (!firstname || !lastname || !email ||!password || !phone || !gender || !Diploma || !degree)
     {
      alert("All fields are required");
      evt.preventDefault();
      return false;
    }else
    {
        if (!emailPattern.test(email)) 
        {
      alert("Invalid email address");
      evt.preventDefault();
      return false;
    } else
  {
        if (m < 0 || (m === 0 && today.getDate() < birthdate.getDate())) {
      age--;
    }
          if (age < 18) {
          alert("You must be at least 18 years old to be enrolled");
          evt.preventDefault();
          return false;
     
  }
  else{
    if (!phone.match(/^[0-9]{10}$/)) {
      alert("Invalid phone number. Please enter a 10-digit number.");
      evt.preventDefault();
      return false;
    }
    alert("Application submitted successfully");
    return true;
  }
  
  }
      }
    
  }