import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    students : [],
    student: {
      name: 'Cem Ates',
      s_id: 13869
    }
  }

  componentDidMount () {
   // fetch('http://localhost:3000/class')
   this.getClass();
  }

  getClass = _ => {
    fetch('http://localhost:3000/class')
    .then(response => response.json())
    // .then(({data}) => {
    //   console.log(data)
    // })
    .then(response => this.setState({students: response.data}))
    .catch(err => console.error(err))
  }

  addStudent = _ => {
    const { student } = this.state;
    fetch('http://localhost:3000/class/add?name=${student.name}&s_id=${student.s_id}')
    .then(response => response.json())
    .then(this.getClass)
    .catch(err => console.error(err))
  }

  renderStudents = ({name, s_id}) =><div key = {s_id}>(name)</div>

  render() {
    const { students } = this.state;
    return (
      <div className="App"> 
        {/* <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header> */}

        {students.map[this.renderStudents]};
        <div>
          <input value={students.name} onChange={e => this.setState({student: { ...students, name: e.target.value }})} />
          <input value={students.s_id} onChange={e => this.setState({student: { ...students, s_id: e.target.value }})} />
        </div>
        <button onClick={this.addStudent}>Add Student </button>
      </div>
    );
  }
}

export default App;
