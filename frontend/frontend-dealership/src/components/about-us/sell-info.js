import React from "react";
import './about-us.css';

function SellInfo({stat}){



    return(
        <div className="page-section" id="page-section-6">
			<div className="container">
				<div className="row">
					<div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div className="cs-counter">
							<div className="cs-media">
								<figure> <i className="icon-truck2 cs-color"> </i> </figure>
							</div>
							<div className="cs-text"> <strong className="counter">{stat.countOrders}</strong> <span>Продано машин</span> </div>
						</div>
					</div>
					<div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div className="cs-counter">
							<div className="cs-media">
								<figure> <i className="icon-car36  cs-color"> </i> </figure>
							</div>
							<div className="cs-text"> <strong className="counter">{stat.countCars}</strong> <span>Машин в наявності</span> </div>
						</div>
					</div>
					<div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div className="cs-counter">
							<div className="cs-media">
								<figure> <i className="icon-settings  cs-color"> </i> </figure>
							</div>
							<div className="cs-text"> <strong className="counter">{stat.countUsers}</strong> <span>Зареєстрованих користувачів</span> </div>
						</div>
					</div>
					<div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div className="cs-counter">
							<div className="cs-media">
								<figure> <i className="icon-directions_car cs-color"> </i> </figure>
							</div>
							<div className="cs-text"> <strong className="counter">4</strong> <span>Співпрацівників</span> </div>
						</div>
					</div>
				</div>
			</div>
		</div>
    )
}

export default SellInfo;