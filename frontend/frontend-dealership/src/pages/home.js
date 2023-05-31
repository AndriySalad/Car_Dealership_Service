import React from "react";
import WhyChooseUsSection from "../components/about-us/about-us-block";
import CarBaner from "../components/search-bar/car-baner";
import Panel from "../components/search-bar/panel";
import CarList from "../components/catalog/car-list";



function HomePage({carList}){

    const sectionStyles = {
        sectionTitle: {
            textAlign: "center",
            color: "#333333",
            marginBottom: "45px",
        }
    }

    return(
        <div div className="wp-automobile">
            <div className="wrapper">
                <div className="main-section">
                    <CarBaner/>
                    <Panel/>
                    <CarList listCar={carList}/>
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div className="section-title" style={sectionStyles.sectionTitle}>
                        <h3 style={{ marginBottom: "5px" }}>Чому обрати саме нас?</h3>
                        </div>
                    </div>
                    <WhyChooseUsSection/>
                </div>
            </div>
        </div>
    )
}

export default HomePage;