import React from "react";


import img2 from "../../extra-images/image-frame-1.png";

import "./car-baner.css";

function CarBaner(){
    return(
        <>
            <div className="page-section" id="page-section-1">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div className="image-frame defualt">
                                <div className="cs-media">
                                    <figure> <img src={img2} alt=""/> </figure>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div className="cs-column-text">
                                <h1>
                                    Скажи привіт
                                    Твоїй новій 
                                    машині
                                    </h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default CarBaner;