import React from "react";
import AdminCarItem from "./admin-car-item";

function AdminCarList({carList, getCarList}){
    return(
        <ul className="cs-featurelisted-car">
            {carList.map(car => (
                <AdminCarItem car={car} getCarList={getCarList}/>
            ))}  
        </ul>
    )
}

export default AdminCarList;