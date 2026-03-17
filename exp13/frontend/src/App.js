import React from "react";
import StudentList from "./StudentList";
import AddStudent from "./AddStudent";
import "./App.css";

function App() {
  return (
    <div className="container">
      <h1>🎓 Student Management System</h1>
      
      <div className="card">
        <h2>Add Student</h2>
        <AddStudent />
      </div>

      <div className="card">
        <h2>Student List</h2>
        <StudentList />
      </div>
    </div>
  );
}

export default App;