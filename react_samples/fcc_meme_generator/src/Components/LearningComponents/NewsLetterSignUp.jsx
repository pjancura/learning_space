import { useState } from "react";

export default function NewsLetterSignUp () {
    const [formData, setFormData] = useState(
        {
            email: "",
            password: "",
            confirmPassword: "",
            isNewsLetter: true,
        }
    )

    function handleSubmit(e) {
        e.preventDefault();
        checkPasswords(e) ? (
            console.log(formData)
         ) : (
            console.log("Form not submitted. Passwords didn't match")
         )
    }

    function checkPasswords() {
        return formData.password === formData.confirmPassword;
    }

    function handleChange(e) {
        const {name, value, checked} = e.target
        console.log(name, value)
        setFormData(d => {
            return (
                {
                    ...d,
                    [name]: (name === "isNewsLetter" ? checked : value)
                }
            )
        })
    }

    return (
        <form className="news-letter-sign-up-form" onSubmit={handleSubmit}>
            <label htmlFor="email">Email:</label>
            <input type="email" name="email" id="email" onChange={handleChange}/>
            <label htmlFor="password">Password:</label>
            <input type="password" name="password" id="password" onChange={handleChange}/>
            <label htmlFor="confirmPassword">Confirm Password:</label>
            <input type="password" name="confirmPassword" id="confirmPassword" onChange={handleChange}/>
            <div className="is-news-letter">
                <input type="checkbox" name="isNewsLetter" id="isNewsLetter" checked={formData.isNewsLetter} onChange={handleChange}/>
                <label htmlFor="isNewsLetter">Would you like to signup for our weekly news letter?</label>
            </div>
            <button>Sign Up</button>
        </form>
    );
}