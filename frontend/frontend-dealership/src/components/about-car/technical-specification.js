import React from "react";

function TechnicalSpecification({ car }){
    return(
        <div id="specification" className="auto-specifications detail-content">
											<div className="section-title">
												<h4>Technical Specifications</h4>
											</div>
											<ul className="row">
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="element-title">
														<i className="cs-color icon-engine"></i>
														<span>Двигун і трансмісія</span>
													</div>
												</li>
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="specifications-info">
														<ul>
															<li>
																<span>Назва двигуна</span>
																<strong>{car.engine.engineName}</strong>
															</li>
															<li>
																<span>Тип пального</span>
																<strong>{car.engine.fuelType}</strong>
															</li>
															<li>
																<span>Кількість циліндрів</span>
																<strong>{car.engine.numberOfCylinders}</strong>
															</li>
															<li>
																<span>Об'єм двигуна</span>
																<strong>{car.engine.engineCapacity} л.</strong>
															</li>
															<li>
																<span>Потужність</span>
																<strong>{car.engine.power} к.с.</strong>
															</li>
														</ul>
													</div>
												</li>
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="specifications-info">
														<ul>
															<li>
																<span>Назва трансмісії</span>
																<strong>{car.gearbox.gearboxName}</strong>
															</li>
															<li>
																<span>Модель трансмісії</span>
																<strong>{car.gearbox.gearboxModel}</strong>
															</li>
															<li>
																<span>Тип трансмісії</span>
																<strong>{car.gearbox.gearboxType}</strong>
															</li>
															<li>
																<span>Кількість ступеней</span>
																<strong>{car.gearbox.stages}</strong>
															</li>
															<li>
																<span>Привід</span>
																<strong>{car.gearbox.drive}</strong>
															</li>
														</ul>
													</div>
												</li>
											</ul>
											<ul className="row">
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="element-title">
														<i className="cs-color icon-vehicle92"></i>
														<span>Габарити та дод. інформація</span>
													</div>
												</li>
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="specifications-info">
														<ul>
															<li>
																<span>Тип кузову</span>
																<strong>{car.bodyType.bodyTypeName}</strong>
															</li>
															<li>
																<span>Довжина</span>
																<strong>{car.length} мм</strong>
															</li>
															<li>
																<span>Ширина</span>
																<strong>{car.width} мм</strong>
															</li>
															<li>
																<span>Висота</span>
																<strong>{car.height} мм</strong>
															</li>
															<li>
																<span>Кліренс</span>
																<strong>{car.clearance} мм</strong>
															</li>
															<li>
																<span>Кількість дверей</span>
																<strong>{car.doorCount}</strong>
															</li>
															<li>
																<span>Кількість сидінь</span>
																<strong>{car.seatCount}</strong>
															</li>
															<li>
																<span>Об'єм багажника</span>
																<strong>{car.trunkVolume} л.</strong>
															</li>
														</ul>
													</div>
												</li>
												<li className="col-lg-4 col-md-4 col-sm-12 col-xs-12">
													<div className="specifications-info">
														<ul>
															<li>
																<span>Максимальна швидкість</span>
																<strong>{car.maxSpeed} км/год</strong>
															</li>
															<li>
																<span>Розхід пального</span>
																<strong>{car.fuelUsage} л/км</strong>
															</li>
															<li>
																<span>Рік випуску</span>
																<strong>{car.yearOfCreation}</strong>
															</li>
														</ul>
													</div>
												</li>
											</ul>
										</div>
    )
}

export default TechnicalSpecification;