import React from "react";

function ShortInfo({ year, gearbox, fuelType, description, millage }) {
    return(
        <div id="vehicle" className="auto-overview detail-content">
            <ul className="row">
                <li className="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div className="cs-media">
                        <figure><i className="icon-driving2 cs-color"></i></figure>
                    </div>
                    <div className="auto-text">
                        <span>Рік</span>
                        <strong>{year}</strong>
                    </div>
                </li>
                <li className="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div className="cs-media">
                        <figure><i className="icon-vehicle92 cs-color"></i></figure>
                    </div>
                    <div className="auto-text">
                        <span>Пробіг</span>
                        <strong>{millage}</strong>
                    </div>
                </li>
                <li className="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div className="cs-media">
                        <figure><i className="icon-engine cs-color"></i></figure>
                    </div>
                    <div className="auto-text">
                        <span>Трансмісія</span>
                        <strong>{gearbox}</strong>
                    </div>
                </li>
                <li className="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                    <div className="cs-media">
                        <figure><i className="icon-gas20 cs-color"></i></figure>
                    </div>
                    <div className="auto-text">
                        <span>Тип пального</span>
                        <strong>{fuelType}</strong>
                    </div>
                </li>
            </ul>
            <p className="more-text" style={{display: 'block'}}>
                {description}
            </p>
        </div>
    )
}

export default ShortInfo;