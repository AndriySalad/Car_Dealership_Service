import React from "react";
import './car-info.css';
import ShortInfo from "./short-info";
import TechnicalSpecification from "./technical-specification";

function CarInfo({car}){

    return(
        <div className="page-section" id="page-section-4">
        	<div className="container">
            	<div className="row">
                	<div className="custom-content col-lg-9 col-md-9 col-sm-12 col-xs-12">
                    	<div className="page-section">
                            <div className="row">
                                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div className="car-detail-heading">
                                        <div className="auto-text">
                                        	<h2>{car.carBrand.carBrandName} {car.model}</h2>
                                        </div>
                                        <div className="auto-price"><span className="cs-color">${Math.floor(car.price/1000000)} {Math.floor(car.price%1000000/1000)} {car.price % 1000}</span></div>
                                    </div>
                                </div>
                                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div className="on-scroll">
										<ShortInfo 
                                            year={car.yearOfCreation} 
                                            gearbox={car.gearbox.gearboxType} 
                                            fuelType={car.engine.fuelType} 
                                            description={car.description}
                                            millage={car.millage}
                                        />
										<TechnicalSpecification car={car}/>
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

export default CarInfo;