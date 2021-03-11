import React from "react";
import {BrowserRouter, Switch, Route} from "react-router-dom";
import "./App.css";
import BuildingRecordCreation from "./components/BuildingRecordCreation";
import Navbar from "./components/Navbar";
import Home from "./components/Home";
import Admin from "./components/Admin";
import CalculateTax from "./components/CalculateTax";
import BuildingRecordUpdate from "./components/BuildingRecordUpdate";

function App() {
    return (
        <React.Fragment>
            <BrowserRouter>
                <Navbar/>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route path="/create" component={BuildingRecordCreation}/>
                    <Route path="/admin" component={Admin}/>
                    <Route path="/calculate" component={CalculateTax}/>
                    <Route path="/update/:id" component={BuildingRecordUpdate}/>
                </Switch>
            </BrowserRouter>
        </React.Fragment>
    );
}

export default App;
