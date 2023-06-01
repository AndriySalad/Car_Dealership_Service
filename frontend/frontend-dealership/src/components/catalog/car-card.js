import React from "react";
import { Link } from "react-router-dom";

function CarCard({
    id,
    model,
    carBrand,
    price,
    attachments
}){
    return(
        <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12" key={id}>
            <div className="auto-listing auto-grid">
                <div className="cs-media">
                    <img src={attachments[0].linkFile} style={{ maxWidth: '100%', maxHeight: '100%' }} alt="#"/>
                </div>
                <div className="auto-text">
                    <div className="post-title">
                        <h6><Link to={`/${id}`}>{carBrand.carBrandName} {model}</Link></h6>
                        <div className="auto-price"><span className="cs-color">${price}</span></div>
                    </div>
                    <Link to={`/${id}`} className="View-btn">Переглянути деталі<i className=" icon-arrow-long-right"></i></Link> </div>
            </div>
        </div>
    )
}

export default CarCard;