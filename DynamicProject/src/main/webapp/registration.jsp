<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Page</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<div class="main">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>

                    <form method="post" action="register" class="register-form" id="register-form" onsubmit="return validateForm();">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="fname" id="fname" placeholder="First Name" value="<%= session.getAttribute("fname") != null ? session.getAttribute("fname") : "" %>" />
                        </div>
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="lname" id="lname" placeholder="Last Name" value="<%= session.getAttribute("lname") != null ? session.getAttribute("lname") : "" %>" />
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email" value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>" />
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="text" name="contact" id="contact" placeholder="Contact no" value="<%= session.getAttribute("contact") != null ? session.getAttribute("contact") : "" %>" />
                        </div>

                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure>
                        <img src="images/img3.jpg" alt="sign up image">
                    </figure>
                    <a href="login.jsp" class="signup-image-link">I am already a member</a>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

 <script type="text/javascript">
        function validateForm() {
            var fname = document.getElementById("fname").value.trim();
            var lname = document.getElementById("lname").value.trim();
            var email = document.getElementById("email").value.trim();
            var pass = document.getElementById("pass").value.trim();
            var contact = document.getElementById("contact").value.trim();

            // Check if any field is empty
            if (fname === "" || lname === "" || email === "" || pass === "" || contact === "") {
                swal("Error", "Please fill in all fields.", "error");
                return false;
            }

            // Check for spaces in fname, lname, and pass
            if (/\s/.test(fname) || /\s/.test(lname) || /\s/.test(pass)) {
                swal("Error", "No spaces allowed in First Name, Last Name, or Password.", "error");
                return false;
            }

            // Check for valid phone number format (10 digits starting with 6, 7, 8, or 9)
            if (!/^[6-9]\d{9}$/.test(contact)) {
                swal("Error", "Please enter a valid 10-digit phone number starting with 6, 7, 8, or 9.", "error");
                return false;
            }

            // Check if fname and lname contain at least 2 characters
            if (fname.length < 2 || lname.length < 2) {
                swal("Error", "First Name and Last Name should contain at least 2 characters.", "error");
                return false;
            }

            // Check if fname and lname contain only alphabets
            if (!/^[a-zA-Z]+$/.test(fname) || !/^[a-zA-Z]+$/.test(lname)) {
                swal("Error", "First Name and Last Name should contain only alphabets.", "error");
                return false;
            }

            // Check for a valid email format
            if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
                swal("Error", "Please enter a valid email address.", "error");
                return false;
            }

         swal("Success", "Validation passed. Form submitted successfully!", "success");
                return true;


    }
</script>
</body>
</html>
