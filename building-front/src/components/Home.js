import React, {Component} from "react";
import BuildingRecordService from "../services/building-record";
import BuildingRecordCard from "../components/BuildingRecordCard";

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            records: [],
        };
    }

    componentDidMount = async () => {
        await BuildingRecordService.getAllBuildingRecords().then(
            (res) => {
                console.log(res.data);
                this.setState({records: res});
            },
            (error) => console.log(error)
        );
    };

    render() {
        const {data} = this.state.records;
        if (data) {
            return (
                <div className="container">
                    <div className="thumbnail row d-flex justify-content-center">
                        {data.map(({id, ...otherProps}) => (
                            <BuildingRecordCard key={id} id={id} {...otherProps} />
                        ))}
                    </div>
                </div>
            );
        } else {
            return (
                <div className="container mt-5">
                    <h5>Building Records is loading...</h5>
                </div>
            );
        }
    }

    //   const { products } = this.state.products;
    //   console.log(products);

    //   console.log(products);
    //   return (
    //     <div>
    //       {products.map((item) => {
    //         return (
    //           <Product key={id} id={id} itemImge={itemImg} {...otherProps} />
    //         );
    //       })}
    //     </div>
    //   );
    // }
}

export default Home;
