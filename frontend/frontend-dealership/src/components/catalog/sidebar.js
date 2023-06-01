import React, { useState } from 'react';


const Sidebar = ({
        carName, 
        setCarname,
        price,
        setPrice
    }) => {
       

    return (
        <aside className="section-sidebar col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div className="cs-listing-filters">
                <div className="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div className="panel panel-default">
                        <div className="panel-heading" role="tab" id="headingTwo">
                            <a role="button" data-toggle="collapse" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                Пошук за назвою
                            </a>
                        </div>
                        <div id="collapseTwo" className="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
                            <div className="panel-body">
                            <div className="cs-model-year">
                                <div className="cs-select-filed">
                                    <input placeholder="Модель/Марка:" className="chosen-select-no-single" tabIndex="5" value={carName} onChange={(e) => setCarname(e.target.value)}/>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                    <div className="panel panel-default">
                        <div className="panel-heading" role="tab" id="headingTwo">
                            <a role="button" data-toggle="collapse" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                            Ціна
                            </a>
                        </div>
                        <div id="collapseTwo" className="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
                            <div className="panel-body">
                            <div className="cs-model-year">
                                <div className="cs-select-filed">
                                    <input placeholder="Ціна до:" className="chosen-select-no-single" tabIndex="5" value={price} onChange={(e) => setPrice(e.target.value)}/>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </aside>
    );
};

export default Sidebar;
