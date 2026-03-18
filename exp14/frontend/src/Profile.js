import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Profile() {
  const [user, setUser] = useState({});
  const nav = useNavigate();

  useEffect(() => {
    const id = localStorage.getItem("userId");

    if (!id) {
      nav("/");
    } else {
      axios.get(`http://localhost:8080/api/user/${id}`)
        .then(res => setUser(res.data));
    }
  }, []);

  return (
    <div className="container">
      <h2>Profile</h2>
      <p><b>Username:</b> {user.username}</p>
      <p><b>Email:</b> {user.email}</p>
    </div>
  );
}

export default Profile;