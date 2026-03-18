import { useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";

function Home() {
  const nav = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("userId");
    if (!user) {
      nav("/");
    }
  }, []);

  const logout = () => {
    localStorage.removeItem("userId");
    nav("/");
  };

  return (
    <div className="container">
      <h2>Welcome 🎉</h2>
      <p>You are successfully logged in.</p>
      <Link to="/profile">Go to Profile</Link>
      <br /><br />
      <button onClick={logout}>Logout</button>
    </div>
  );
}

export default Home;