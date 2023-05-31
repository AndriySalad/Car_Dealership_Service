import React from "react";

import Checkbox from "./checkbox";

const Filter = ({title, children}) => {
    return (
      <div className="panel panel-default">
          <div className="panel-heading" role="tab" id="headingFour">
              <a className="collapsed" role="button" data-toggle="collapse" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                  {title}
              </a>
          </div>
        <form>
          <ul className="cs-checkbox-list mCustomScrollbar" data-mcs-theme="dark">
            {children.map((obj) => (<Checkbox id={obj.title + obj.id} title={obj.title}/>))}
          </ul>
        </form>
      </div>
    );
  };

export default Filter;