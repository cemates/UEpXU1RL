import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import ValidationForm from "./ValidationForm";
export default class Layout extends React.Component {
  render() {
    var myArr = [
      "Huseyin Cem Ates",
      "Mckenzie Wallace",
      "Farrah Rodgers",
      "Antoinette Rawlings",
      "Lorem Ipsum",
      "Francis Lancaster",
      "Ashley Munoz",
      "Cody Mcgrath",
      "Diya Povey",
      "Sacha Quinn",
      "Aidan Erickson",
      "Kya Simmons",
      "Stella Hirst",
      "Lindsey Foley"
    ];
    return (
      <div>
        <section>
          <Header header="Group 12C" />
        </section>
        <div>
          {myArr.map(arr => (
            <li>{arr}</li>
          ))}
        </div>
        <section>
          <ValidationForm />
        </section>
        <div>
          <Footer footer={this.props.footer} />
        </div>
      </div>
    );
  }
}
