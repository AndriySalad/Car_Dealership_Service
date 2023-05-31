import React from "react";
import Select from "./select";

const YearFilter = () => {

    const years = [
        {
            id: 0,
            year: 2002
        },
        {
            id: 1,
            year: 2003
        },
        {
            id: 2,
            year: 2019
        },
        {
            id: 3,
            year: 2021
        },
        {
            id: 4,
            year: 2022
        },
        {
            id: 5,
            year: 2023
        },
    ];

    return (
      <div className="panel panel-default">
        <div className="panel-heading" role="tab" id="headingOne">
          <a role="button" data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            Роки
          </a>
        </div>
        <div id="collapseOne" className="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
          <div className="panel-body">
            <div className="cs-model-year">
              <div className="cs-select-filed">
                <Select years={years}/>
              </div>
              <span>до</span>
              <div className="cs-select-filed">
                <Select years={years}/>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
};

export default YearFilter;