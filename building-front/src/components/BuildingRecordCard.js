import React, {Component} from "react";
// import { Link } from "react-router-dom";
import {CardWrapper} from "./CardWrapper";
import img from "../img/building.jpg";

export default class BuildingRecordCard extends Component {
    render() {
        const {
            // id,
            addressCity,
            addressStreet,
            addressNumber,
            // ownerPersonalNumber,
            // ownerFirstName,
            // ownerLastName,
            sizeInSquareMeters,
            marketValue,
            propertyTypeName,
        } = this.props;
        return (
            <CardWrapper className="col-sm-6 col-md-4 col-lg-4 col-xl-4">
                <div className="card">
                    <div className="img-container">
                        <div className="img-container">
                            <img src={img} alt="greeting" className="card-img-top"/>
                        </div>
                    </div>
                    <div className="card-body">
                        <h4 className="card-title">{propertyTypeName}</h4>
                        <h3 className="card-title">City: {addressCity}</h3>
                        <h5 className="card-title">
                            Street: {addressStreet} {addressNumber}
                        </h5>
                        {/* <p className="text-center card-text">{id}</p> */}
                        <p className="text-center">Size: {sizeInSquareMeters}m²</p>
                        <p className="text-center">Price {marketValue}€</p>
                    </div>
                </div>
            </CardWrapper>
        );
    }
}
// Product.propTypes = {
//   product: PropTypes.shape({
//     id: PropTypes.number,
//     imgUrl: PropTypes.string,
//     price: PropTypes.number,
//     details: PropTypes.string,
//     model: PropTypes.string,
//     brand: PropTypes.string,
//     inCart: PropTypes.bool,
//   }).isRequired,
// };
