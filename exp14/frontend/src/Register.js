import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
  const nav = useNavigate();

  const [user, setUser] = useState({
    username: "",
    password: "",
    email: ""
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    if (!user.username || !user.password || !user.email) {
      alert("Please fill all fields");
      return;
    }

    axios.post("http://localhost:8080/api/register", user)
      .then(() => {
        alert("Registered Successfully");
        nav("/");
      });
  };

  return (
    <div className="container">
      <h2>Register</h2>
      <input name="username" placeholder="Username" onChange={handleChange} />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <button onClick={handleSubmit}>Register</button>
    </div>
  );
}

export default Register;