import React from "react";
import AdminCarItem from "./admin-car-item";

function AdminCarList({carList}){
    return(
        <ul className="cs-featurelisted-car">
            {carList.map(car => (
                <AdminCarItem car={car}/>
            ))}  
        </ul>
    )
}

export default AdminCarList;