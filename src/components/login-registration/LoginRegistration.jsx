import React, { useState } from "react";
import './LoginRegistration.css';
import Registration from "./registration/Registration";
import LoginForm from "./login/LoginForm";
import Backdrop from "./backdrop/Backdrop";

const LoginRegistration = () => {

    const [formStyle, setFormStyle] = useState("container right-panel-active");

    const handleStylingClick = () => {
        formStyle !== "container right-panel-active" ? setFormStyle("container right-panel-active") : setFormStyle("container");
    }

    return (
        <div>
            <Backdrop/>
            <div className={formStyle} id="container">
                <Registration />
                <LoginForm />
                <div className="overlay-container">
                    <div className="overlay">
                        <div className="overlay-panel overlay-left">
                            <h1>Welcome Back!</h1>
                            <p>To keep connected with us please login with your personal info</p>
                            <button className="ghost" id="signIn" onClick={handleStylingClick}>Sign In</button>
                        </div>
                        <div className="overlay-panel overlay-right">
                            <h1>Hello, Friend!</h1>
                            <p>Enter your personal details and start journey with us</p>
                            <button className="ghost" id="signUp" onClick={handleStylingClick}>Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default LoginRegistration