import React, {useState} from 'react'
import '../LoginRegistration.css'

const Registration = () => {

    const [employeeName, setEmployeeName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const handleSignUp =(e)=> {
        e.preventDefault();
        const requestBody = {
            employeeName: employeeName,
            email: email, 
            password: password
        };
        console.log(requestBody);
        fetch("http://localhost:8080/api/employees/save", {
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(requestBody)
        }).then((response)=>{
            console.log("Employee successfully logged in.");
            console.log("response status before condition : " + response.status);
            if(!response.ok){
                console.log("Error response status was not HTTP 200 OK.")
            }
            setEmployeeName("");
            setEmail("");
            setPassword("");
        }).catch((error) => {
            console.log("There has been an error on the operation: " + error);
        })
    }

    return (
        <div className="form-container sign-up-container">
            <form action="/">
                <h1>Create Account</h1>
                <div className="social-container">
                    <a href="/" className="social"><i className="fab fa-facebook-f"></i></a>
                    <a href="/" className="social"><i className="fab fa-google-plus-g"></i></a>
                    <a href="/" className="social"><i className="fab fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registration</span>
                <input type="text" placeholder="Name" value={employeeName} onChange={(e)=> setEmployeeName(e.target.value)}/>
                <input type="email" placeholder="Email" value={email} onChange={(e)=> setEmail(e.target.value)}/>
                <input type="password" placeholder="Password" value={password} onChange={(e)=> setPassword(e.target.value)}/>
                <button onClick={handleSignUp}>Sign Up</button>
            </form>
        </div>
    )
}

export default Registration