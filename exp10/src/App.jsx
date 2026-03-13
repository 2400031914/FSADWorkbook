import { useState } from "react";
import "./App.css";

function App() {
  const [students, setStudents] = useState([
    { id: "2400031000", name: "Rahul", course: "CSE" },
    { id: "2400031001", name: "Sneha", course: "AI&DS" },
    { id: "2400031002", name: "Arjun", course: "IT" },
    { id: "2400031003", name: "Priya", course: "CS" },
    { id: "2400031004", name: "Kiran", course: "CSE" },
  ]);

  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [course, setCourse] = useState("");

  const addStudent = () => {
    if (!id || !name || !course) return;
    setStudents([...students, { id, name, course }]);
    setId("");
    setName("");
    setCourse("");
  };

  const deleteStudent = (sid) => {
    setStudents(students.filter((s) => s.id !== sid));
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <div className="form">
        <input
          type="number"
          placeholder="ID"
          value={id}
          onChange={(e) => setId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Course"
          value={course}
          onChange={(e) => setCourse(e.target.value)}
        />
        <button onClick={addStudent}>Add Student</button>
      </div>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;