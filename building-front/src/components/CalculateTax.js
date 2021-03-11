import React, { Component } from "react";
import BuildingRecordService from "../services/building-record";

class CalculateTax extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ownerPersonalNumber: "",
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ ownerPersonalNumber: event.target.value });
  }

  handleSubmit = async (e) => {
    // alert("A name was submitted: " + this.state.ownerPersonalNumber);
    e.preventDefault();
    BuildingRecordService.calculateOwnersTax(
      this.state.ownerPersonalNumber
    ).then(
      (res) => {
        console.log(res);
        alert("your total yearly tax is " + res.data + "€");
      },
      (error) => {
        console.log(error);
        alert("Owner personal number not found");
      }
    );
  };

  render() {
    return (
      <div className="container">
        <div className="row">
          <form
            className="col-12 col-md-12 col-sm-12 mt-5 ml-5"
            onSubmit={this.handleSubmit}
          >
            <label style={{ fontSize: "18px" }}>
              Your Personal Number
              <input
                className="ml-2 mr-2"
                type="text"
                value={this.state.ownerPersonalNumber}
                onChange={this.handleChange}
              />
            </label>
            <button className="btn btn-success" type="submit" value="Calculate">
              Calculate
            </button>
          </form>
        </div>
      </div>
    );
  }
}

export default CalculateTax;
