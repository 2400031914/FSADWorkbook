import React, { useState } from "react";
import axios from "axios";

function AddStudent(){

const [name,setName] = useState("");
const [email,setEmail] = useState("");
const [course,setCourse] = useState("");

const handleSubmit = (e) => {
e.preventDefault();

axios.post("http://localhost:8080/students",{
name,
email,
course
}).then(() => {
alert("Student Added");
});
};

return(
<div>

<h2>Add Student</h2>

<form onSubmit={handleSubmit}>

<input
placeholder="Name"
value={name}
onChange={(e)=>setName(e.target.value)}
/>

<input
placeholder="Email"
value={email}
onChange={(e)=>setEmail(e.target.value)}
/>

<input
placeholder="Course"
value={course}
onChange={(e)=>setCourse(e.target.value)}
/>

<button type="submit">Add</button>

</form>

</div>
);
}

export default AddStudent;