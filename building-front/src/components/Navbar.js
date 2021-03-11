import React, { Component } from "react";
import { NavLink } from "react-router-dom";
import styled from "styled-components";

export default class Navbar extends Component {
  render() {
    return (
      <NavWrapper className="navbar navbar-expand-lg navbar-light bg-light">
        <NavLink to="/" className="navbar-brand nav-item">
          <i className="fas fa-building">Building Records Home</i>
        </NavLink>
        {/* <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button> */}

        {/* <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item active"> */}
        <NavLink to="/create" className="nav-link nav-item">
          Create building record
          {/* <span className="sr-only">(current)</span> */}
        </NavLink>
        <NavLink to="/admin" className="nav-link nav-item">
          Admin
          {/* <span className="sr-only">(current)</span> */}
        </NavLink>
        <NavLink to="/calculate" className="nav-link nav-item">
          Calculate my Tax
        </NavLink>
        {/* </li>
            </ul>
          </div> */}
      </NavWrapper>
    );
  }
}

const NavWrapper = styled.nav`
  background: var(--mainRed) !important;
  .nav-link {
    color: var(--mainWhite) !important;
    font-size: 1.3rem;
    text-transform: capitalize;
  }
  .nav-link:hover {
    color: var(--buttonBlue) !important;
  }
  .navbar-brand {
    color: gold;
  }
  .navbar-brand:hover {
    color: var(--buttonBlue) !important;
  }
`;
