import React from "react";

const Checkbox = ({ id, title}) => {
    return (
      <li key={id}>
        <div className="checkbox">
          <input id={id} type="checkbox" value="Speed" />
          <label htmlFor={id}>{title}</label>
        </div>
      </li>
    );
  };

export default Checkbox;