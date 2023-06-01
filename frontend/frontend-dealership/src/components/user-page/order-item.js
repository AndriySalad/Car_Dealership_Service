import React from "react";
import { Link } from "react-router-dom";

function OrderItem({order}){
    return(
        <li className="col-lg-12 col-md-12 col-sm-12 col-xs-12" key={order.id}>
            <div className="cs-media" style={{width:"25%", height:"100%"}}>
                    <figure><Link to={`/${order.car.id}`}><img src={order.car.attachments[0].linkFile} alt="" style={{width:"100%", height:"100%"}}/></Link></figure>
            </div>
            <div className="cs-text">
                
                <address>{`Ім'я: ${order.user.firstName} ${order.user.lastName}; Тел.: ${order.user.phoneNumber}`}</address>
                <h6><Link to={`/${order.car.id}`} >{`${order.car.carBrand.carBrandName} ${order.car.model}`}</Link></h6>
                <div className="cs-price">
                    <span className="cs-color">${Math.floor(order.car.price/1000000)} {Math.floor(order.car.price%1000000/1000)} {order.car.price % 1000}</span>
                </div>
            </div>
        </li> 
    )
};

export default OrderItem;