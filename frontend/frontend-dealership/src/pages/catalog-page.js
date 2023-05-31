import React from "react";
import CarCard from "../components/catalog/car-card";
import Sidebar from "../components/catalog/sidebar";
import { instance } from "../utils/axios/axiosConfig";

function CatalogPage({carList}){


    return(
        <div div className="wp-automobile">
            <div className="wrapper">
                <div className="main-section">
                    <div className="page-section">
                        <div className="container">
                            <div className="row">
                                <Sidebar/>
                                <div className="section-content col-lg-9 col-md-9 col-sm-12 col-xs-12">
                                    <div className="row">
                                        <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                                            {
												carList.map(element => (
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