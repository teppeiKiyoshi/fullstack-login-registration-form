import React, { useState } from 'react'

const LoginForm = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSignIn =(e)=> {
        e.preventDefault();
        const requestBody = {
            email: email, 
            password: password
        };
        console.log(requestBody);
        fetch("http://localhost:8080/api/employees/login", {
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(requestBody),
        }).then((response)=>{
            if(!response.ok){
                console.log("Error response status was not HTTP 200 OK.")
            } else {
                console.log("Employee successfully logged in.");
                console.log("response status on else condition : " + response.status);
            }
            setEmail("");
            setPassword("");
        }).catch((error) => {
            console.log("There has been an error on the operation: " + error);
        })
    }

    return (
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="/" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="/" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="/" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your account</span>
                <input type="email" placeholder="Email" value={email} onChange={(e)=> setEmail(e.target.value)}/>
                <input type="password" placeholder="Password" value={password} onChange={(e)=> setPassword(e.target.value)}/>
                <a href="/">Forgot your password?</a>
                <button onClick={handleSignIn}>Sign In</button>
            </form>
        </div>
    )
}

export default LoginForm