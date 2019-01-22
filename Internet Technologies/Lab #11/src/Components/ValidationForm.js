import React from "react";
export default class ValidationForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      age: 0,
      e_mail: "",
      nameError: "",
      ageError: "",
      e_mailError: ""
    };
  }
  handleChange(event) {
    switch (event.target.id) {
      case "Name":
        this.setState({ name: event.target.value });
        let regex = /\b[^\d\W]+\b/g;
        event.target.value.match(regex)
          ? this.setState({ nameError: "" })
          : this.setState({ nameError: "Invalid Name" });
        break;
      case "age":
        this.setState({ age: event.target.value });
        event.target.value >= 18
          ? this.setState({ ageError: "" })
          : this.setState({ ageError: "You must at least over 18." });
        break;
      case "e-mail":
        this.setState({ e_mail: event.target.value });
        let regexE = /\S+@\S+\.\S+/;
        event.target.value.match(regexE)
          ? this.setState({ e_mailError: "" })
          : this.setState({ e_mailError: "Not a valid e-mail format." });
        break;
      default:
        break;
    }
  }
  render() {
    return (
      <div>
        <form id="validationField">
          <section>
            <label className="error" for="errorName">
              {this.state.nameError}
            </label>
          </section>
          <label for="name">Name</label>
          <input
            class="inp1"
            id="name"
            type="text"
            placeholder="Name"
            value={this.state.name}
            onChange={this.handleChange.bind(this)}
          />
          <br />
          <br />
          <section>
            <label class="error" for="errorAge">
              {this.state.ageError}
            </label>
          </section>
          <label for="age">Age</label>
          <input
            class="inp2"
            id="age"
            type="number"
            placeholder="age"
            value={this.state.age}
            onChange={this.handleChange.bind(this)}
          />
          <br />
          <br />
          <section>
            <label class="error" for="errorE_mail">
              {this.state.e_mailError}
            </label>
          </section>
          <label for="e-mail">E-mail</label>
          <input
            class="inp3"
            id="e-mail"
            type="email"
            placeholder="e-mail"
            value={this.state.e_mail}
            onChange={this.handleChange.bind(this)}
          />
        </form>
      </div>
    );
  }
}
