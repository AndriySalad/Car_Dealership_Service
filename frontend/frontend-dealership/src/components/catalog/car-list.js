import React from "react";
import CarCard from "./car-card";

function CarList({listCar}) {
    return(
        
			<div className="container">
				<div className="row">
					<div className="section-fullwidtht col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div className="row">
							<div className="col-lg-12 col-md-12 co-sm-12 col-xs-12">
								<div className="cs-section-title">
									<h3>Чудова машина для тебе</h3>
								</div>
								<div className="cs-tabs full-width">
									<div id="home" className="tab-pane fade in active">
										<div className="row">
											{
												listCar.map(element => (
													<CarCard 
														id={element.id} 
														model={element.model}
														carBrand={element.carBrand} 
														price={element.price} 
														attachments={element.attachments}
													/>
												))
											}
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

export default CarList;