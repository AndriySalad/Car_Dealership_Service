import React from "react";
import Option from "./option";

function Select({years}) {
    return(
        <select data-placeholder="Recent Added" className="chosen-select-no-single" tabIndex="5">
            {years.map((obj) => (<Option id={obj.id} year={obj.year}/>))}
        </select>
    )
}

export default Select; 