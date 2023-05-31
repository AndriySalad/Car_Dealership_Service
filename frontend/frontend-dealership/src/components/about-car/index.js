import React from "react";
import Slider1 from "../slider/slider";
import CarInfo from "./car-info";

function PageCar({car}) {
    return (
        <div className="wrapper">
            <Slider1 
                images={car.attachments} 
                status={car.status} 
                id={car.id}
            />
            <div className="main-section">
                <CarInfo car={car}/>
            </div>
        </div>
    )
}

export default PageCar;