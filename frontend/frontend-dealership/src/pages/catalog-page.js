import React, {useState, useEffect} from "react";
import CarCard from "../components/catalog/car-card";
import Sidebar from "../components/catalog/sidebar";
import CarBaner from "../components/search-bar/car-baner";
import Panel from "../components/search-bar/panel";

function CatalogPage({carList, getCarList}){

    useEffect(() => {
        getCarList()
    }, [])

    const [carName, setCarname] = useState("");
    const [price, setPrice] = useState(null); 

    const [filteredList, setFilteredList] = useState([]);
    
    useEffect(() => {
        filterCars();
    }, [carName, price]);
    
    const filterCars = () => {
    const filteredCars = carList.filter((car) => {
        const isCarNameMatch = car.model.toLowerCase().includes(carName.toLowerCase());
        const isCarBrandMatch = car.carBrand.carBrandName.toLowerCase().includes(carName.toLowerCase());
        const isCarPriceMatch = price ? car.price <= price : true;
        return isCarNameMatch && isCarPriceMatch || isCarBrandMatch && isCarPriceMatch;
    });

    setFilteredList(filteredCars);
    };

    return(
        <div div className="wp-automobile">
            <div className="wrapper">
                <div className="main-section">
                    <CarBaner/>
                    <Panel/>
                    <div className="page-section">
                        <div className="container">
                            <div className="row">
                                <Sidebar 
                                    carName={carName} 
                                    setCarname={setCarname} 
                                    price={price} 
                                    setPrice={setPrice}
                                />
                                <div className="section-content col-lg-9 col-md-9 col-sm-12 col-xs-12">
                                    <div className="row">
                                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                                            {
												filteredList.map(element => (
													<CarCard 
														id={element.id} 
														model={element.model}
														carBrand={element.carBrand} 
														price={element.price} 
														attachments={element.attachments}
													/>))
											}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>
            </div>
        </div>
    )
}

export default CatalogPage;