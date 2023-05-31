import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";

function AdminCarItem({ car }) {
    const token = sessionStorage.getItem("token");
    const deleteHandler = async (e) => {
        e.preventDefault();

        const confirmation = window.confirm(`Ви впевнені, що хочете видалити автомобіль: ${car.carBrand.carBrandName} ${car.model}?`);

        if(confirmation){
            axios.delete(`http://localhost:8080/admin/car/delete/${car.id}`, {
            headers: {
                Authorization: `Bearer ${token}`
            }
            }).then(response => {
                alert(`${car.model} успішно видалено`)
            }).catch(error => {
                alert("Ойойой... щось пішло не так.")
            })
        }
    }

    const trashStyle = car.status === "SOLD" ? "none" : "blok";


    return(
        <li className="col-lg-12 col-md-12 col-sm-12 col-xs-12" key={car.id}>
            <div className="cs-media">
                <figure><Link to={`/${car.id}`}><img src={car.attachments[0].linkFile} alt="" style={{width:"100%", height:"100%"}}/></Link></figure>
            </div>
            <div className="cs-text">
                <h6><Link to={`/${car.id}`}>{car.carBrand.carBrandName} {car.model}</Link></h6>
                <div className="post-options">
                    <span>Рік <em>{car.yearOfCreation}</em></span>
                </div>
                <div className="cs-post-types">
                    <div className="cs-post-list">
                        <div className="cs-list">
                            <Link data-toggle="tooltip" data-placement="top" title="Delete" onClick={deleteHandler} style={{display: `${trashStyle}`}} ><i className="icon-trash-o"></i></Link>
                        </div>
                    </div>
                    <span className="cs-default-btn">{car.status === "AVAILABLE" ? "Наявна" : "Продано"}</span>
                </div>
            </div>
        </li>
    )
}

export default AdminCarItem;