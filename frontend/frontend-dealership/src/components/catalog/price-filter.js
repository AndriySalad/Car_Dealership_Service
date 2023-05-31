import React from "react";

const PriceFilter = () => {
    return (
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
                    <input placeholder="Ціна до:" className="chosen-select-no-single" tabIndex="5" />
                    </div>
                </div>
                </div>
            </div>
        </div>
    );
};
  
export default PriceFilter;