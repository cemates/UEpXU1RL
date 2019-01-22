import "./styles.css";
import React from "react";
import ReactDOM from "react-dom";
import Layout from "./Components/Layout";

var myArr = ["Huseyin Cem Ates", "Mckenzie Wallace", "Lorem Ipsum"];
ReactDOM.render(
  <div>
    <Layout
      footer="2019 - PJWSTK"
      myArray={myArr}
    />
  </div>,
  document.getElementById("app")
);
