import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";

function Login() {
  const nav = useNavigate();

  const [user, setUser] = useState({
    username: "",
    password: ""
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const login = () => {
    if (!user.username || !user.password) {
      alert("Please fill all fields");
      return;
    }

    axios.post("http://localhost:8080/api/login", user)
      .then(res => {
        if (res.data) {
          localStorage.setItem("userId", res.data.id);
          alert("Login Successful");
          nav("/home");
        } else {
          alert("Invalid credentials");
        }
      });
  };

  return (
    <div className="container">
      <h2>Login</h2>
      <input name="username" placeholder="Username" onChange={handleChange} />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <button onClick={login}>Login</button>
      <p>New user? <Link to="/register">Register</Link></p>
    </div>
  );
}

export default Login;