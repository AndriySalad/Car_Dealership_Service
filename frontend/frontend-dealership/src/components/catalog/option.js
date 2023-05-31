import React from "react";

function Option({id, year}){
    return(
        <option key={id}>{year}</option>
    );
}

export default Option;